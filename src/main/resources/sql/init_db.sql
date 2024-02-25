create table worker
(
    ID       SERIAL PRIMARY KEY,
    NAME     VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2),
    BIRTHDAY DATE CHECK (BIRTHDAY >= '1900-01-01'),
    LEVEL    VARCHAR(10)   NOT NULL CHECK (LEVEL IN ('Trainee', 'Junior', 'Middle', 'Senior')),
    SALARY   INT CHECK (SALARY >= 100 AND SALARY <= 100000)
);


create table client
(
    ID   SERIAL PRIMARY KEY,
    NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2)
);

create table project
(
    ID          SERIAL PRIMARY KEY,
    CLIENT_ID   INT NOT NULL,
    NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2),
    START_DATE  DATE,
    FINISH_DATE DATE,
    FOREIGN KEY (client_id) REFERENCES client (id)
);

create table project_worker
(
    PROJECT_ID INT not null,
    WORKER_ID  INT not null,
    PRIMARY KEY (PROJECT_ID, WORKER_ID),
    FOREIGN KEY (PROJECT_ID) REFERENCES project (ID),
    FOREIGN KEY (WORKER_ID) REFERENCES worker (ID)
);