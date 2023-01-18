
DROP SCHEMA IF EXISTS trainviewer;
CREATE SCHEMA trainviewer;
USE trainviewer;

DROP TABLE IF EXISTS country;
CREATE TABLE country (
  country_name VARCHAR(50) NOT NULL PRIMARY KEY,
  alpha2_code VARCHAR(2) NOT NULL
);

DROP TABLE IF EXISTS alias;
CREATE TABLE alias (
  alias_country VARCHAR(50) NOT NULL PRIMARY KEY,
  country_name VARCHAR(50),
  approved TINYINT(1) NOT NULL DEFAULT 0,
  FOREIGN KEY (country_name) REFERENCES country(country_name)
  		ON UPDATE CASCADE
  		ON DELETE CASCADE
);

DROP TABLE IF EXISTS user_train;
CREATE TABLE user_train (
  user_mail VARCHAR(50) NOT NULL PRIMARY KEY,
  user_name VARCHAR(20) NOT NULL,
  user_password VARCHAR(20) NOT NULL,
  user_role ENUM ('client','train manager','train factory', 'admin') NOT NULL
);

DROP TABLE IF EXISTS train;
CREATE TABLE train (
  id_train INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  serial_number_train VARCHAR(10) NOT NULL,
  brand VARCHAR(20) NOT NULL,
  seats INT NOT NULL
 );

DROP TABLE IF EXISTS trip;
CREATE TABLE trip(
	id_trip INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_train INT NOT NULL,
	departure VARCHAR(50) NOT NULL,
	arrive VARCHAR(50) NOT NULL,
	seats_available INT NOT NULL,
	time_departure DATETIME,
	time_arrive DATETIME,
	FOREIGN KEY (departure) REFERENCES country(country_name) 
  		ON UPDATE CASCADE
  		ON DELETE CASCADE,
  	FOREIGN KEY (arrive) REFERENCES country(country_name) 
  		ON UPDATE CASCADE
  		ON DELETE CASCADE,
  	FOREIGN KEY (id_train) REFERENCES train(id_train) 
  		ON UPDATE CASCADE
  		ON DELETE CASCADE
);

DROP TABLE IF EXISTS leaderboard;
CREATE TABLE leaderboard (
  user_mail VARCHAR(20) NOT NULL PRIMARY KEY,
  user_score INT NOT NULL,
  FOREIGN KEY (user_mail) REFERENCES user_train(user_mail) 
  		ON UPDATE CASCADE
  		ON DELETE CASCADE
);

DROP TABLE IF EXISTS reservation;
CREATE TABLE reservation (
	id_reservation INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_trip INT NOT NULL,
	user_mail VARCHAR(50) NOT NULL,
	number_tickets INT NOT NULL,
	FOREIGN KEY (id_trip) REFERENCES trip(id_trip) 
  		ON UPDATE CASCADE
  		ON DELETE CASCADE,
  		
  	FOREIGN KEY (user_mail) REFERENCES user_train(user_mail) 
  		ON UPDATE CASCADE
  		ON DELETE CASCADE
);