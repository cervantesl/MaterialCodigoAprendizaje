select * from llibres;

-- Exercici 1: crea la vista prestecs2015 amb el nom del soci i el nom del llibres prestats en 2015
create view prestecs2015 as
select socis.nom as soci,  llibres.nom as llibre 
from socis, llibres, prestecs
where socis.codi = prestecs.soci
and prestecs.llibre = llibres.codi
and prestecs.data like "%2015%";

-- Exercici 2: Nom del llibre i nom del llibre del qual en forma part (el llibre a qui "pertany".
-- En la capçalera de les columnes caldra mostrar llibre i pertany_a
select llibres.nom as llibre, llibresPrestats.nom as pertany_a
from llibres, llibres as llibresPrestats
where llibres.pertany_a = llibresPrestats.codi;

-- Exercici 3:
select llibres.nom, llibres.pagines
from llibres
where llibres.pagines = (select max(pagines) from llibres);

-- Exercici 4:
select llibres.tipus, llibres.nom, llibres.pagines
from llibres
where llibres.pagines = (select max(pagines) from llibres as l2
						where llibres.tipus = l2.tipus);

-- Exercici 5:
-- estoy haciendo el apartado B
select socis.nom
from socis
where not exists (select *
					from llibres, prestecs
					 where prestecs.llibre = llibres.codi
                     and prestecs.soci = socis.codi
					and llibres.tipus != 'aventures');

-- De esta manera no funcionaria ya que el prestec se puede repetir
select socis.nom
from socis
where (select count(*) from prestecs
		where prestecs.soci = socis.codi)
        =
        (select count(*) from llibres, prestecs
		 where prestecs.llibre = socis.codi
		and llibres.tipus != 'aventures');


-- Exercici 6:
delete from socis
where codi not in (select soci from prestecs);

select nom from socis
where codi not in (select soci from prestecs);

-- Exercici 7:
CREATE USER secretari IDENTIFIED BY 'secre';

GRANT INSERT(codi, nom), UPDATE(nom)
ON biblioteca.socis
TO secretari;

-- Exercici 8: 
-- Si hacemos el segundo update sin acabar la primera transaccion, no verá
-- los efectos del primer update.
-- si perdemos la conexion del primer update y siguieramos en la misma conexion no se haría el segundo update.

-- Exercici 9:
delimiter // 
create function morositat(codiSoci int) returns integer
begin
declare qllibres int default 0;
declare qsoci int default 0;
select count(*) into qsoci
from socis
where codi = codiSoci;

if qsoci > 0 then

select count(*) into qllibres
from prestecs
where prestecs.soci = codiSoci
and tornat = 'n';
return qllibres; 

else
return -1;
end if;
end //

-- Exercici 10:
select socis.nom, morositat(socis.codi) as qllibres
from socis
where morositat(socis.codi) > 0;