package org.test.bwl.api.auth

import akka.http.scaladsl.server.directives.Credentials
import akka.http.scaladsl.server.directives.Credentials.Provided
import akka.http.scaladsl.server.{Directives, Route}
import org.test.bwl.model.conf.DB
import org.test.bwl.model.dao.User

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait BasicAuth extends DB with Directives {

  def users: Map[String, User]

  private def userPassAuthenticator(credentials: Credentials) = credentials match {

    case p@Provided(login) => Future {
      users.get(login).filter(user => p.verify(user.password))
    }
    case _ => Future.successful(None)
  }

  def withBasicAuth(f: => Route): Route =

    authenticateBasicAsync("bwl", userPassAuthenticator) { user =>
      f
    }
}