use travel_agency;
CREATE TABLE IF NOT EXISTS countries(
  id INT PRIMARY KEY AUTO_INCREMENT,
  country VARCHAR(256) NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS cities(
 id INT PRIMARY KEY AUTO_INCREMENT,
    city VARCHAR(256) NOT NULL,
    id_country INT NOT NULL,
    FOREIGN KEY (id_country) REFERENCES countries(id) ON DELETE CASCADE,
  CONSTRAINT city_in_country UNIQUE (city, id_country)
);
CREATE TABLE IF NOT EXISTS hotels (
    id INT PRIMARY KEY AUTO_INCREMENT,
 id_city INT NOT NULL,
 name INT NOT NULL,
    star_rating INT NOT NULL,
    distance_from_center INT NOT NULL,
    property_type VARCHAR(256) NULL, 
     CONSTRAINT hotels_in_city
     FOREIGN KEY (id_city) REFERENCES cities(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS person (
  id INT PRIMARY KEY NOT NULL,
  firstName VARCHAR(45) NULL,
  lastName VARCHAR(45) NULL,
  passport VARCHAR(45) NULL,
  country VARCHAR(45) NULL,
  age VARCHAR(45) NULL,
  visa INT NOT NULL
);
CREATE TABLE IF NOT EXISTS person_country(
 id_person INT NOT NULL,
 id_country INT NOT NULL,
    FOREIGN KEY (id_person) REFERENCES person(id) ON DELETE CASCADE,
    FOREIGN KEY (id_country) REFERENCES countries(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS visa (
 id INT PRIMARY KEY AUTO_INCREMENT,
 visa_number INT NOT NULL,
 issue INT NOT NULL,
 expiration INT NOT NULL,
id_country INT NOT NULL,
id_person INT NOT NULL,
FOREIGN KEY (id_country) REFERENCES countries(id),
FOREIGN KEY (id_person) REFERENCES person(id)
);
CREATE TABLE IF NOT EXISTS rooms (
id INT PRIMARY KEY NOT NULL,
room_number INT UNIQUE,
id_hotel INT NOT NULL,
id_city INT NOT NULL,
 luxury ENUM('ECONOM', 'STANDARD', 'BUSINESS', 'PREMIUM'),
bedrooms ENUM('SINGLE', 'DOUBLE', 'TRIPLE', 'APARTMENT'),
FOREIGN KEY (id_hotel) REFERENCES hotels(id),
FOREIGN KEY (id_city) REFERENCES cities(id),
CONSTRAINT rooms_in_hotel UNIQUE (room_number, id_hotel) 
);

CREATE TABLE IF NOT EXISTS bookings(
  id INT PRIMARY KEY AUTO_INCREMENT,
    id_person INT,
    order_date DATETIME,
    checkin DATE,
    checkout DATE,
    id_room INT,
    id_hotel INT,
    FOREIGN KEY (id_person) REFERENCES person(id) ON DELETE CASCADE,
    FOREIGN KEY (id_room) REFERENCES rooms(id) ON DELETE CASCADE,
    FOREIGN KEY (id_hotel) REFERENCES hotels(id) ON DELETE CASCADE
);

select cities.city, countries.country from cities inner join countries on cities.id_country = countries.id;
select hotels.name as hotel, cities.city from hotels inner join cities on hotels.id_city = cities.id;
