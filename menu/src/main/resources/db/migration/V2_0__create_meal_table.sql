CREATE TABLE IF NOT EXISTS MEAL (
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
    TITLE VARCHAR(255),
    DESCRIPTION TEXT,
    QUANTITY BIGINT,
    MENU_ID BIGINT,

    CONSTRAINT MEAL_PK PRIMARY KEY (ID)
);