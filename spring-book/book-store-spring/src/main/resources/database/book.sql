insert  into category
(is_deleted,name)
values
(0,"Văn học Việt Nam"),
(0,"Sách giáo khoa"),
(0,"Kinh tế - chính trị"),
(0,"Pháp luật - xã hội"),
(0,"Hôn nhân - gia đình"),
(0, "Tiểu thuyết");

insert into book
(authors, is_deleted, name, published_date,publisher,total_page,url,category_id,price)
values
("Tố Hữu",0 ,"Từ ấy", "11/10/1995","NXB Kim Đồng", "320","assets/images/tab-item4.jpg",1,"159000"),
("Nguyễn Nhật Ánh ",0 ,"Tôi thấy hoa vàng trên cỏ xanh", "21/09/2016","NXB Trẻ", "400","assets/images/tab-item1.jpg",6,"79000"),
("Nguyễn Du",0 ,"Truyện Kiều", "21/09/2016","NXB Văn Học", "1000","assets/images/tab-item2.jpg",1,"425000"),
("Shark Bình ",0 ,"Long Mạch", "15/11/2022","NXB Hồng Đức", "500","assets/images/tab-item3.jpg",3,"400000"),
("Nhiều tác giả ",0 ,"Luật hôn nhân gia đình", "21/09/2020","NXB Lao Động", "79","assets/images/tab-item5.jpg",4,"200000");

insert into user values
("thaouyen","$2a$12$RnxtR/ibCg6OyM7/mhmH1esjcn3hxYITI5WvlX38hq8LpReZGAHue"),
("haohao","$2a$12$RnxtR/ibCg6OyM7/mhmH1esjcn3hxYITI5WvlX38hq8LpReZGAHue");

insert into role
values
(1, "ADMIN"),
(2, "MEMBER");

insert into user_role
values
("thaouyen", 1),
("haohao", 2);

insert into customer
values
(1, 'Hà Nội','123uyen234@gmail.com', 1, 0, 'Nguyễn Thảo Uyên', '0935444207', 0, 'thaouyen'),
(2, 'Nam Định','hoanghao9x87@gmail.com', 1, 0, 'Nguyễn Hoàng Hảo', '0762709502', 0, 'haohao');