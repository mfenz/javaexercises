CREATE TABLE organization -- bbrz, bfi, ... 
(
    id VARCHAR(5),
    name VARCHAR(255),
    PRIMARY KEY (id),
    UNIQUE KEY (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO organization (id, name) VALUES ('bbrz', "BBRZ"), ('bfist', 'BFI STMK');

CREATE TABLE accessibility 
(
    id INTEGER,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE role -- admin, editor, basic, 
(
    id VARCHAR(6),
    name VARCHAR(255) NOT NULL,
    points INTEGER NOT NULL, -- the more points the better
    PRIMARY KEY (id),
    UNIQUE KEY (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO role (id, name, points) VALUES ('admin', 'Admin', 40), ('editor', 'Editor', 35), ('user', 'User', 10);

CREATE TABLE user 
(
    id INTEGER AUTO_INCREMENT,
    email VARCHAR(300) NOT NULL,
    password TEXT NOT NULL, 
    enabled TINYINT NOT NULL,
    account_non_expired TINYINT NOT NULL,
    credentials_non_expired TINYINT NOT NULL,
    account_non_locked TINYINT NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    date_removed TIMESTAMP NULL,
    organization_id VARCHAR(5) NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    role_id VARCHAR(6) NOT NULL,
    email_confirmed TIMESTAMP NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (email),
    CONSTRAINT fk_user_organization_id FOREIGN KEY (organization_id) REFERENCES organization(id),
    CONSTRAINT fk_user_role_id FOREIGN KEY (role_id) REFERENCES role(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE email_confirmation_token 
(
    id INTEGER AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    token TEXT NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    redeemed TIMESTAMP NULL,
    redeemed_ip TEXT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_email_confirmation_token_user_id FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE course
(
    id INTEGER AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    accessibility_id INTEGER NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    date_removed TIMESTAMP NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (name),
    CONSTRAINT fk_course_accessibility FOREIGN KEY (accessibility_id) REFERENCES accessibility(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE page 
(
    id INTEGER AUTO_INCREMENT,
    course_id INTEGER NOT NULL,
    parent_page_id INTEGER NULL,
    title VARCHAR(255) NOT NULL,
    slug VARCHAR(255) NOT NULL,
    order_in_course INTEGER NOT NULL,
    accessibility_id INTEGER NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    date_removed TIMESTAMP NULL,
    PRIMARY KEY(id),
    --UNIQUE KEY(slug),
    CONSTRAINT fk_page_course FOREIGN KEY (course_id) REFERENCES course(id),
    CONSTRAINT fk_page_parent_page FOREIGN KEY (parent_page_id) REFERENCES page(id),
    CONSTRAINT fk_page_accessibility FOREIGN KEY (accessibility_id) REFERENCES accessibility(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE section
(
    id INTEGER AUTO_INCREMENT,
    page_id INTEGER NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    order_in_page INTEGER NOT NULL,
    accessibility_id INTEGER NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    date_removed TIMESTAMP NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_section_page FOREIGN KEY (page_id) REFERENCES page(id),
    CONSTRAINT fk_section_accessibility FOREIGN KEY (accessibility_id) REFERENCES accessibility(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO accessibility (id, name) VALUES (0, 'Everybody');
INSERT INTO accessibility (id, name) VALUES (10, 'Authenticated (Logged in)');
INSERT INTO accessibility (id, name) VALUES (20, 'Subscribed (Any)');
INSERT INTO accessibility (id, name) VALUES (30, 'Subscribed (Course)');
INSERT INTO accessibility (id, name) VALUES (40, 'Admin');

INSERT INTO course (name, accessibility_id) VALUES ("HTML Grundlagen-Kurs", 40);
INSERT INTO course (name, accessibility_id) VALUES ("Modernes Java: Grundlagen-Kurs", 40);
INSERT INTO course (name, accessibility_id) VALUES ("Relationale Datenbanken: Grundlagen-Kurs für Anfänger", 40);
INSERT INTO course (name, accessibility_id) VALUES ("Datenbanken mit Java", 40);
INSERT INTO course (name, accessibility_id) VALUES ("Java: Webanwendungen ohne Frameworks", 40);
INSERT INTO course (name, accessibility_id) VALUES ("Java: Moderne Webanwendungen mit Spring Boot", 40);


CREATE TABLE cloud_service 
(
    id CHAR(1),
    name VARCHAR(255),
    PRIMARY KEY(id),
    UNIQUE KEY (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO cloud_service (id, name) VALUES ('A', 'Amazon AWS S3');

CREATE TABLE cloud_file 
(
    id INTEGER AUTO_INCREMENT,
    object_key VARCHAR(1024) NOT NULL,
    url VARCHAR(2000) NOT NULL,
    cloud_service_id CHAR(1) NOT NULL,
    region VARCHAR(100) NULL,
    bucket VARCHAR(100) NULL,
    format VARCHAR(30) NOT NULL,
    file_size_kb INTEGER NOT NULL,
    creator_ip VARCHAR(39) NOT NULL,
    creator_user_id INTEGER NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_cloud_file_cloud_service_id FOREIGN KEY (cloud_service_id) REFERENCES cloud_service(id),
    CONSTRAINT fk_cloud_file_creator_user_id FOREIGN KEY (creator_user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE segment 
(
    id INTEGER AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    date_removed TIMESTAMP NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE segment_image 
(
    id INTEGER NOT NULL, -- is a segment
    alt_text TEXT NOT NULL, 
    PRIMARY KEY(id),
    CONSTRAINT fk_segment_image_segment_id FOREIGN KEY (id) REFERENCES segment(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE segment_image_source_file -- version
(
    id INTEGER,
    segment_image_id INTEGER NOT NULL,
    x INTEGER NOT NULL,
    y INTEGER NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_segment_image_source_file_segment_image_id FOREIGN KEY (segment_image_id) REFERENCES segment_image(id),
    CONSTRAINT fk_segment_image_source_file_id FOREIGN KEY (id) REFERENCES cloud_file(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;












CREATE TABLE SPRING_SESSION (
  PRIMARY_ID CHAR(36) NOT NULL,
  SESSION_ID CHAR(36) NOT NULL,
  CREATION_TIME BIGINT NOT NULL,
  LAST_ACCESS_TIME BIGINT NOT NULL,
  MAX_INACTIVE_INTERVAL INT NOT NULL,
  EXPIRY_TIME BIGINT NOT NULL,
  PRINCIPAL_NAME VARCHAR(100),
  CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
);
 
CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);
 
CREATE TABLE SPRING_SESSION_ATTRIBUTES (
  SESSION_PRIMARY_ID CHAR(36) NOT NULL,
  ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
  ATTRIBUTE_BYTES BLOB NOT NULL,
  CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
  CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
);
 
CREATE INDEX SPRING_SESSION_ATTRIBUTES_IX1 ON SPRING_SESSION_ATTRIBUTES (SESSION_PRIMARY_ID);