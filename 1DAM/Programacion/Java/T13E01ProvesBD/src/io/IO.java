/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class IO {  // CLASSE PER ALS MÈTODES GENERALS D'ENTRADA I EIXIDA 
//***********************************************************************
//           FUNCIONS D'ESCRIPTURA
//***********************************************************************
public static void imprimir(boolean b)  {System.out.println(b);}
public static void imprimir(byte b)     {System.out.println(b);}
public static void imprimir(int i)      {System.out.println(i);}
public static void imprimir(float f)    {System.out.println(f);}
public static void imprimir(double d)   {System.out.println(d);}
public static void imprimir(char c)     {System.out.println(c);}
public static void imprimir(String s)   {System.out.println(s);}
public static void imprimir(int v[])            {imprimirVectorEnters(v);}
public static void imprimir(int v[], int n)     {imprimirVectorEnters(v, n);}
public static void imprimir(float v[])          {imprimirVectorReals(v);}
public static void imprimir(float v[], int n)   {imprimirVectorReals(v, n);}
public static void imprimir(int m[][])          {imprimirMatriuEnters(m);}
public static void imprimir(float m[][])        {imprimirMatriuReals(m);}

//***********************************************************************
/** Imprimix tot un vector d'enters */
public static void imprimirVectorEnters(int v[]){
    imprimirVectorEnters(v, v.length);
}
//***********************************************************************
/** Imprimix els n primers elements d'un vector d'enters */
public static void imprimirVectorEnters(int v[],int n){
    if (n>v.length)
        n=v.length;
    for(int i=0;i<n;i++){
        System.out.print(v[i]);
        if(i<n-1)
            System.out.print(',');
        else
            System.out.println();
    }
}
//***********************************************************************
/** Imprimix tot un vector de reals */
public static void imprimirVectorReals(float v[]){
    imprimirVectorReals(v, v.length);
}
//***********************************************************************
/** Imprimix els n primers elements d'un vector de reals */
public static void imprimirVectorReals(float v[], int n){
    if (n>v.length)
        n=v.length;
    for(int i=0;i<n;i++){
        System.out.print(v[i]);
        if(i<n-1)
            System.out.print(" , ");
        else
            System.out.println();
    }
}
//***********************************************************************
/** Imprimix una matriu d'enters */
    public static void imprimirMatriuEnters(int m[][]){
        for (int i=0; i<m.length; i++) {
            imprimirVectorEnters(m[i]);
        }
    }
//***********************************************************************
/** Imprimix una matriu de reals */
    public static void imprimirMatriuReals(float m[][]){
        for (int i=0; i<m.length; i++) {
            imprimirVectorReals(m[i]);
        }
    }
//***********************************************************************
//           FUNCIONS DE LECTURA
//***********************************************************************
public static String llegirCadena(){
    BufferedReader teclat=new BufferedReader(new InputStreamReader(System.in));
    String linia="";
    //System.o=0;ut.print("Dóna'm una cadena: ");
    try{
        linia=teclat.readLine();
    }
    catch(IOException e){
        System.out.print("Error d'entrada de dades "+e.getMessage());
    }
    return linia;
}
//***********************************************************************
public static int llegirEnter(){
    BufferedReader teclat=new BufferedReader(new InputStreamReader(System.in));
    String linia="";
    int n=0;
    boolean error = false;
    do
        try{
            error = false;
            linia=teclat.readLine();
            n=Integer.parseInt(linia);
        }
        catch(Exception e){
            System.out.println("Error d'entrada de dades "+e.getMessage());
            System.out.println("Dóna'm un número enter:");
            error = true;
        }
    while (error);
    return n;
}
//***********************************************************************
public static int llegirNatural(){
    int n=0;
    do{
       n = llegirEnter();
       if (n<0) {System.out.println("Error. Dónam un número positiu:");}
    }while(n<0);
    return n;
}
//***********************************************************************
public static float llegirReal(){
    BufferedReader teclat=new BufferedReader(new InputStreamReader(System.in));
    String linia="";
    float n=0;
    boolean error = false;
    do
        try{
            error = false;
            linia=teclat.readLine();
            n=Float.parseFloat(linia);
        }
        catch(Exception e){
            System.out.println("Error d'entrada de dades "+e.getMessage());
            System.out.println("Dóna'm un número real:");
            error = true;
        }
    while (error);
    return n;
}
//***********************************************************************
public static char llegirCaracter(){
    char lletra='0';
    try{
        lletra=(char) System.in.read(); // consumix 1 lletra
        System.in.read();        // consumix altre caràcter (per a l'INTRO)
    }
    catch(IOException e){
       System.out.print("Error d'entrada de dades "+e.getMessage()); 
    }
    return lletra;
}
//***********************************************************************
public static void llegirVectorEnters(int v[]){
    for (int i=0; i<v.length; i++){
        System.out.print("v["+i+"]=");
        v[i]=llegirEnter();
    } 
}
//***********************************************************************
public static void llegirVectorReals(float v[]){
    for (int i=0; i<v.length; i++){
        System.out.print("v["+i+"]=");
        v[i]=llegirReal();
    } 
}
//***********************************************************************
public static boolean acceptar(){
    char c = Character.toLowerCase(IO.llegirCaracter());
    return (c == 's' || c == 'y'); 
}

//***********************************************************************
//           FI DE LES FUNCIONS DE LECTURA / ESCRIPTURA
//***********************************************************************


}
