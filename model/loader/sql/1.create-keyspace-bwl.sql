DROP KEYSPACE IF EXISTS bwl_dict;

CREATE KEYSPACE bwl_dict
WITH REPLICATION = { 'class': 'SimpleStrategy', 'replication_factor' : 2 };