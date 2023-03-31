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

INSERT INTO book (name, author, year_of_publishing, person_id)
VALUES
    ('The Divine Comedy', 'Dante Alighieri', 1320, NULL),
    ('Don Quixote', 'Miguel de Cervantes', 1605, NULL),
    ('War and Peace', 'Leo Tolstoy', 1869, NULL),
    ('Crime and Punishment', 'Fyodor Dostoevsky', 1866, NULL),
    ('One Hundred Years of Solitude', 'Gabriel Garcia Marquez', 1967, NULL),
    ('To Kill a Mockingbird', 'Harper Lee', 1960, NULL),
    ('The Lord of the Rings', 'J.R.R. Tolkien', 1954, NULL),
    ('1984', 'George Orwell', 1949, NULL),
    ('Pride and Prejudice', 'Jane Austen', 1813, NULL),
    ('The Great Gatsby', 'F. Scott Fitzgerald', 1925, NULL),
    ('Brave New World', 'Aldous Huxley', 1932, NULL),
    ('The Catcher in the Rye', 'J.D. Salinger', 1951, NULL),
    ('Anna Karenina', 'Leo Tolstoy', 1877, NULL),
    ('The Brothers Karamazov', 'Fyodor Dostoevsky', 1880, NULL),
    ('The Picture of Dorian Gray', 'Oscar Wilde', 1890, NULL),
    ('Heart of Darkness', 'Joseph Conrad', 1899, NULL),
    ('The Stranger', 'Albert Camus', 1942, NULL),
    ('The Trial', 'Franz Kafka', 1925, NULL),
    ('The Canterbury Tales', 'Geoffrey Chaucer', 1400, NULL),
    ('Les Misérables', 'Victor Hugo', 1862, NULL);