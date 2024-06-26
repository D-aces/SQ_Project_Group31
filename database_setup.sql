create database quality_project;
show databases;

create user 'quality'@'localhost' identified by 'quality';
grant all privileges on quality_project to 'quality'@'localhost';

use quality_project;

create table Airports (
	id int(5) auto_increment,
    port_name varchar(50) unique NOT NULL,
    connecting varchar(1000) NOT NULL,
    primary key(id)
);

create table Flights (
	id int(10) auto_increment,
    departing varchar(50) NOT NULL,
    destination varchar(50) NOT NULL,
    departingTime int NOT NULL,
    flightTime int(5) default 0,
    primary key(id),
	foreign key(departing) references Airports(port_name),
    foreign key (destination) references Airports(port_name),
    check (flightTime >= 0),
    check (departingTime between 0 and 86400)
);

create table Users (
	id int(10) auto_increment,
    uname varchar(50) unique NOT NULL,
    upass varchar(50) NOT NULL,
    primary key(id)
);

create table MR_Bookings (
	id int(10) auto_increment,
    uname varchar(50) NOT NULL, 
    departingPath varchar(1000) NOT NULL,
    returningPath varchar(1000) NOT NULL,
    departing varchar(50) NOT NULL,
    destination varchar(50) NOT NULL,
    departingTime int NOT NULL,
    flightTime int(5) default 0,
    stay int(5) default 0,
    primary key(id),
    foreign key(departing) references Airports(port_name),
    foreign key(destination) references Airports(port_name),
    foreign key(uname) references Users(uname),
	check (destination != departing),
    check (departingTime between 0 and 86400)
);

create table MO_Bookings (
	id int(10) auto_increment,
	uname varchar(50) NOT NULL,
	flightPath varchar(1000) NOT NULL,
    departing varchar(50) NOT NULL,
    destination varchar(50) NOT NULL,
    departingTime int NOT NULL,
    flightTime int(5) default 0,
    primary key(id),
    foreign key(departing) references Airports(port_name),
    foreign key(destination) references Airports(port_name),
    foreign key(uname) references Users(uname),
    check (destination != departing),
    check (departingTime between 0 and 86400)
);

create table DR_Bookings (
	id int(5) auto_increment,
    uname varchar(50) NOT NULL,
	departingFlight int(5) NOT NULL,
    returningFlight int(5) NOT NULL,
    stay int(5) default 0,
    primary key(id),
    foreign key(uname) references Users(uname),
    foreign key(departingFlight) references Flights(id),
    foreign key(returningFlight) references Flights(id)
);

create table DO_Bookings (
	id int(5) auto_increment,
    uname varchar(50) NOT NULL,
    departingFlight int(5) NOT NULL,
    primary key(id),
    foreign key(uname) references Users(uname),
    foreign key(departingFlight) references Flights(id)
);

show tables;

drop table DO_Bookings;
drop table DR_Bookings;
drop table MO_Bookings;
drop table MR_Bookings;
drop table Users;
drop table Flights;
drop table Airports;