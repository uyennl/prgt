CREATE DATABASE pizza_store;

USE pizza_store;

CREATE TABLE dish (
    idDish INT IDENTITY(1,1) PRIMARY KEY,
    title NVARCHAR(255) NOT NULL,
    subTitle NVARCHAR(255),
    price FLOAT NOT NULL,
    image NVARCHAR(255),
    status BIT DEFAULT 1, -- Trường trạng thái kiểu BIT
    idCategory INT NOT NULL, -- Thêm cột idCategory
    FOREIGN KEY (idCategory) REFERENCES category(idCategory) -- Khóa ngoại tham chiếu đến bảng category
);

CREATE TABLE category(
    idCategory INT IDENTITY(1,1) PRIMARY KEY,
    cateName NVARCHAR(255) NOT NULL
);

-- Chèn một số mẫu dữ liệu vào bảng dish
INSERT INTO dish (title, subTitle, price, image,status,idCategory)
VALUES 
('Pizza Margherita', 'Classic Italian Pizza', 9.99, 'https://imagevars.gulfnews.com/2023/09/04/Magherita-pizza-_18a6007a47a_medium.jpg', 1,1),
('Pizza Pepperoni', 'Spicy Pepperoni Pizza', 10.99, 'https://www.cobsbread.com/us/wp-content//uploads/2022/09/Pepperoni-pizza-850x630-1.png', 1,2),
('Pizza Hawaiian', 'Ham and Pineapple Pizza', 11.99, 'https://recipes.net/wp-content/uploads/2020/03/dominos-copycat-hawaiian-pizza-recipe.jpg', 1,3),
('Pizza BBQ Chicken', 'BBQ Chicken Pizza', 12.99, 'https://staticcookist.akamaized.net/wp-content/uploads/sites/22/2022/02/bbq-chicken-pizza-1.jpg', 1,4);

insert into category(cateName)
values
('pizza ý'),
('pizza nhật'),
('pizza đức'),
('pizza Việt nam');
-- Xóa dữ liệu trong bảng dish
DELETE FROM dish;
delete from category;
-- Xóa bảng dish
DROP TABLE dish;
delete from orders;
delete from order_details;
select *from dish;
--xóa bảng orders 
drop table orders;
--xóa bảng order_details;
drop table order_details;
--tạo bảng orders

CREATE TABLE Orders (
    idOrder INT IDENTITY(1,1) PRIMARY KEY,
    dateOfOrder DATE,
    idCustomer INT, -- Tham chiếu đến khóa chính của bảng Customer
    FOREIGN KEY (idCustomer) REFERENCES Customer(idCustomer)
);
create table order_details(
    id int primary key identity(1,1),
	typePayment varchar(100) not null,
	quantity int not null,
	idDish int,
	idOrder int,
	constraint fk_order_dish foreign key (idDish) references dish(idDish),
	constraint fk_order_orderdetails foreign key (idOrder) references orders(idOrder)
);
INSERT INTO category (cateName) VALUES ('Main Dishes');
INSERT INTO category (cateName) VALUES ('Light Dishes');
INSERT INTO category (cateName) VALUES ('Desserts');
INSERT INTO category (cateName) VALUES ('Beverages');


-- Chèn dữ liệu cho đồ ăn chính (Main Dishes)
INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Seafood Pizza', 'Delicious seafood pizza', 9.99, 'https://media.istockphoto.com/id/155388738/photo/grilled-shrimp-and-roasted-pepper-pizza.jpg?s=612x612&w=0&k=20&c=meK4W7F9UJGJSQHJkS5OpkW2plA5Euep5VwMvLpy4_0=',5);

INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Beef Pizza', 'Succulent grilled beef pizza', 8.99, 'https://media.istockphoto.com/id/1210739896/photo/roast-beef-pizza-close-up.jpg?s=612x612&w=0&k=20&c=ga1hTow3PngGoRx5OBlatigrlMi5k9Bjdt2bCagMCes=', 5);

INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Chicken Pizza', 'Fresh and tasty chicken pizza', 7.99, 'https://media.istockphoto.com/id/1043604390/photo/butter-chicken-pizza.jpg?s=612x612&w=0&k=20&c=ahj3y6ktAvzcINubn0a0BfvovLTGDx_J_aMju4szqVQ=', 5);


INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Vegetarian Pizza', 'Fresh and healthy vegetarian pizza', 6.99,' https://media.istockphoto.com/id/842082336/photo/homemade-veggie-pizza-with-mushrooms-peppers.jpg?s=612x612&w=0&k=20&c=op1vZnGjlB_c3w6Z-ohPo0wn4QveujVKZu4vTZCOWnc=',5);

INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Margherita Pizza', 'Classic Margherita pizza', 7.99, 'https://cdn.loveandlemons.com/wp-content/uploads/2023/07/margherita-pizza.jpg',5);

INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Pepperoni Pizza', 'Spicy Pepperoni pizza', 8.99, 'https://media.istockphoto.com/id/521403691/photo/hot-homemade-pepperoni-pizza.jpg?s=612x612&w=0&k=20&c=PaISuuHcJWTEVoDKNnxaHy7L2BTUkyYZ06hYgzXmTbo=',5);

INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Hawaiian Pizza', 'Tropical Hawaiian pizza', 9.99, 'https://www.jessicagavin.com/wp-content/uploads/2020/07/hawaiian-pizza-16-1200.jpg', 5);



-- Chèn dữ liệu cho đồ ăn nhẹ (Light Dishes)
INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Sandwich', 'Cold cut sandwich', 5.99, 'https://www.shutterstock.com/image-photo/delicious-sandwich-cold-cuts-lettuce-600nw-247947475.jpg', 6);

INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Caesar Salad', 'Fresh Caesar salad', 6.99, 'https://www.allrecipes.com/thmb/JTW0AIVY5PFxqLrf_-CDzT4OZQY=/0x512/filters:no_upscale():max_bytes(150000):strip_icc()/229063-Classic-Restaurant-Caesar-Salad-ddmfs-4x3-231-89bafa5e54dd4a8c933cf2a5f9f12a6f.jpg',6);

INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Fruit Salad', 'Healthy fruit salad', 5.99, 'https://images.themodernproper.com/billowy-turkey/production/posts/2022/FruitSalad_Shot4_20.jpg?w=960&h=960&q=82&fm=jpg&fit=crop&dm=1654019861&s=abb0af9baa0039bf1e91942aa34af247',6);





-- Chèn dữ liệu cho tráng miệng (Desserts)
INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Ice Cream', 'Sweet vanilla ice cream', 3.99, 'https://media.istockphoto.com/id/1326143969/photo/bowl-with-vanilla-ice-cream-balls.jpg?s=612x612&w=0&k=20&c=WxEriNEK7yW7F4AWImLQRrpco-R_bdDYEQoyhigu9fc=',7);

INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Chocolate Cake', 'Decadent chocolate cake', 4.99, 'https://inbloombakery.com/wp-content/uploads/2023/02/chocolate-ganache-cake-FI.jpg',7);

INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Fruit Tart', 'Delicious fruit tart', 3.99, 'https://media.istockphoto.com/id/157610681/photo/fruit-tart.jpg?s=1024x1024&w=is&k=20&c=oWZQ1YmFbfV-WLwpiPP0g6M4YbdrxPa5LuF115ACWVc=',7);

-- Chèn dữ liệu cho nước uống (Beverages)
INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Soda', 'Refreshing soda drink', 2.99, 'https://st2.depositphotos.com/1692343/7579/i/450/depositphotos_75790055-stock-photo-refreshing-bubbly-soda-pop.jpg',8);

INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Iced Tea', 'Refreshing iced tea', 2.49, 'https://img.freepik.com/free-photo/ice-tea-with-mint_144627-41785.jpg',8);

INSERT INTO dish (title, subTitle, price, image, idCategory)
VALUES ('Coffee', 'Hot brewed coffee', 3.49, 'https://img.freepik.com/premium-photo/hot-coffee-morning-wooden-table_838382-54.jpg',8);

select * from dish;

select * from category;