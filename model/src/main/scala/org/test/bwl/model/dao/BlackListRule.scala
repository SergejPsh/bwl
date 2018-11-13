package org.test.bwl.model.dao

import com.datastax.driver.mapping.annotations.{PartitionKey, Table}

@Table(keyspace = "bwl_dict", name = "black_list_rules", readConsistency = "ONE", writeConsistency = "ONE")
case class BlackListRule(@PartitionKey msisdn: String, shortNumbers: Set[String]) {
  def this() = this(null, null)
}
