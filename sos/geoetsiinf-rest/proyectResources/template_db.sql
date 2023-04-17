DROP TABLE IF EXISTS users,
treasures,
found_treasures,
friends;
USE geoetsiinfdb;
CREATE TABLE users (
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  user_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  postal_code INT NOT NULL,
  user_number int NOT NULL AUTO_INCREMENT,
  KEY (user_number),
  PRIMARY KEY(user_name)
);
CREATE TABLE treasures (
  treasure_name VARCHAR(255) NOT NULL,
  coordinate_x FLOAT NOT NULL,
  coordinate_y FLOAT NOT NULL,
  terrain_type VARCHAR(225) NOT NULL,
  difficulty INT NOT NULL,
  size FLOAT NOT NULL,
  hint VARCHAR(255) NOT NULL,
  author_user_name VARCHAR(255) NOT NULL,
  date_added TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  treasure_id INT AUTO_INCREMENT,
  FOREIGN KEY (author_user_name) REFERENCES users(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
  PRIMARY KEY(treasure_id)
);
CREATE TABLE found_treasures (
  user_name VARCHAR(255),
  treasure_id INT,
  FOREIGN KEY (user_name) REFERENCES users(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (treasure_id) REFERENCES treasures(treasure_id) ON UPDATE CASCADE ON DELETE CASCADE,
  PRIMARY KEY(user_name, treasure_id)
);
CREATE TABLE friends (
  user_name_1 VARCHAR(255),
  user_name_2 VARCHAR(255),
  FOREIGN KEY (user_name_1) REFERENCES users(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (user_name_2) REFERENCES users(user_name) ON UPDATE CASCADE ON DELETE CASCADE,
  PRIMARY KEY(user_name_1, user_name_2)
);
-- ####### TESTING #######
INSERT INTO
  users(
    first_name,
    last_name,
    user_name,
    email,
    postal_code
  )
VALUES(
    "Anakin",
    "Skywalker",
    "anakin",
    "anakin@jediorder.org",
    28017
  );
INSERT INTO
  users(
    first_name,
    last_name,
    user_name,
    email,
    postal_code
  )
VALUES(
    "Ana",
    "Skywalker",
    "ana",
    "ana@jediorder.org",
    28017
  );
INSERT INTO
  users(
    first_name,
    last_name,
    user_name,
    email,
    postal_code
  )
VALUES(
    "Pepe",
    "Skywalker",
    "pepe",
    "pepe@jediorder.org",
    28017
  );
INSERT INTO
  friends
VALUES("anakin", "ana");
INSERT INTO
  friends
VALUES("anakin", "pepe");
SELECT
  *
FROM
  users u
  INNER JOIN friends f ON u.user_name = f.user_name_2
WHERE
  f.user_name_1 = "anakin";
SELECT
  *
FROM
  users u
  INNER JOIN friends f ON u.user_name = f.user_name_2
WHERE
  f.user_name_1 = "anakin"
  AND u.first_name LIKE "%n%";
INSERT INTO
  treasures(
    treasure_name,
    coordinate_x,
    coordinate_y,
    terrain_type,
    difficulty,
    size,
    hint,
    author_user_name
  )
VALUES(
    "chest",
    0.0,
    0.0,
    "sandy",
    5,
    100.5,
    "X on the map",
    "anakin"
  );
INSERT INTO
  treasures(
    treasure_name,
    coordinate_x,
    coordinate_y,
    terrain_type,
    difficulty,
    size,
    hint,
    author_user_name
  )
VALUES(
    "tomb",
    10.5,
    -10.5,
    "desertic",
    5,
    100.5,
    "below a pyramid",
    "anakin"
  );
INSERT INTO
  found_treasures
VALUES("anakin", 1);
INSERT INTO
  found_treasures
VALUES("anakin", 2);
SELECT
  *
FROM
  treasures t
  INNER JOIN found_treasures f ON t.treasure_id = f.treasure_id
WHERE
  f.user_name = "anakin"
ORDER BY
  date_added DESC;
SELECT
  *
FROM
  treasures t
  INNER JOIN found_treasures f ON t.treasure_id = f.treasure_id
WHERE
  f.user_name = "anakin"
  AND date_added < "2022-04-13 22:15:32"
ORDER BY
  date_added DESC;
SELECT
  *
FROM
  users
WHERE
  user_name = "anakin";
SELECT
  *
FROM
  treasures
WHERE
  author_user_name = "anakin";
DELETE FROM
  TREASURES
WHERE
  author_user_name = 'anakin'
  AND treasure_id = 3;
SELECT
  *
from
  treasures
WHERE
  treasure_id > 1
  AND treasure_id < 8
  AND difficulty = 5
  AND date_added < '2022-4-16'
  ;