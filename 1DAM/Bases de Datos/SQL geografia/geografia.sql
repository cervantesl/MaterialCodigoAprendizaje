drop database if exists geografia;

create database geografia;

use geografia;


create table mars(
codi int,
nom varchar(40),
detalls varchar(200),
primary key(codi)
) engine=innodb;


create table provincies(
codi int,
nom varchar(30),
km2 int,
primary key(codi)
) engine=innodb;


create table rius(
codi int,
nom varchar(20),
longitud float(10,2),
mar int,
primary key(codi),
foreign key(mar) references mars(codi)
) engine=innodb;


create table passaper(
riu int,
prov int,
primary key(riu,prov),
foreign key(riu) references rius(codi),
foreign key(prov) references provincies(codi)
) engine=innodb;

create table limita(
prov1 int,
prov2 int,
primary key(prov1,prov2),
foreign key(prov1) references provincies(codi),
foreign key(prov2) references provincies(codi)
) engine=innodb;


insert into mars values(1,'Mediterrani','Mar');
insert into mars values(2,'Cantàbric','Mar');
insert into mars values(3,'Atlàntic','Oceà');



insert into provincies values(1,'Àlaba',3047);
insert into provincies values(2,'Albacete',14858);
insert into provincies values(3,'Alacant',5863);
insert into provincies values(4,'Almeria',8774);
insert into provincies values(5,'Astúries',10565);
insert into provincies values(6,'Àvila',8048);
insert into provincies values(7,'Badajoz',21657);
insert into provincies values(8,'Illes Balears',5014);
insert into provincies values(9,'Barcelona',7733);
insert into provincies values(10,'Burgos',14269);
insert into provincies values(11,'Càceres',19945);
insert into provincies values(12,'Cadis',7385);
insert into provincies values(13,'Cantàbria',5289);
insert into provincies values(14,'Castelló',6679);
insert into provincies values(15,'Ceuta',18);
insert into provincies values(16,'Ciudad Real',19749);
insert into provincies values(17,'Còrdova',13718);
insert into provincies values(18,'Conca',17061);
insert into provincies values(19,'Girona',5886);
insert into provincies values(20,'València',10763);
insert into provincies values(21,'Tarragona',6283);
insert into provincies values(22,'Lleida',12028);
insert into provincies values(23,'Lugo',9803);
insert into provincies values(24,'Ourense',7278);
insert into provincies values(25,'Pontevedra',4477);
insert into provincies values(26,'Soria',10287);
insert into provincies values(27,'Terol',14804);
insert into provincies values(28,'Guadalajara',12190);
insert into provincies values(29,'Madrid',7995);
insert into provincies values(30,'Toledo',15368);
insert into provincies values(31,'Saragossa',17194);
insert into provincies values(32,'Sevilla',14001);
insert into provincies values(33,'Jaen',13498);
insert into provincies values(34,'Huelva',10085);
insert into provincies values(35,'Múrcia',11317);

insert into provincies values(36,'La Corunya', 7950);
insert into provincies values(37,'Granada', 12647);
insert into provincies values(38,'Guipúscoa', 1980);
insert into provincies values(39,'Lleó', 15581);
insert into provincies values(40,'Màlaga', 7306);
insert into provincies values(41,'Melilla', 13);
insert into provincies values(42,'Osca', 15636);
insert into provincies values(43,'Navarra', 10391);
insert into provincies values(44,'Palència', 8052);
insert into provincies values(45,'Las Palmas', 4066);
insert into provincies values(46,'Pontevedra', 4495);
insert into provincies values(47,'La Rioja', 5045);
insert into provincies values(48,'Salamanca', 12350);
insert into provincies values(49,'Santa Cruz de Tenerife', 3381);
insert into provincies values(50,'Segòvia', 6921);
insert into provincies values(51,'Sòria', 10306);
insert into provincies values(52,'Valladolid', 8110);
insert into provincies values(53,'Zamora', 10561);



insert into rius values(1,'Miño',308,3);
insert into rius values(2,'Duero',895,3);
insert into rius values(3,'Tajo',1008,3);
insert into rius values(4,'Ebre',930,1);
insert into rius values(5,'Guadiana',742,3);
insert into rius values(6,'Guadalquivir',666,1);
insert into rius values(7,'Xúquer',497,1);
insert into rius values(8,'Segura',325,1);


insert into passaper values(1,23);
insert into passaper values(1,24);
insert into passaper values(1,25);
insert into passaper values(2,26);
insert into passaper values(3,27);
insert into passaper values(3,18);
insert into passaper values(3,28);
insert into passaper values(3,29);
insert into passaper values(3,30);
insert into passaper values(3,11);
insert into passaper values(4,21);
insert into passaper values(4,31);
insert into passaper values(5,7);
insert into passaper values(6,33);
insert into passaper values(6,17);
insert into passaper values(6,32);
insert into passaper values(6,12);
insert into passaper values(6,34);
insert into passaper values(7,18);
insert into passaper values(7,2);
insert into passaper values(7,20);
insert into passaper values(8,33);
insert into passaper values(8,2);
insert into passaper values(8,35);
insert into passaper values(8,3);


insert into limita values(3,35);
insert into limita values(3,20);
insert into limita values(20,14);
insert into limita values(14,21);
insert into limita values(21,9);
insert into limita values(33,17);
insert into limita values(9,19);
insert into limita values(9,22);
insert into limita values(21,22);
insert into limita values(14,27);
insert into limita values(27,31);
insert into limita values(32,17);
insert into limita values(32,12);
insert into limita values(7,34);

