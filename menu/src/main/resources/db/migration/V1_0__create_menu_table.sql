CREATE TABLE IF NOT EXISTS MENU (
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
    TITLE VARCHAR(255),

    CONSTRAINT MENU_PK PRIMARY KEY (ID)
);