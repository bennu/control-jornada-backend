-- @formatter:off
DROP TABLE IF EXISTS country;

CREATE TABLE country (
    id SERIAL PRIMARY KEY
    , name VARCHAR(200) NOT NULL
    , nationality VARCHAR(200) NOT NULL

    , UNIQUE(id)
    , UNIQUE(name)
);

INSERT INTO country (name, nationality) VALUES
    ('Chile', 'Chilena');
