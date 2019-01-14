USE bwl_dict;

CREATE TABLE black_list_rules (
  msisdn BIGINT PRIMARY KEY,
  shortNumbers SET<TEXT>
);