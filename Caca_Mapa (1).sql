

create database Caca_mapa;
use Caca_mapa;

create table Usuario(
id_usuario int primary key auto_increment not null,
nombre varchar(30),
email varchar(90),
contrasena varchar(30)
);


create table Localizacion(

id_general int primary key auto_increment not null,
pais varchar(30),
ciudad varchar(40),
etiqueta varchar(20),
id_usuario int  not null,
foreign key (id_usuario) references Usuario (id_usuario) 
);

create table Puntuacion(
id_puntuacion int primary key auto_increment not null,
descripcion varchar(60),
puntuacion int,
id_usuario int,
foreign key (id_usuario) references Usuario (id_usuario),
id_general int,
foreign key (id_general) references Localizacion (id_general) 
);

create table tiempo(
id_tiempo int primary key auto_increment not null,
fecha date,
hora time,
id_usuario int,
foreign key (id_usuario) references Usuario (id_usuario)
);