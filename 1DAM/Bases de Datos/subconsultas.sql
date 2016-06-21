-- 1. Dorsal, equip i gols del pitxitxi (el que ha marcat més gols).
select golejadors.dorsal, golejadors.equip, golejadors.gols
from golejadors
where gols = (select max(gols) from golejadors);

-- 2. Nom del pitxitxi
select jugadors.nom
from jugadors, golejadors
where jugadors.equip = golejadors.equip
and jugadors.dorsal = golejadors.dorsal
and golejadors.gols = (select max(gols) from golejadors);

-- 3. Mostra el nom i sou del jugador millor pagat de tota la lliga.
select jugadors.nom, jugadors.sou
from jugadors
where jugadors.sou = (select max(sou) from jugadors);

-- 4. Mostra el nom i sou del jugador millor pagat de cada equip.
select j1.nom, j1.sou, j1.equip
from jugadors as j1
where j1.sou = (select max(sou) from jugadors as j2, equips
				where j1.equip = j2.equip);
                
-- 5. Jugador que més cobra en cada equip dins la seua categoria (lloc). Cal mostrar el nom
-- de l’equip, el nom del jugador, el lloc i el sou (expressat en milions d’euros, amb 1
-- decimal). Ordenat per equip i lloc.
select jugadors.equip, jugadors.nom, jugadors.lloc, jugadors.sou
from jugadors
where jugadors.sou = (Select max(sou) from jugadors as j2
						where jugadors.lloc = j2.lloc
						and jugadors.equip = j2.equip);
                        
-- 6. Mostra totes les dades dels partits on més gols es marcaren de tot el campionat.
select *
from partits
where golsc+golsf = (select max(golsc+golsf) from partits);

-- 7. Mostra totes les dades dels partits on més gols es marcaren de cada jornada. Ordenat
-- per la jornada.
select  * 
from partits
where golsc+golsf = (select max(golsf+golsc) from partits as p2
						where partits.jornada = p2.jornada) order by jornada;

-- 8. Noms dels jugadors dels equips del partit on més gols es marcaren. Mostra també el
-- codi dels seus equips. Ordenat per equip i nom de jugador.


select jugadors.nom, jugadors.equip
from jugadors, equips, partits
where jugadors.equip = equips.codi and
golsc+golsf = (select max(golsc+golsf) from partits as p2
				where partits.jornada = p2.jornada);

-- 9. Jornades en les quals s’han marcat més gols que la jornada anterior.
select p1.jornada, sum(golsc+golsf) 
from partits as p1
group by jornada
having sum(golsc+golsf) > (select sum(golsf+golsc) from partits as p2
							where p1.jornada = p2.jornada -1);

-- 11. Mostra els noms dels jugadors que cobren més que tot un altre equip sencer
select jugadors.nom
from jugadors
where jugadors.sou > any
(select sum(j2.sou) from jugadors as j2
group by equip);

-- 12. Nom dels jugadors que han marcat més gols que tot un altre equip sencer.
select jugadors.nom
from jugadors, golejadors
where jugadors.equip = golejadors.equip
and golejadors.dorsal = jugadors.dorsal and 
golejadors.gols > any (select sum(gols) from golejadors group by equip);

-- 13. Nom dels jugadors que han marcat més gols que tot un altre equip sencer.
-- També ha d’aparéixer el codi de l’equip del golejador i el codi de l’equip a qui
-- supera. Ordenat per l’equip del golejador, nom del golejador i equip a qui
-- supera.

select jugadors.nom, jugadors.equip, eg.codi
from jugadors, equips as eg, golejadors
where golejadors.equip = jugadors.equip and
golejadors.dorsal = jugadors.dorsal
and golejadors.gols > any (select sum(gols) from golejadors as g2
							where eg.codi = g2.equip);
    
-- 15. Jugadors (equip i nom) que encara no han marcat cap gol. Ordenat per equip i
-- nom.
select jugadors.equip, jugadors.nom
from jugadors
where jugadors.dorsal not in (select golejadors.dorsal
								from golejadors
									where golejadors.equip = jugadors.equip
                                    and golejadors.gols > 0);
                                    


