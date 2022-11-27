DROP DATABASE IF EXISTS contact_management_api;

CREATE DATABASE contact_management_api;

use contact_management_api;

CREATE TABLE IF NOT EXISTS person
(
    person_id  INT AUTO_INCREMENT PRIMARY KEY NOT NULL UNIQUE,
    first_name VARCHAR(128),
    last_name  VARCHAR(128),
    age        INT,
    birthdate  DATE
);

CREATE TABLE IF NOT EXISTS contact
(
    contact_id                  INT AUTO_INCREMENT PRIMARY KEY NOT NULL UNIQUE,
    person_id                   INT                            NULL,
    phone                       VARCHAR(128),
    email                       VARCHAR(128),
    significant_date            DATE,
    significant_date_label      VARCHAR(128), -- This can either be Birthday, Anniversary, No Label, Other, or Custom.
    related_person_id           INT                            NULL,
    related_person_relationship VARCHAR(128), -- Either No Label, Brother, Child, Domestic Partner, Father, Friend, Manager, Mother, Parent, Partner, Referred By, Relative, Sister, Spouse or Custom.
    FOREIGN KEY (person_id) REFERENCES person (person_id),
    FOREIGN KEY (related_person_id) REFERENCES person (person_id)
);

-- TEST DATA

INSERT INTO person (first_name, last_name, age, birthdate)
VALUES ('Vince Angelo', 'Batecan', 16, current_date);
INSERT INTO contact (person_id,
                     phone, email, significant_date, significant_date_label, related_person_id,
                     related_person_relationship)
VALUES (1, "09998216556", "llTheBlankll@gmail.com", current_date, "Anniversay", 1, "Myself")