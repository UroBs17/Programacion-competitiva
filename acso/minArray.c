#include <stdio.h>
#include <float.h>
int main(){
	int n,i;
	float arrInt [100], min=FLT_MAX;
	printf("Ingrese la cantidad de numeros(no mayor a 100):\n");
	scanf("%d",&n);
	printf("Ingrese los numeros separados por espacios \n");
	for(i=0;i<n;i++){
		scanf("%f",&arrInt[i]);
		if(arrInt[i]<min){
			min=arrInt[i];
		}
	}
	printf("el minimo es %f \n",min);
	return 0;
}
