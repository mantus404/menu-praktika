CREATE TABLE IF NOT EXISTS ORDERSLIST (
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
    MEAL_ID BIGINT,
    ORDERS_ID BIGINT,
    QUANTITY BIGINT,
    CONSTRAINT ORDERSLIST_PK PRIMARY KEY (ID)
);