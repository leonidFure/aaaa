CREATE TABLE usr (
    _id uuid not null primary key,
    username varchar(255),
    password varchar(255),
    is_active bool,
    role varchar(25)
);