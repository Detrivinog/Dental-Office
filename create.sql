CREATE TABLE IF NOT EXISTS patients(
    id int auto_increment primary key,
    dni varchar(100),
    name varchar(100),
    lastname varchar(100),
    address varchar(255),
    discharge_date TIMESTAMP WITHOUT TIME ZONE);

CREATE TABLE IF NOT EXISTS odontologists (
    id int auto_increment primary key,
    license varchar(100),
    name varchar(100),
    lastname varchar(100));

CREATE TABLE IF NOT EXISTS turns(
    id int auto_increment primary key,
    turn_date TIMESTAMP WITHOUT TIME ZONE,
    odontologist_id int,
    patient_id int);
