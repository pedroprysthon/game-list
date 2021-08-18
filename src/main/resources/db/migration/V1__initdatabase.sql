CREATE TABLE users (
    users_id int primary key AUTO_INCREMENT,
    name varchar (255)
);

CREATE TABLE games_category (
    games_category_id int primary key AUTO_INCREMENT,
    name varchar (255)
);

INSERT INTO games_category (games_category_id,name) VALUES (1,'fps'),(2,'soulslike'),(3,'horror'),(4,'mmo'),(5,'rpg');

CREATE TABLE games (
    games_id int primary key AUTO_INCREMENT,
    title varchar (255),
    description text,
    image_url varchar (255),
    starting_date timestamp,
    end_date timestamp,
    review_score int default 0,
    review_note text,
    games_category_id int,
    FOREIGN KEY (games_category_id) REFERENCES games_category(games_category_id)
);
