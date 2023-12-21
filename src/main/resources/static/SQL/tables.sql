CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY,
 username VARCHAR(30) NOT NULL UNIQUE,
 password CHAR(60) NOT NULL,
 access_level INT NOT NULL);

CREATE TABLE cars (registration_number CHAR(7) PRIMARY KEY,
 user_id INT NOT NULL,
 brand VARCHAR(255) NOT NULL,
 model VARCHAR(255) NOT NULL,
 color VARCHAR(255) NOT NULL,
 fabrication_year INT NOT NULL,
 cylindrical_capacity INT NOT NULL,
 fuel_type VARCHAR(8) NOT NULL,
 power INT NOT NULL,
 torque INT NOT NULL,
 trunk_volume INT NOT NULL,
 price DECIMAL(10, 2) NOT NULL,
 FOREIGN KEY (user_id) REFERENCES users(id));