USE bwl_dict;

CREATE TABLE black_list_rules (
  msisdn TEXT PRIMARY KEY,
  shortNumbers SET<TEXT>
);