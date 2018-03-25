DROP TABLE IF EXISTS Lab5Database;

CREATE TABLE lab5database
(
  CarID Serial NOT NULL,
  car_reg VARCHAR(15) NOT NULL,
  travel_direction character varying(9) NOT NULL,
  occupants integer NOT NULL,
  time_entered timestamp without time zone NOT NULL,
  time_exited timestamp without time zone NOT NULL,
  CONSTRAINT lab5database_pkey PRIMARY KEY (CarID)
)

INSERT INTO Lab5Database (car_reg,travel_direction,occupants,time_entered,time_exited) values ('171-KE-2980','Eastbound',3,'2017-01-01 15:15:30','2017-01-01 15:17:50');
INSERT INTO Lab5Database (car_reg,travel_direction,occupants,time_entered,time_exited) values ('161-CD-987','Westbound',1,'2017-02-13 04:30:20','2017-02-13 04:31:40');
INSERT INTO Lab5Database (car_reg,travel_direction,occupants,time_entered,time_exited) values ('J19-CS130','Eastbound',4,'2017-05-31 18:00:00','2017-05-31 18:02:40');
INSERT INTO Lab5Database (car_reg,travel_direction,occupants,time_entered,time_exited) values ('12-WD-1767','Westbound',2,'2017-06-07 07:40:10','2017-06-07 07:41:50');
INSERT INTO Lab5Database (car_reg,travel_direction,occupants,time_entered,time_exited) values ('12-WD-1767','Eastbound',2,'2017-06-07 14:59:00','2017-06-07 15:00:50');

--TRUNCATE Lab5Database
--DELETE FROM Lab5Database

ALTER TABLE lab5database ADD COLUMN Speeding VARCHAR(30);
UPDATE lab5database SET Speeding = NULL;

INSERT INTO Lab5Database (car_reg,travel_direction,occupants,time_entered,time_exited) values ('161-KE-1234','Eastbound',2,'2017-10-25 15:15:00','2017-10-25 15:18:00');
INSERT INTO Lab5Database (car_reg,travel_direction,occupants,time_entered,time_exited) values ('171-D-9988','Eastbound',2,'2017-10-25 15:16:00','2017-10-25 15:19:00');
INSERT INTO Lab5Database (car_reg,travel_direction,occupants,time_entered,time_exited) values ('161-KE-1234','Westbound',2,'2017-10-25 17:18:00','2017-10-25 17:20:30');
INSERT INTO Lab5Database (car_reg,travel_direction,occupants,time_entered,time_exited) values ('171-D-9988','Westbound',2,'2017-10-25 17:19:00','2017-10-25 15:21:30');
