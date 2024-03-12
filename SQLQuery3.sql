select * from orders;


create table orders
(
	idOrder int PRIMARY KEY Identity(1,1),
	dateOfOrder date not null,
	idCustomer int,
	CONSTRAINT fk_orders_customer FOREIGN KEY (idCustomer) REFERENCES customer(idCustomer) 
);

create table order_details
(
	idOrderDetails int primary key identity(1,1),
	typeOfPayment varchar(100) not null,
	quantity int not null,
	idOrder int,
	idDish int,
	CONSTRAINT fk_order_order_details FOREIGN KEY (idOrder) references orders(idOrder),
	CONSTRAINT fk_dish_order_details FOREIGN KEY (idOrder) references dish(idDish)
);

select * from order_details;

select * from customer;

ALTER TABLE customer
ADD addressCus VARCHAR(100) ;
