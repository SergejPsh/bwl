package org.test.bwl.model.conf

import com.datastax.driver.core.Cluster
import com.datastax.driver.mapping.MappingManager
import com.typesafe.config.ConfigFactory
import org.test.bwl.model.dao.{BlackListRuleAccessor, ConfigAccessor, UserAccessor}

import scala.collection.JavaConverters._

trait DB extends Conf {

  private val contactPoints = conf.getStringList("client.db.contact.points").asScala
  private val port = conf.getInt("client.db.port")
  private val user = conf.getString("client.db.user")
  private val password = conf.getString("client.db.password")

  private val cluster = Cluster.builder
    .addContactPoints(contactPoints: _*)
    .withPort(port)
    .withCredentials(user, password)
    .build

  private val session = cluster.connect("bwl_dict")

  private val configAccessor = new MappingManager(session).createAccessor(classOf[ConfigAccessor])
  private val userAccessor = new MappingManager(session).createAccessor(classOf[UserAccessor])

  val blackListRuleAccessor = new MappingManager(session).createAccessor(classOf[BlackListRuleAccessor])

  // val blackListRuleMapper = new MappingManager(session).mapper(classOf[BlackListRule])

  val configs = ConfigFactory.parseMap(configAccessor.getAll.all.asScala.map(config => (config.key, config.value)).toMap.asJava)
  val users = userAccessor.getAll.all.asScala.map(user => (user.login, user)).toMap
}