use geografia;

select * from limita;
select * from mars;
select * from passaper;
select * from provincies;
select * from rius;
-- 1. Inventa’t un enunciat de sentència SQL per a cadascun dels següents apartats i
-- resol-lo.
-- a. Select usant group by, having i order by

-- Mostrar numero de rios por mar, la minima (mas de 310m km) y maxima de rios por mar
select mar, count(*), min(longitud), max(longitud) 
	from rius group by mar
			having (min(longitud) > 310)
				order by mar;

-- b. Select usant union

-- Cantidad provincias donde consta que limita con otra

select count(*)
	from provincies
		where codi in(
			select prov1
				from limita
			union
            select prov2
				from limita);

-- c. Select usant multitaula
-- cantidad de rios donde el mar sea 'Mediterrani'

select count(*) 
	from rius, mars
		where rius.mar = mars.codi
			and mars.nom = 'Mediterrani';
            
            
-- 2. Nom del riu més llarg (i els kms)
select nom, longitud from rius
	where longitud = (select max(longitud) from rius);
    
-- 3. De cada mar, mostrar el seu nom i el nom del riu més llarg que desemboca en ell (i
-- els kms del riu).

select * from mars;
select * from rius;

select rius.nom, m1.nom , rius.longitud
from rius, mars as m1
where rius.mar = m1.codi 
and rius.longitud =
(select max(longitud)
	from rius, mars as m2
		where m2.nom = m1.nom
        and rius.mar = m2.codi);
        

-- 4. Nom dels mars per on no desemboca cap riu.
-- (Han d’eixir: Cantàbric)

select m1.nom
	from mars as m1
		where
        m1.nom not in( 
			select m2.nom
				from mars as m2 , rius as r2
					where r2.mar = m2.codi
                    );
                    
-- 5. Quantitat de províncies per les quals no passa cap riu.
-- (Ha d’eixir: 31)

select * from provincies;
select * from passaper;

select count(*)
	from provincies
		where codi not in ( 
        select prov
			from passaper);

-- 6. Quantitat de províncies on no consta que limiten amb cap altra.
-- (Ha d’eixir: 37)

select count(*)
	from provincies
		where codi not in(
			select prov1
				from limita
			union
            select prov2
				from limita);
                
-- 7. Intenta esborrar les províncies per on no passen per cap riu. Per què no et deixa?

delete from provincies
	where codi not in (select prov from passaper);
    
    -- NO SE PUEDE BORRAR POR QUE HAY UNA FOREIGN KEY ENTRE PROVINCIES Y PASSAPER
    
-- 8. Esborra les províncies que no passen per cap riu ni limiten amb cap altra.
-- (No deu esborrar-ne ninguna perquè cap compleix la condició).

delete from provincies
	where codi not in(select prov1, prov2
								from limita
									where (prov1 is null) and (prov2 is null);
   
-- 10. Nom dels rius on totes les províncies per on passa tenen més de 10000 km2.
-- (Han d’eixir: Duero, Guadiana i Xúquer).

select distinct nom
	from rius, passaper
		where rius.codi = passaper.riu
        and
        passaper.prov in
(select codi
	from provincies
		where km2 > 10000)