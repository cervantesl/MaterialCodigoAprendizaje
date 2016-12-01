/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2016_psp_agencianoticies;

import java.util.Random;

/**
 *
 * @author joange
 */
public class Noticia {
     private static Random r= new Random(System.currentTimeMillis());
     
     static String noticies[] = {
         "El ministeri de l'interior compra 10 pistoles d'aigua", 
         "El papa decideix comprar-se una sotana amb els colors de spiderman", 
         "Castanyo Rinaldo ha engreixat 10 grams aquest cap de setmana",
         "Localizan una cabra que circulaba en ciclomotor en Tenerife", 
         "La policía rumana multa a cuatro españoles por colarse de noche en el castillo de Drácula", 
         "Extirpan el útero a una paciente por un error ortográfico", 
         "Un perturbado pincha las ruedas de decenas de coches y pide perdón en una nota",
         "Un gordo se come el menú de un DVD", 
        "Un hombre se divorcia accidentalemente de su mujer mientras dormía", 
        "Compra 4 coches en un año sin tener carné", 
        "Comer panceta como si fuera pescado azul",
        "Sin Ramón García presentando las Campanadas, millones de españoles se quedarán atrapados en 2016 para siempre", 
        "Año 1604: Nace Johannes Bach, fundador de los Bach Street Boys", 
        "Los niños que quieran jugar a los médicos tendrán que jugar primero a sacarse la carrera", 
        "Detenido un lorquino por gritar en el juicio a su padre: «¡Así va España!»",
        "Los bebés empiezan a nacer con el acto reflejo de hacerse ‘selfies’", 
        "Detenido un ladrón tras perder su currículo en el piso que asaltó", 
        "Piden una hipoteca para afrontar las bodas de sus amigos",
        "Sorprenden comprando en el Black Friday al típico que odia Halloween por ser un invento americano", 
        "Harry Potter firma en favor del referéndum del PP, dos veces"
     };
     
     public static String getNoticia(){
         return noticies[r.nextInt(noticies.length-1)];
     }
}
