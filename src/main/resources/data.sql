INSERT INTO SITE (ID, NAME) VALUES('site1', 'Bigcorp Lyon');
INSERT INTO CAPTOR (ID, NAME, site_id) VALUES('c1', 'Eolienne', 'site1');
INSERT INTO CAPTOR (ID, NAME, site_id) VALUES('c2', 'Laminoire à chaud', 'site1');

INSERT INTO MEASURE (INSTANT, VALUE_IN_WATT, CAPTOR_ID) VALUES(PARSEDATETIME ('09-08-18 11:00:00','dd-MM-yy hh:mm:ss', 'fr', 'UTC'), 1000000, 'c1');
INSERT INTO MEASURE (INSTANT, VALUE_IN_WATT, CAPTOR_ID) VALUES(PARSEDATETIME ('09-08-18 11:01:00','dd-MM-yy hh:mm:ss', 'fr', 'UTC'), 1000124, 'c1');
INSERT INTO MEASURE (INSTANT, VALUE_IN_WATT, CAPTOR_ID) VALUES(PARSEDATETIME ('09-08-18 11:02:00','dd-MM-yy hh:mm:ss', 'fr', 'UTC'), 1001234, 'c1');
INSERT INTO MEASURE (INSTANT, VALUE_IN_WATT, CAPTOR_ID) VALUES(PARSEDATETIME ('09-08-18 11:03:00','dd-MM-yy hh:mm:ss', 'fr', 'UTC'), 1001236, 'c1');
INSERT INTO MEASURE (INSTANT, VALUE_IN_WATT, CAPTOR_ID) VALUES(PARSEDATETIME ('09-08-18 11:04:00','dd-MM-yy hh:mm:ss', 'fr', 'UTC'), 1009678, 'c1');
INSERT INTO MEASURE (INSTANT, VALUE_IN_WATT, CAPTOR_ID) VALUES(PARSEDATETIME ('09-08-18 11:00:00','dd-MM-yy hh:mm:ss', 'fr', 'UTC'), -9000000, 'c2');
INSERT INTO MEASURE (INSTANT, VALUE_IN_WATT, CAPTOR_ID) VALUES(PARSEDATETIME ('09-08-18 11:01:00','dd-MM-yy hh:mm:ss', 'fr', 'UTC'), -900124, 'c2');
INSERT INTO MEASURE (INSTANT, VALUE_IN_WATT, CAPTOR_ID) VALUES(PARSEDATETIME ('09-08-18 11:02:00','dd-MM-yy hh:mm:ss', 'fr', 'UTC'), -901234, 'c2');
INSERT INTO MEASURE (INSTANT, VALUE_IN_WATT, CAPTOR_ID) VALUES(PARSEDATETIME ('09-08-18 11:03:00','dd-MM-yy hh:mm:ss', 'fr', 'UTC'), -901236, 'c2');
INSERT INTO MEASURE (INSTANT, VALUE_IN_WATT, CAPTOR_ID) VALUES(PARSEDATETIME ('09-08-18 11:04:00','dd-MM-yy hh:mm:ss', 'fr', 'UTC'), -909678, 'c2');