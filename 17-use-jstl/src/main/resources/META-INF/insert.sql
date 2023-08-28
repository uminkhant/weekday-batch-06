insert into address(street,township,city) values('No.D-36,Between 27×28th Sts,Between 84×85th Sts','Chan Aye Thar Zan','Mandalay');
insert into address(street,township,city) values('No.3, 56th Street Quarter (7)','Hlaing','Yangon');
insert into address(street,township,city) values('19st,Between 80x81 sts','Aungmyaytharzan','Mandalay');
insert into address(street,township,city) values('Between 35x36 sts,Between 84x85 sts','Maharaungmyay','Mandalay');
insert into address(street,township,city) values('41st,Between 75x76 sts ','Maharaungmyay','Mandalay');

insert into member(name,member_type,loginId,password,customer_type,role,address_id) values('William','customer','william','123',1,1,1);
insert into member(name,member_type,loginId,password,customer_type,role,address_id) values('Andrew','customer','andrew','111',2,2,2);
insert into member(name,member_type,loginId,password,customer_type,role,address_id) values('John','customer','john','222',3,2,3);
insert into member(name,member_type,loginId,password,customer_type,role,address_id) values('Sopheia','customer','sopheia','456',3,2,4);
insert into member(name,member_type,loginId,password,customer_type,role,address_id) values('Susan','customer','susan','444',2,2,5);


insert into contact(member_id,phone) values(1,'09232423232');
insert into contact(member_id,phone) values(1,'09923223242');
insert into contact(member_id,phone) values(2,'0953253532');
insert into contact(member_id,phone) values(3,'09092929222');

insert into category(name) values ('Diary');
insert into category(name) values ('Snacks');
insert into category(name) values ('Drinks');
insert into category(name) values ('Fruits');
insert into category(name) values ('Vegetables');
insert into category(name) values ('Cleaning');


insert into product (name,dt_price,ws_price,description,category_id) values('Milk',2500,2000,"This is test about description",1);
insert into product (name,dt_price,ws_price,description,category_id) values('Eggs',2200,2000,"This is test about description",1);
insert into product (name,dt_price,ws_price,description,category_id) values('Butter',4000,3800,"This is test about description",1);
insert into product (name,dt_price,ws_price,description,category_id) values('Cheese',3000,2500,"This is test about description",1);
insert into product (name,dt_price,ws_price,description,category_id) values('Yogurt',1200,1000,"This is test about description",1);
insert into product (name,dt_price,ws_price,description,category_id) values('Candy',700,500,"This is test about description",2);
insert into product (name,dt_price,ws_price,description,category_id) values('Dried Fruit',1500,1000,"This is test about description",2);
insert into product (name,dt_price,ws_price,description,category_id) values('Popcorn',800,500,"This is test about description",2);
insert into product (name,dt_price,ws_price,description,category_id) values('Sunflower Seeds',1200,1100,"This is test about description",2);
insert into product (name,dt_price,ws_price,description,category_id) values('Tiger Beer',2500,2200,"This is test about description",3);
insert into product (name,dt_price,ws_price,description,category_id) values('Su Coffee',3500,3300,"This is test about description",3);
insert into product (name,dt_price,ws_price,description,category_id) values('Lemon Juice',3200,3000,"This is test about description",3);
insert into product (name,dt_price,ws_price,description,category_id) values('Red Bull',1000,700,"This is test about description",3);
insert into product (name,dt_price,ws_price,description,category_id) values('Red level',42000,40000,"This is test about description",3);
insert into product (name,dt_price,ws_price,description,category_id) values('Super Tea',300,250,"This is test about description",3);
insert into product (name,dt_price,ws_price,description,category_id) values('Aye thar yar Wine',4500,4000,"This is test about description",3);
insert into product (name,dt_price,ws_price,description,category_id) values('Apple',1500,1300,"This is test about description",4);
insert into product (name,dt_price,ws_price,description,category_id) values('Avocados',1500,1200,"This is test about description",4);
insert into product (name,dt_price,ws_price,description,category_id) values('Cherries',2000,1700,"This is test about description",4);
insert into product (name,dt_price,ws_price,description,category_id) values('Grapefruit',1500,1300,"This is test about description",4);
insert into product (name,dt_price,ws_price,description,category_id) values('Watermelon',2000,1800,"This is test about description",4);
insert into product (name,dt_price,ws_price,description,category_id) values('Broccoli',2000,1750,"This is test about description",5);
insert into product (name,dt_price,ws_price,description,category_id) values('Chilies',500,400,"This is test about description",5);
insert into product (name,dt_price,ws_price,description,category_id) values('Onions',3200,3000,"This is test about description",5);
insert into product (name,dt_price,ws_price,description,category_id) values('Potatoes',1000,1000,"This is test about description",5);
insert into product (name,dt_price,ws_price,description,category_id) values('Tomatos',1200,1100,"This is test about description",5);
insert into product (name,dt_price,ws_price,description,category_id) values('Air fresher',4000,3800,"This is test about description",6);
insert into product (name,dt_price,ws_price,description,category_id) values('Garbage bag',700,500,"This is test about description",6);
insert into product (name,dt_price,ws_price,description,category_id) values('Glass cleaner',1300,1200,"This is test about description",6);
insert into product (name,dt_price,ws_price,description,category_id) values('Dish soap',500,400,"This is test about description",6);
insert into product (name,dt_price,ws_price,description,category_id) values('Laundry soap',2200,2000,"This is test about description",6);
