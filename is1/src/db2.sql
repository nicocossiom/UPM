DROP TABLE IF EXISTS madrid2;
CREATE TABLE madrid2 (
    id INT,
    lon FLOAT,
    lat FLOAT,
    name VARCHAR(255),
    opening_hours VARCHAR(255),
    website VARCHAR(255), 
    phone VARCHAR(255), 
    PRIMARY KEY (id)
);