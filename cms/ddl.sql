CREATE TABLE role (
    name VARCHAR(10), -- ADMIN, EDITOR, USER
    PRIMARY KEY (name)
);

CREATE TABLE users (
    id INTEGER AUTO_INCREMENT, 
    name VARCHAR(100) NOT NULL,
    email VARCHAR(300) NOT NULL,
    password TEXT NOT NULL, 
    PRIMARY KEY (id),
    UNIQUE KEY (email)
);

CREATE TABLE user_has_role (
    user_id INTEGER, 
    role_name VARCHAR(10),
    PRIMARY KEY (user_id, role_name),
    CONSTRAINT fk_uhr_user_id_users_id FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_uhr_role_name_role_name FOREIGN KEY (role_name) REFERENCES role(name)

);

CREATE TABLE category (
    id INTEGER AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL, 
    PRIMARY KEY (id),
    UNIQUE KEY (name)
);

CREATE TABLE article (
    id INTEGER AUTO_INCREMENT,
    author_user_id INTEGER NOT NULL, 
    title TEXT NOT NULL,
    content TEXT NOT NULL,
    publication_date DATETIME NOT NULL,
    published TINYINT(1) NOT NULL,
    slug VARCHAR(200) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (slug),
    CONSTRAINT fk_author_user_id_users_id 
        FOREIGN KEY (author_user_id) REFERENCES users (id)
);

CREATE TABLE article_category (
    article_id INTEGER,
    category_id INTEGER,
    PRIMARY KEY(article_id, category_id),
    CONSTRAINT fk_ac_article_id FOREIGN KEY (article_id) REFERENCES article (id),
    CONSTRAINT fk_ac_category_id FOREIGN KEY (category_id) REFERENCES category (id)
);