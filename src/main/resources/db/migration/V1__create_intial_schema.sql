CREATE TABLE product (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) NOT NULL, 
    stock int NOT NULL, 
    price decimal NOT NULL, 
    created_at timestamp, 
    update_at timestamp 
);

CREATE TABLE orders (
    id int PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE orderItems(
    id int PRIMARY KEY AUTO_INCREMENT, 
    order_id int, 
    product_id int, 
    quantity int NOT NULL, 
    price decimal NOT NULL,
    CONSTRAINT fk_orderId_orders
    FOREIGN KEY (order_id) REFERENCES orders(id),
    CONSTRAINT fk_productId_product 
    FOREIGN KEY (product_id) REFERENCES product(id)
);
