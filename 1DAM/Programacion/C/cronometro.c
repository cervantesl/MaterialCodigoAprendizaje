#include <stdio.h>
#include <windows.h>
main (){
	
	int h,min,seg,x;
	x = 1000;
	
	for(h = 0; h < 24; h++){
		
		for(min = 0; min < 60; min++){
			
			for(seg = 0; seg < 60; seg++){
				
				printf("Tiempo que llevas en el programa: %02i:%02i:%02i\r",h,min,seg);
				Sleep(x);
				
			}
			
		}
	}	
	
	
	
	
	getchar();
	return 0;
}
