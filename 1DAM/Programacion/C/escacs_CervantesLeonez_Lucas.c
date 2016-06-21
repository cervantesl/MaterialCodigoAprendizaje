//Programa hecho por Lucas Cervantes - Ajedrez 1º DAM
#include <stdio.h>

#define TAMANO_TABLERO 8
//piezas
#define REY 'K'
#define ALFIL 'A'
#define REINA 'R'
#define CABALLO 'C'
#define TORRE 'T'
#define MOVIMIENTO '*'
#define IMPEDIMENTO 'I'
#define VACIO '_'

char tablero[TAMANO_TABLERO + 1][TAMANO_TABLERO + 1];
int posFila,posColumna;

//tablero vacio
void tableroVacio(){
	int fila, columna;
	for(fila = 1; fila <= TAMANO_TABLERO; fila++){
		for(columna = 1; columna <= TAMANO_TABLERO; columna++){
			tablero[fila][columna] = VACIO;
		}
	}
}
//imprimir tablero
void imprimirTablero(){
	int fila, columna;
	printf("  ");
	for(fila = 1; fila <= TAMANO_TABLERO; fila++){
		printf("%i ",fila );
	}
	printf("\n");
	for(fila = 1; fila <= TAMANO_TABLERO; fila++){
		printf("%i|", fila);
		for(columna = 1; columna <= TAMANO_TABLERO; columna++){
			printf("%c|",tablero[fila][columna]);
		}
		printf("\n");
	}
}

//Posicion de la pieza
void posicion(char pieza){
	
		int fila, columna;
	
		printf("Dime la posicion:\n");
		printf("Fila:");
		scanf("%i", &posFila);
		printf("Columna:");
		scanf("%i", &posColumna);
					
		tablero[posFila][posColumna] = pieza;
		
	
}

//movimientos de la Torre
void movimientosTorre(){
	
	int fila,columna;
	
	//Movimiento hacia arriba
	for(fila=posFila-1; fila >= 1; fila--){ 
		if(tablero[fila][posColumna] == VACIO){
			tablero[fila][posColumna]=MOVIMIENTO;
		}	
		else{
			break;
		}
	}
	//movimiento hacia abajo
	for(fila=posFila+1;fila <= TAMANO_TABLERO; fila++){
		if(tablero[fila][posColumna] == VACIO){
			tablero[fila][posColumna]=MOVIMIENTO;
		}	
	}
	//movimiento hacia la derecha
	for(columna = posColumna+1; columna <= TAMANO_TABLERO; columna++){
		if(tablero[posFila][columna] == VACIO){
   			tablero[posFila][columna]=MOVIMIENTO;
		}
		else{
			break;
		}
	}
	//movimineto hacia la izquierda
	for(columna = posColumna-1; columna >=1; columna--){
		if(tablero[posFila][columna] == VACIO){	
			tablero[posFila][columna]=MOVIMIENTO;
		}
		else{
			break;
		}
	}
}

//movimientos del Alfil
void movimientosAlfil(){
	int fila,columna;
	
	//Arriba derecha
	for(fila = posFila-1, columna = posColumna+1; fila >=1 && columna <= TAMANO_TABLERO; fila-- , columna++){
		if(tablero[fila][columna] == VACIO){
			tablero[fila][columna] = MOVIMIENTO;
		}
		else{
			break;
		}	
	}
	//Arriba izquierda
	for(fila = posFila-1, columna = posColumna -1; fila >=1 && columna >=1; fila--, columna--){
		if(tablero[fila][columna] == VACIO){
			tablero[fila][columna] = MOVIMIENTO;
		}
		else{
			break;
		}
	}
	//Abajo derecha
	for(fila = posFila +1, columna = posColumna+1; fila >=1 && columna <= TAMANO_TABLERO; fila++, columna++){
		if(tablero[fila][columna] == VACIO){
			tablero[fila][columna] = MOVIMIENTO;
		}
		else{
			break;
		}
	}
	//abajo izquierda
	for(fila = posFila +1, columna = posColumna -1; fila <= TAMANO_TABLERO && columna >= 1; fila++, columna--){
		if(tablero[fila][columna] == VACIO){
			tablero[fila][columna] = MOVIMIENTO;
		}
		else{
			break;
		}
	}
}

