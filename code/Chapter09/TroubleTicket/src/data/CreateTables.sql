CREATE TABLE TICKET (
  ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  SUMMARY VARCHAR(512) NOT NULL,
  DETAIL VARCHAR(2000),
  SUBMITTED TIMESTAMP,
  LASTMODIFIED TIMESTAMP
);


INSERT INTO TICKET (SUMMARY, DETAIL, SUBMITTED, LASTMODIFIED) VALUES ('Not enough memory.','I do not have enough memory to run Microsoft Windows XP and Microsoft Word.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO TICKET (SUMMARY, DETAIL, SUBMITTED, LASTMODIFIED) VALUES ('Computer wont.','Nothing appears on the monitor even though the hard drive is on.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO TICKET (SUMMARY, DETAIL, SUBMITTED, LASTMODIFIED) VALUES ('Windows Crashed Again','Windows always crashes when I turn on my computer.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO TICKET (SUMMARY, DETAIL, SUBMITTED, LASTMODIFIED) VALUES ('Popups are slowing down my computer','I get so many popup adds, my computer is unusable.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO TICKET (SUMMARY, DETAIL, SUBMITTED, LASTMODIFIED) VALUES ('Monitor flickers cool.','Everytime the heat comes on my monitor flickers.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO TICKET (SUMMARY, DETAIL, SUBMITTED, LASTMODIFIED) VALUES ('Cannot connect to the network.','I can not see my network drives.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO TICKET (SUMMARY, DETAIL, SUBMITTED, LASTMODIFIED) VALUES ('Not enough memory.','I do not have enough memory to run Microsoft Windows XP and Microsoft Word.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
