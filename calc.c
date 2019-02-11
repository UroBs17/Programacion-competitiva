#include <stdio.h>
float add(float a,float b);
float subt(float a,float b);
float times(float a,float b);
float div(float a,float b);
void menu(float a,float b,char op);
int main(){
	float a,b,res;
	char op;
	menu(a,b,op);
	printf("%f %c %f",a,op,b);
	if(op=='+'){
		res=add(a,b);
	}else if(op=='-'){
		res=subt(a,b);
	}else if(op=='*'){
		res=times(a,b);
	}else if(op=='/' && b!=0.0){
		res=div(a,b);
	}
	printf("El resultado de su operacion es %f",res);
}
void menu(float a,float b,char op){
	printf("Ingrese la operacion de la forma 'a op b'(siendo op : + , -, *, /) \n");
	scanf("%f %c %f",&a,&op,&b);
}
float add(float a,float b){
	return a+b;
}
float subt(float a,float b){
	return a-b;
}
float times(float a,float b){
	return a*b;
}
float div(float a,float b){
	return a/b;
}