//movimiento del Caballo
void movimientosCaballo(){
	
	int fila = posFila;
	int columna = posColumna;
	int giro = 1;
	int recto = 2;
	
	// 1 izquierda/derecha -> 1 arriba y 1 abajo
	if(columna + recto < TAMANO_TABLERO ){
		if(fila - giro >= 1 && tablero[fila - giro][columna + recto] == VACIO){
			tablero[fila - giro][columna + recto] = MOVIMIENTO;
		}
	
		if(fila + giro < TAMANO_TABLERO && tablero[fila + giro][columna + recto] == VACIO){
			tablero[fila + giro][columna + recto] = MOVIMIENTO;
		}	
	}
	
	if(columna - recto >= 1){
		if(fila - giro >= 1 && tablero[fila - giro][columna - recto] == VACIO){
			tablero[fila - giro][columna - recto] = MOVIMIENTO;
		}

		if(fila + giro < TAMANO_TABLERO && tablero[fila + giro][columna - recto] == VACIO){
			tablero[fila + giro][columna - recto] = MOVIMIENTO;
		}
	}
	
	
	if(fila + recto >=1){
		if(columna + giro < TAMANO_TABLERO && tablero[columna-recto][columna + giro] == VACIO){
			tablero[fila - recto][columna + giro] = MOVIMIENTO;
		}

		if(columna - giro >= 1 && tablero[fila - recto][columna - giro] == VACIO){
			tablero[fila - recto][columna - giro] = MOVIMIENTO;
		}
	}
	
	if(fila - recto >= 1){
		if(columna + giro < TAMANO_TABLERO && tablero[fila + recto][columna + giro] == VACIO){
			tablero[fila + recto][columna + giro] = MOVIMIENTO;
		}
		if(columna - giro >= 1 && tablero[fila + recto][columna - giro] == VACIO){
				tablero[fila + recto][columna - giro] = MOVIMIENTO;
		}
	
	}
			
}

//Movimientos del rey
void movimientosRey(){
	
	int fila,columna;
	
	for(fila = posFila-1; fila <= posFila + 1; fila++){
		for(columna = posColumna -1  ; columna <= posColumna+1; columna++){
			if(tablero[fila][columna] == VACIO){
					tablero[fila][columna] = MOVIMIENTO;
			}
		
		}
	}
}

//impedimento
void impedimento(){
	
		printf("Dime la posicion:\n");
		printf("Fila:");
		scanf("%i", &posFila);
		printf("Columna:");
		scanf("%i", &posColumna);
		if(tablero[posFila][posColumna] == VACIO){		
			tablero[posFila][posColumna] = IMPEDIMENTO;
		}	
		else{
			printf("Ya hay una ficha\n");
		}
}



//menu	
void main(){
	int salir,opcion;
	char pieza;
	int fila, columna,posFila,posColumna;
	tableroVacio();
	
	do{
		salir = 0;
		
		
		imprimirTablero();
		
		printf("\n");
		printf("====MENU AJEDREZ====\n");
		printf("\n");
		printf("1.-Mostrar movimientos de una pieza\n");
		printf("2.-Poner impedimento\n");
		printf("3.-Borrar tablero\n");
		printf("4.-Salir\n");
		printf("Elige una opcion: ");
		scanf("%i", &opcion);
		
		switch(opcion){
			case 1:
				
				printf("Dime una pieza: Caballo 'C', Dama 'D', Alfil 'A', Torre 'T', Rey 'R'\n");
				getchar();
				scanf("%c", &pieza);
				
				if(pieza == 'T' || pieza == 't'){
				
					posicion(pieza);
					movimientosTorre();
			
				}
				
				else if(pieza == 'A' || pieza == 'a'){
				
					posicion(pieza);
					movimientosAlfil();
				}
				
				else if(pieza == 'D' || pieza == 'd'){
				
					posicion(pieza);
					movimientosAlfil();
					movimientosTorre();
				}
				else if(pieza == 'C' || pieza == 'c'){
				
					posicion(pieza);
					movimientosCaballo();
				}
				
				else if(pieza == 'R' || pieza == 'r'){
					
					posicion(pieza);
					movimientosRey();
				}
				
				else{
					printf("La pieza no es valida\n");
					break;
				}
				
			break;
				
				
			case 2: 
				printf("Donde quieres poner el impedimento\n");
				impedimento();
	
			break;
			
			case 3:	
				tableroVacio();

			break;
			
			case 4:
				printf("Adios!");
				salir = 1;
				
			break;
			
			case 5: default:
			
				printf("La opcion no existe\n");
			
			break;	
						
		}
			
	}while(salir == 0);
	
	getchar();
}
