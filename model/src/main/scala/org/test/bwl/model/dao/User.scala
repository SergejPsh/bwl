package org.test.bwl.model.dao

import java.util.UUID

import com.datastax.driver.mapping.Result
import com.datastax.driver.mapping.annotations.{Accessor, PartitionKey, Query, Table}

@Accessor trait UserAccessor{
  @Query("SELECT * FROM bwl_dict.users") def getAll: Result[User]
}

@Table(keyspace = "bwl_dict", name = "users", readConsistency = "ONE", writeConsistency = "ONE")
case class User(@PartitionKey id: UUID, allowedid: Set[String], login: String, password: String, roles: Set[String]){
  def this() = this(id = null, allowedid = null, login = null, password = null, roles = null)
}
