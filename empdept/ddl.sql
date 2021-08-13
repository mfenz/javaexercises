CREATE TABLE project
(
	id INTEGER AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	deadline TIMESTAMP NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE employee_in_project 
(
	employee_id INTEGER,
	project_id INTEGER,
	start TIMESTAMP,
	end TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	PRIMARY KEY (employee_id, project_id, start), 
	CONSTRAINT fk_eip_employee_id FOREIGN KEY (employee_id) REFERENCES employee(id), 
	CONSTRAINT fk_eip_project_id FOREIGN KEY (project_id) REFERENCES project(id)
);