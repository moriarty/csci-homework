#include<stdio.h>
#include<stdlib.h>

int main(void){

	int length, quantity;
	char type = 'g';
	float total=0.0, cost;
	
	while(type != 'q' || type !='Q'){
			
		printf("Enter store code and quantity: ");
		//scanf("%c%d%dhello",&type,&length,&quantity);
		scanf("%c",&type);

		if(type == 'q' || type =='Q'){
			return 1;
			exit ;
		} else 
			scanf("%d%d",&length,&quantity);
		
		if(type == 'u' || type == 'U'){
			if(length == 6){
				cost = quantity*24.0;
				total += cost;
			}else if(length == 10){
				cost = quantity*36.0;
				total += cost;
			}else{
				printf("\nINVALID\n");
				continue;
			}

			printf("%d USB cables (%d foot) costs $%.2f (total = $%.2f)\n", quantity, length, cost, total);

		}else if(type == 'e' || type == 'E'){
			if(length == 25){
				cost = quantity*18.0;
				total += cost;
			}else if(length == 50){
				cost = quantity*30.0;
				total += cost;
			}else{
				printf("\nINVALID\n");
				continue;
			}

			printf("%d Ethernet cables (%d foot) costs $%.2f (total = $%.2f)\n", quantity, length, cost, total);

		}else
			printf("\n\tINVALID\n");
	}
}
