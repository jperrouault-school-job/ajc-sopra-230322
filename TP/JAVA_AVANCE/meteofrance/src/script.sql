CREATE DATABASE meteofrance;


CREATE TABLE prevision (
    prev_id SERIAL PRIMARY KEY,
    prev_ville VARCHAR(150) NOT NULL,
    prev_meteo INT NOT NULL DEFAULT 0
);