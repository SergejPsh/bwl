package org.test.bwl.api

import akka.http.scaladsl.server.HttpApp
import com.datastax.driver.mapping.Result
import org.test.bwl.model.conf.{Conf, DB}
import org.test.bwl.model.dao.{User, UserAccessor}

object App extends HttpApp with DB {

  def main(args: Array[String]): Unit = {
    //startServer("0.0.0.0", 8080)
    println(conf.getList("client.db.contact.points"))

  }

  override def routes = pathSingleSlash {
    complete("Hello Akka!")
  }
}