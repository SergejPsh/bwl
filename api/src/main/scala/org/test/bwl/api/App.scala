package org.test.bwl.api

import akka.http.scaladsl.server.HttpApp
import org.test.bwl.api.route.ApiRoute

object App extends HttpApp with ApiRoute {

  def main(args: Array[String]): Unit =
    startServer("0.0.0.0", 8080)
}