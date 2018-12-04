package org.test.bwl.model.dao

import com.datastax.driver.mapping.Result
import com.datastax.driver.mapping.annotations.{Accessor, PartitionKey, Query, Table}

@Accessor trait ConfigAccessor {
  @Query("SELECT * FROM bwl_dict.configs") def getAll: Result[Config]
}

@Table(keyspace = "bwl_dict", name = "configs", readConsistency = "ONE", writeConsistency = "ONE")
case class Config(@PartitionKey key: String, value: String) {
  def this() = this(null, null)
}