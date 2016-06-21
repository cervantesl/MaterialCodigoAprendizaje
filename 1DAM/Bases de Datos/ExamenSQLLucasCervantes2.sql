create database tt;
use tt;

-- Crear las tablas EJERCICIO 1
create table joguines(
	nom varchar(20) primary key,
    estat varchar(20)
)Engine = InnoDB;

create table teletubis(
	nom varchar(20) primary key,
	joguina varchar(20) unique,
    color varchar(20) not null,
    foreign key (joguina) references joguines (nom)
		on delete cascade
        on update cascade
)Engine = InnoDB;

create table estimar(
	estimador varchar(20),
    estimat varchar(20),
    grau integer,
    primary key(estimador,estimat),
    foreign key (estimador) references teletubis (nom),
    foreign key (estimat) references teletubis (nom)
)Engine = InnoDB;

-- Modificar las tablas: EJERCICIO 2
alter table joguines rename to joguets;
alter table teletubis change column joguina 
	joguet varchar(20) after color;
alter table estimar change column grau grau int(10);

-- 
create database llaurador;
use llaurador;

create table camps (
	nom varchar(20),
	poble varchar(20),
    tipus varchar(20),
    fanecades int,
    data_compra date
    );

create table tipus_camps (
	tipus varchar(20),
    ingres_per_fanecada int
);


insert into tipus_camps values
('arròs', 400000),
('taronja', 100000),
('tomaques',200000),
('llimes',50000);

insert into camps values
('dalt', 'Sollana', 'arròs', 23, '2014-11-30'),
('baix', 'Sollana', 'arròs', 20, '2012-10-22'),
('mig', 'Sollana', 'arròs', 13, '2016-9-20'),
('séquia', 'Sueca', 'arròs', 30, '2015-11-3'),
('marge', 'Sueca', 'arròs', 30, '2015-11-3'),
('obra', 'Sueca', 'arròs', 25, '2000-11-4'),
('iaia', 'Sueca', 'arròs', 32, '1999-3-5'),
('vell', 'Sueca', 'arròs', 19, '2016-2-3'),
('dreta', 'Sueca', 'taronja', 31, '2002-11-6'),
('arbre', 'Sueca', 'taronja', 15, '2003-7-3'),
('roig', 'Tavernes Valldigna', 'tomaques', 5, '1990-10-2'),
('cosí', 'Tavernes Valldigna', 'tomaques', 4, '2001-9-20'),
('cosí2', 'Tavernes Valldigna', 'arròs', 14, '2007-2-20'),
('cosí3', 'Tavernes Valldigna', 'arròs', 17, '1998-8-7'),
('cosí4', 'Tavernes Valldigna', 'taronja', 13, '2001-9-12'),
('cosina', 'Tavernes Blanques', 'cebes', 3, '2000-5-23');

-- ejercicio 3
select * from camps;
select nom, tipus, fanecades into outlife \Users\Lucas\Documents\1DAM\Base de Datos\camps.txt
	where (tipus = 'arròs') and (tipus = 'taronja' and poble like 'TAV' and 
    between data_compra = 2000-00-00 and 2015-00-00;

-- ejercicio 4
select * from tipus_camps;
update tipus_camps set ingres_per_fanecada = ingres_per_fanecada /166; -- round

-- ejercicio 5
delete from camps where not (tipus = 'arròs' and tipus = 'taronja' and tipus = 'llimes');

-- ejercicio 6
select min(fanecades) as fanecades_xicotet from camps 
	where tipus = 'taronja' or tipus = 'arros';
    
-- ejercicio 7
select poble, count(*) as q_camps, tipus from camps group by tipus;

-- ejercicio 8

select tipus as tipus_camp from tipus_camps where ingres_per_fanecada > 5000 group by tipus
	-- having ingres_per_fanecada > 5000;
  union
 select fanecades as motiu from camps where fanecades > 100 order by 1,2;
