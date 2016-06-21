                                            -- EXERCICIS MULTITAULA -- 

-- 1. De cada partit volem mostrar els codis dels equips i el nom de la ciutat on juguen.
select partits.equipc, partits.equipf, ciutats.nom
from partits, equips, ciutats
where partits.equipc = equips.codi
and equips.ciutat = ciutats.codi;

-- 2. De cada partit que falta per jugar volem mostrar en quina data es disputarà, els noms
-- curts dels equips, els noms de les ciutats respectives i el total d’habitants de les dos
-- ciutats.
select jornades.data, eqc.nomcurt, eqf.nomcurt, cc.nom, cf.nom, cc.habitants, cf.habitants
from jornades, partits, equips as eqc, equips as eqf, ciutats as cc, ciutats as cf
where partits.jornada = jornades.num
and partits.equipc = eqc.codi
and partits.equipf = eqf.codi
and eqc.ciutat = cc.codi
and eqf.ciutat = cf.codi;

-- 3. De cada equip: el pressupost, el que es gasta amb els jugadors i el percentatge que
-- representa.

select equips.codi, equips.pressupost, sum(sou)
from equips, jugadors
where equips.codi = jugadors.equip
group by equip;

-- 4. Llista de jugadors on conste: nom del jugador i nom de la ciutat on juga.
select jugadors.nom, ciutats.nom
from jugadors, equips, ciutats
where jugadors.equip = equips.codi
and equips.ciutat = ciutats.codi;

-- 5. Quantitat total de gols de penal marcats per equips de ciutats de menys de 200000
-- habitants.
select sum(golejadors.penals) 
from golejadors, equips, ciutats
where golejadors.equip = equips.codi
and equips.ciutat = ciutats.codi
and ciutats.habitants > 200000;

-- 6. En quines dates s’han enfrontat el València i el Barça (sabent que els codis són “val” i
-- “bar”). Mostra quin jugaba a casa i qui fora i el resultat de gols.
select partits.equipc, partits.equipf, jornades.data
from partits, jornades
where partits.equipc = 'val' and partits.equipf = 'bar'
or
partits.equipc = 'bar' and partits.equipf = 'val'
and partits.jornada = jornades.num;

-- 7. En quines dates s’han enfrontat el València i el Barça (sabent que els noms curts són
-- “València” i “Barça”). Mostra quin jugaba a casa i qui fora (nom llargs) i el resultat
-- de gols.
select jornades.data, eqc.nomllarg, eqf.nomllarg, partits.golsc
from equips as eqc, equips as eqf, partits, jornades
where eqc.codi = partits.equipc
and eqf.codi = partits.equipf
and (eqc.nomcurt = 'València' and eqf.nomcurt= 'Barça') 
or (eqc.nomcurt = 'Barça' and eqf.nomcurt = 'València') 
and partits.jornada = jornades.num;

-- 8. Mostra parelles de jugadors on un d’ells cobra més de 10 voltes que l’altre. Mostra
-- també els seus sous.
select j1.nom, j1.sou, j2.nom, j2.sou
from jugadors as j1, jugadors as j2
where j1.sou > (j2.sou * 10);

-- 9. Modifica l’exercici anterior perquè també apareguen els respectius noms (llargs) dels
-- equips.
select j1.nom, j1.sou, eq1.nomllarg, j2.nom, j2.sou, eq2.nomllarg 
from jugadors as j1, jugadors as j2, equips as eq1, equips as eq2
where j1.sou > (j2.sou * 10)
and j1.equip = eq1.codi
and j2.equip = eq2.codi;

-- 10. Migcampistes que cobren més que algun davanter del seu equip. Cal mostrar els 2
-- noms i els 2 sous.
select j1.nom as mig, j1.sou, j2.nom as davanter, j2.sou
from jugadors as j1, jugadors as j2
where j1.equip = j2.equip
and j1.lloc = 'Mig'
and j2.lloc = 'davanter'
and j1.sou > j2.sou;

-- 11. Parelles de porter i golejador d’un mateix equip on el golejador haja marcat més gols
-- que els gols que ha encaixat el porter. Cal mostrar l’equip i els noms del porter i
-- golejador amb els gols respectius. Ordenat per l’equip i el nom del porter.
select jp.equip, jp.nom, porters.gols, jd.nom, golejadors.gols
from golejadors, jugadors as jp, jugadors jd, porters
where porters.equip = jp.equip
and porters.dorsal = jp.dorsal
and jp.lloc = 'porter'
and golejadors.equip = jd.equip
and golejadors.dorsal = jd.dorsal
and jd.lloc = 'davanter'
and golejadors.gols > porters.gols
and jp.equip = jd.equip;

