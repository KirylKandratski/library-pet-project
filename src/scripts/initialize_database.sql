drop table book;
drop table person;

CREATE TABLE person
(
    person_id  SERIAL PRIMARY KEY,
    full_name  VARCHAR(255) NOT NULL,
    birth_year INT          NOT NULL
);

CREATE TABLE book
(
    book_id            SERIAL PRIMARY KEY,
    name               VARCHAR(255) NOT NULL,
    author             VARCHAR(255) NOT NULL,
    year_of_publishing INT          NOT NULL,
    person_id          INT,
    loan_date          TIMESTAMP,
    FOREIGN KEY (person_id) REFERENCES person (person_id)
);

INSERT INTO person (full_name, birth_year)
VALUES ('Sergey Bubka', 1963),
       ('Michael Phelps', 1985),
       ('Lionel Messi', 1987),
       ('Serena Williams', 1981),
       ('Usain Bolt', 1986);


INSERT INTO book (name, author, year_of_publishing)
VALUES ('1984', 'George Orwell', 1949),
       ('To Kill a Mockingbird', 'Harper Lee', 1960),
       ('Brave New World', 'Aldous Huxley', 1932),
       ('The Catcher in the Rye', 'J.D. Salinger', 1951),
       ('The Great Gatsby', 'F. Scott Fitzgerald', 1925),
       ('Moby-Dick', 'Herman Melville', 1851),
       ('Pride and Prejudice', 'Jane Austen', 1813),
       ('Crime and Punishment', 'Fyodor Dostoevsky', 1866),
       ('War and Peace', 'Leo Tolstoy', 1869),
       ('Ulysses', 'James Joyce', 1922),
       ('The Divine Comedy', 'Dante Alighieri', 1320),
       ('Don Quixote', 'Miguel de Cervantes', 1615),
       ('One Hundred Years of Solitude', 'Gabriel Garcia Marquez', 1967),
       ('The Brothers Karamazov', 'Fyodor Dostoevsky', 1880),
       ('Anna Karenina', 'Leo Tolstoy', 1877),
       ('Catch-22', 'Joseph Heller', 1961),
       ('The Hobbit', 'J.R.R. Tolkien', 1937),
       ('Fahrenheit 451', 'Ray Bradbury', 1953),
       ('Lolita', 'Vladimir Nabokov', 1955),
       ('Lord of the Flies', 'William Golding', 1954),
       ('Alice in Wonderland', 'Lewis Carroll', 1865),
       ('Frankenstein', 'Mary Shelley', 1818),
       ('The Picture of Dorian Gray', 'Oscar Wilde', 1890),
       ('Wuthering Heights', 'Emily Bronte', 1847),
       ('Jane Eyre', 'Charlotte Bronte', 1847),
       ('Great Expectations', 'Charles Dickens', 1861),
       ('Animal Farm', 'George Orwell', 1945),
       ('Dracula', 'Bram Stoker', 1897),
       ('Les Misérables', 'Victor Hugo', 1862);