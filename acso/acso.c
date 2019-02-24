#include<stdio.h>
#include<string.h>
void convertb(unsigned long long number, int to){
	if(number==0)printf("0\n");
	else{
		char finalNumber[50];
	    int i;
	    for(i=0; i < 50; i++) finalNumber[i]='\0';
	    i = 0;
	    while(number>0){
	        int res = number%to;
	        if(res>9)res+= 'A'-10;
	        else res+='0';
	        number = number/to;
	        finalNumber[i]=res;
	        i++;
	    }
	    int j;
	    for(j=i-1; j>=0;j--)printf("%c",finalNumber[j]);
	    printf("\n");
	}
}
long long unsigned convert10(char number[10], int in){
    unsigned long long part=0;
    int i;
	long long pot = 1;
	for(i=0; i<strlen(number)-1; i++)pot*=in;
	int value;
	for(i=0; i<strlen(number); i++)	{
		if('0'<=number[i] && '9'>=number[i])value = number[i]-'0';
		else if('A'<=number[i] && 'Z'>=number[i])value = 10 + (number[i]-'A');
		part+=value*pot;
		pot=pot/in;
	}
	return part;
}
int test(int in, char number[10]){
	int i;
	for(i=0; i<strlen(number);i++){
		int value;
		if('0'<=number[i] && '9'>=number[i])value = number[i]-'0';
		else if('A'<=number[i] && 'Z'>=number[i])value = 10 + (number[i]-'A');
		if(in<=value)return 0;
	}
	return 1;
}
int main(){
	int cases;
	char number[10];
	int in;
	int to;
	scanf("%d",&cases);
	int c;
	for(c = 0; c<cases; c++){
		scanf("%d %s %d",&in,&number,&to);
		if(in<2 || in>36)printf("Error base origen\n");
		else if(!test(in, number))printf("Error numero\n");
		else if(to>36 || to<2)printf("Error base destino\n");
		else{
			if(in == to)printf("%s\n",number);
			else{
				convertb(convert10(number, in), to);
			}
		}
	}
	return 0;
}
