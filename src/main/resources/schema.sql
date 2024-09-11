CREATE TABLE reservation (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    phone_number VARCHAR(255),
    email VARCHAR(255),
    reservation_date_time TIMESTAMP,
    number_of_guests INT
);