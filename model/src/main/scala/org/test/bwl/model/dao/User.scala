package org.test.bwl.model.dao

import java.util
import java.util.UUID

import com.datastax.driver.mapping.Result
import com.datastax.driver.mapping.annotations.{Accessor, PartitionKey, Query, Table}

@Accessor trait UserAccessor {
  @Query("SELECT * FROM bwl_dict.users") def getAll: Result[User]
}

@Table(keyspace = "bwl_dict", name = "users", readConsistency = "ONE", writeConsistency = "ONE")
case class User(@PartitionKey id: UUID, login: String, password: String, allowedIp: util.Set[String], roles: util.Set[String]) {
  def this() = this(null, null, null, null, null)
}