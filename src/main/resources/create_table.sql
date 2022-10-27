CREATE TABLE IF NOT EXISTS devices (
	id INT NOT NULL AUTO_INCREMENT,
	physicalAddress VARCHAR(17) NOT NULL UNIQUE,
	ipAddress VARCHAR(15),
	label VARCHAR(255),
	trust BOOLEAN,
	remove BOOLEAN,
	updatedAt TIMESTAMP,
	PRIMARY KEY (id,physicalAddress)
);