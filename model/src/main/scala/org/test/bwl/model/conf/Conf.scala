package org.test.bwl.model.conf

import org.slf4j.LoggerFactory.getLogger
import com.typesafe.config.ConfigFactory

trait Conf {
  private val log = getLogger(getClass)
  private val config = ConfigFactory.load

  private val active = {
    val active = config.getString("profiles.active")
    log.info(s"Active profile: $active")
    active
  }

  val conf = config.getConfig(s"profiles.$active")
}
