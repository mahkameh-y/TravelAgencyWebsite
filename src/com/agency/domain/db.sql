create table plane(
    id int(50),
    number varchar(50),
    model varchar (50),
    capacity int(50)
);

create table flight(
    id int(50),
    number varchar(50),
    plane int(50),
    date Date,
    capacity int(50),
    cost int(50),
    time Time,
    source varchar(50),
    destination varchar(50)
);

create table passenger(
    id int(50),
    nationalCode varchar(50),
    name varchar(50),
    lastname varchar(50),
    telephone varchar(50),
    address varchar(100)
);

create table reservation(
    id int (50),
    passenger int(50),
    flight int(50)
);

create table login(
    id int (50),
    username varchar(50),
    password varchar(50),
    role int(50),
    passengerID int(50)
);

create table menu(
    id int (50),
    name varchar(50),
    page varchar(50),
    url varchar(50),
    type int(50)
);

create table permission(
    id int (50),
    actionURL varchar(50),
    role int(50)
);

create table menuAccess(
    id int (50),
    menu int(50),
    role int(50)
);



