#include <stdio.h>
void read(int* a,int n);
void sum(int* a, int n);
void print(int* a,int n);
int main(){
	int a[100],n;
	printf("ingrese el tamano del array \n");
	scanf("%d",&n);
	read(a,n);
	sum(a,n);
	print(a,n);
	return 0;
}
void read(int* a,int n){
	int i;
	printf("ingrese los numeros del array \n");
	for(i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
}
void sum(int* a,int n){
	int sum=0,i;
	for(i=0;i<n;i++){
		sum+=a[i];
	}
	printf("%d \n",sum);
}
void print(int* a,int n){
	int i;
	for(i=0;i<n;i++){
		printf("%d ",a[i]);
	}
	printf("/n");
}
