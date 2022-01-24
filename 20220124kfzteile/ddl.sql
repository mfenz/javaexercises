
CREATE TABLE rolle
(
    id INT,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (name)
);

CREATE TABLE benutzer
(
    id INT AUTO_INCREMENT,
    vorname VARCHAR(100) NOT NULL,
    nachname VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    passwort VARCHAR(255) NOT NULL,
    warengruppe_id INT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (email)
);

CREATE TABLE warengruppe
(
    id INT AUTO_INCREMENT,
    leiter_benutzer_id INT NOT NULL,
    bezeichnung VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_warengruppe_leiter_benutzer_id FOREIGN KEY (leiter_benutzer_id) REFERENCES benutzer(id),
    UNIQUE KEY (bezeichnung)
);

-- zum Benutzer FK Constraint auf Warengruppe hinzufügen
ALTER TABLE benutzer
ADD CONSTRAINT fk_benutzer_warengruppe_id FOREIGN KEY (warengruppe_id) REFERENCES warengruppe(id);

CREATE TABLE benutzer_hat_rolle
(
    rolle_id INT,
    benutzer_id INT,
    PRIMARY KEY (rolle_id, benutzer_id),
    CONSTRAINT fk_benutzer_hat_rolle_rolle_id FOREIGN KEY (rolle_id) REFERENCES rolle(id),
    CONSTRAINT fk_benutzer_hat_rolle_benutzer_id FOREIGN KEY (benutzer_id) REFERENCES benutzer(id)
);

CREATE TABLE interessent
(
    benutzer_id INT,
    strasse VARCHAR(200) NOT NULL,
    plz VARCHAR(20) NOT NULL,
    ort VARCHAR(200) NOT NULL,
    firmenname VARCHAR(200) NOT NULL,
    PRIMARY KEY(benutzer_id),
    CONSTRAINT fk_interessent_benutzer_id FOREIGN KEY (benutzer_id) REFERENCES benutzer(id)
);

CREATE TABLE dokument
(
    id INT AUTO_INCREMENT,
    warengruppe_id INT NOT NULL,
    pfad VARCHAR(2000) NOT NULL,
    dateiname VARCHAR(2000) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_dokument_warengruppe_id FOREIGN KEY (warengruppe_id) REFERENCES warengruppe(id)
);