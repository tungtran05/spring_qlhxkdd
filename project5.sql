drop database if exists `project5`;
create database `project5`;

use `project5`;

create table `staff` (
	`id` int auto_increment,
    `name` varchar(255),
    `id_card` varchar(255),
    `license_num` varchar(255),
    `license_type` varchar(255),
    `address` varchar(255),
    `dob` date,
    `seniority` int,
    primary key(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

insert into `staff` (`name`, `id_card`, `license_num`, `license_type`, `address`, `dob`, `seniority`)
	values ("Trần Xuân Tùng", "001098000430", "100", "A", "Thái Bình", "1998-05-14", 10),
			("Nguyễn Công Phượng", "001098000431", "100", "A", "Nghệ An", "1995-05-05", 10),
			("Nguyễn Tuấn Anh", "001098000432", "101", "A", "Thái Bình", "1996-05-05", 5),
            ("Nguyễn Văn Quyết", "001098000433", "102", "B", "Hà Tây", "1989-05-05", 3),
            ("Nguyễn Quang Hải", "001098000434", "103", "B", "Hà Tây", "1997-05-05", 8);

create table `vehicle` (
	`id` int auto_increment,
    `license_plate` varchar(255),
    `color` varchar(255),
    `manufacturer` varchar(255),
    `car_life` int,
    `model` varchar(255),
    `seats_num` int,
    `years_of_use` int,
    `last_maintenance` date,
    primary key(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

insert into `vehicle` (`license_plate`, `color`, `manufacturer`, `car_life`, `model`, `seats_num`, 
						`years_of_use`, `last_maintenance`)
	values ("29A-3833", "silver", "Huyndai", 2010, "Santafe-2010", 29, 10, "2020-05-05"),
			("29A-3833", "silver", "Honda", 2010, "CRV-2010", 29, 10, "2020-05-05"),
			("29A-6666", "black", "Toyota", 2010, "Fortuner-2010", 16, 10, "2020-05-05"),
            ("29A-8888", "red", "Mitsubitshi", 2010, "Outlander-2010", 50, 10, "2020-05-05"),
            ("29A-3333", "white", "Mercedes", 2010, "C300-2010", 16, 10, "2020-05-05");

create table `routecomplexity` (
	`id` int auto_increment,
    `name` varchar(255),
    `salary_of_driver` float,
    primary key (`id`)
);

insert into `routecomplexity` (`name`,`salary_of_driver`)
 values ("Khó",1000), ("Bình thường",800), ("Trung bình",600), ("Dễ",400);

create table `route` (
	`id` int auto_increment,
    `entry_point` varchar(255),
    `end_point` varchar(255),
    `route_length` float,
    `routecomplexity_id` int,
    primary key (`id`),
    foreign key (`routecomplexity_id`) references routecomplexity(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

insert into `route` (`entry_point`, `end_point`, `route_length`, `routecomplexity_id`) 
	values ("Hà Nội", "Thái Bình", 100, 1),
			("Hà Nội", "Nam Định", 100, 1),
            ("Hà Nội", "Huế", 100, 2),
			("Hà Nội", "Vinh", 120, 2),
            ("Hà Nội", "TP Hồ Chí Minh", 150, 3);

create table `tour` (
	`id` int auto_increment,
    `passengers_num` int,
    `fare` float,
    `started_at` timestamp,
    `finished_at` timestamp,
    `driver_id` int,
    `assistant_id` int,
    `vehicle_id` int,
    `route_id` int,
    primary key(`id`),
    foreign key(`driver_id`) references staff(`id`),
    foreign key(`assistant_id`) references staff(`id`),
    foreign key(`vehicle_id`) references vehicle(`id`),
    foreign key(`route_id`) references route(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

insert into `tour`
(`passengers_num`, `fare`, `started_at`, `finished_at`, `driver_id`, `assistant_id`, `vehicle_id`, `route_id`)
values (10, 80, "2020-01-01 13:00:01", "2020-01-01 13:00:01", 1, 2, 1, 1),
		(10, 80, "2020-01-01 13:00:01", "2020-01-02 13:00:01", 3, 1, 1, 1),
        (10, 80, "2020-01-01 13:00:01", "2020-01-03 13:00:01", 4, 1, 1, 2),
        (10, 80, "2020-01-01 13:00:01", "2020-01-04 13:00:01", 5, 4, 3, 3),
		(10, 80, "2020-01-01 13:00:01", "2020-01-05 13:00:01", 2, 1, 2, 5),
		(10, 80, "2020-01-01 13:00:01", "2020-01-06 13:00:01", 3, 4, 2, 5);

