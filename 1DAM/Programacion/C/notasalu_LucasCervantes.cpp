/*Cal fer un programa per a gestionar les notes dels alumnes (només per a una
assignatura i una avaluació).*/

#include <stdio.h>
#define QALU 3 //cantidad de alumnos
#define NOPRE -1
main ()
{
		//Declaracion de variables
		
		int op,notes[QALU+1],alu,max,min,total,salir;
		float promedio;
		int notacorrecta = 0;
		int introducida = -1;
		
		char resp;
		printf("\t\t\t***PROGRAMA LUCAS CERVANTES***\n");
		
		do{
		
		//menu
		
		printf("========MENU======\n");
		printf("1.-introduce las notas\n"); 
		printf("2.-modificar una nota\n"); 
		printf("3.-mostrar notas\n"); 
		printf("4.-mostras estadisticas\n"); 
		printf("5.-salir\n"); 
		printf("========\n");
		printf("Elige una opcion:");
		scanf("%i",&op);
		
		salir = 0;
		switch(op)
		{
			//introducir notas
			
			case 1: 
			
				
				for(alu = 1; alu <= QALU; alu++){
					
					do{	
					printf("Dime la nota del alumno %i: ",alu);
					scanf("%i",&introducida);
					if(introducida >= 0 && introducida <= 10 || introducida == NOPRE){
						printf("Nota correcta\n");
						notacorrecta = 1;
						
						notes[alu] = introducida;
					}
						
						else{	
							printf("Nota incorrecta, introduce una nota correcta\n");
							notacorrecta = 0;
						
						}
					}
					while(notacorrecta == 0);
				}
				
			break;
			
			//modificar notas
			case 2: 
				printf("De que alumno quieres modificar la nota?\n"); 
				scanf("%i",&alu);
				if(alu == alu){
					printf("Pon la nueva nota del alumno %i\n",alu);
					scanf("%i",&notes[alu]);
				}
					
			break;
			
			//mostrar notas
			case 3: 
			
					printf("\t\t\tALUMNO\t\tNOTA");
					for(alu = 1; alu <= QALU; alu++){
						
						printf("\n\t\t\t%i \t\t%i\n",alu,notes[alu]);
					}
					
			break;
			
			//estadisticas
			case 4: 
				//maxima nota
				max = notes[1];
				for(alu = 1; alu <= QALU; alu++){
					
					if(max < notes[alu]){
						
						max = notes[alu];
					}
					
				}	
				printf("La nota maxima ha sido un %i\n",max);
				
				//minima nota
					min = notes[1];
				for(alu = 1; alu <= QALU; alu++){
					
					if(min > notes[alu]){
						
						min = notes[alu];
					}
					
				}	
				printf("La nota minima ha sido un %i\n",min);
				
				//promedio
				total = 0;
				for(alu = 1; alu <=QALU; alu++){
					total+=notes[alu];
				}
				promedio = (float)total / QALU;
				printf("La media ha sido un %f\n",promedio);	
						
			break;
			
			case 5: printf("salir\n");
				
				printf("Estas seguro que quieres salir? (S/N)");
				getchar();
				scanf("%c",&resp);
				if(resp == 'S' || resp == 's'){
					salir = 1;
				}
				break;
		
			case 6: default: printf("No existe esa opcion\n"); break;
		}
		}
		while(salir == 0);
			
		
		getchar();
		return 0;
}
