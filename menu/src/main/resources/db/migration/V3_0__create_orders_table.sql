CREATE TABLE IF NOT EXISTS ORDERS (
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
    CONFIRMED INT,
    CONSTRAINT ORDERS_PK PRIMARY KEY (ID)
);