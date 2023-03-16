drop table book;
drop table person;

CREATE TABLE person (
                        person_id SERIAL PRIMARY KEY,
                        full_name VARCHAR(255) NOT NULL,
                        birth_year INT NOT NULL
);

CREATE TABLE book (
                      book_id SERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      author VARCHAR(255) NOT NULL,
                      year_of_publishing INT NOT NULL,
                      person_id INT,
                      FOREIGN KEY (person_id) REFERENCES person (person_id)
);

INSERT INTO person (full_name, birth_year)
VALUES
    ('Sergey Bubka', 1963),
    ('Michael Phelps', 1985),
    ('Lionel Messi', 1987),
    ('Serena Williams', 1981),
    ('Usain Bolt', 1986);

INSERT INTO book (name, author, year_of_publishing, person_id)
VALUES
    ('The Witcher: The Last Wish', 'Andrzej Sapkowski', 1993, NULL),
    ('The Witcher: Blood of Elves', 'Andrzej Sapkowski', 1994, NULL),
    ('Solaris', 'Stanisław Lem', 1961, NULL),
    ('The Cyberiad', 'Stanisław Lem', 1965, NULL),
    ('Ferdydurke', 'Witold Gombrowicz', 1937, NULL),
    ('Pan Tadeusz', 'Adam Mickiewicz', 1834, NULL),
    ('Quo Vadis', 'Henryk Sienkiewicz', 1896, NULL),
    ('The Trilogy: With Fire and Sword', 'Henryk Sienkiewicz', 1884, NULL),
    ('The Doll', 'Bolesław Prus', 1890, NULL),
    ('The Peasants', 'Władysław Reymont', 1904, NULL);