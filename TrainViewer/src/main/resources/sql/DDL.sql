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
  country_name VARCHAR(50) NOT NULL,
  approved BOOLEAN DEFAULT FALSE NOT NULL,
  FOREIGN KEY (country_name) REFERENCES country(country_name)
  		ON UPDATE CASCADE
  		ON DELETE CASCADE
);

DROP TABLE IF EXISTS alias_unknown;
CREATE TABLE alias_unknown (
	input VARCHAR(50) NOT NULL PRIMARY KEY
	);

DROP TABLE IF EXISTS user_train;
CREATE TABLE user_train (
  user_name VARCHAR(20) NOT NULL PRIMARY KEY,
  user_password VARCHAR(20) NOT NULL,
  user_mail VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS train;
CREATE TABLE train (
  id_train INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  serial_number_train VARCHAR(10) NOT NULL,
  brand VARCHAR(20) NOT NULL
);

DROP TABLE IF EXISTS trip;
CREATE TABLE trip(
	id_trip INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_train INT NOT NULL,
	departure VARCHAR(50) NOT NULL,
	arrive VARCHAR(50) NOT NULL,
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
  id_score INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(20) NOT NULL,
  user_score INT NOT NULL,
  FOREIGN KEY (user_name) REFERENCES user_train(user_name) 
  		ON UPDATE CASCADE
  		ON DELETE CASCADE
);

DROP TABLE IF EXISTS game_data;
CREATE TABLE game_data (
    username VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    score INT(10) NULL DEFAULT NULL
)