-- Create
CREATE TABLE role (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   role VARCHAR(255),
   CONSTRAINT pk_role PRIMARY KEY (id)
);

INSERT INTO role (role) VALUES
('ADMIN'),
('PARTICIPANT'),
('ORGANISATEUR');

CREATE TABLE parcours(
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   ordre int,
   latitude int,
   longitude int,
   courseId int
   CONSTRAINT pk_parcours PRIMARY KEY (id)
);

INSERT INTO parcours (ordre,latitude,longitude,courseId) VALUES
(1,45.75638,4.85626,1),
(2,45.75985,4.84373,1),
(3,45.75985,4.84373,1);