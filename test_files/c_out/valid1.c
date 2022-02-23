#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

char * toStringFloat(double f){
    char* c= (char*) malloc(50); //size of the number
    sprintf(c, "%g", f);
    return c;
}
char * toStringInt(int f){
    char* c= (char*) malloc(50); //size of the number
    itoa(f,c,10);
    return c;
}

char * stringConcat(char * s1,char * s2){
    char* c= (char*) malloc(strlen(s1)+strlen(s2)+1);
    c[0]='\0';
    strcpy(c,s1);
    strcat(c,s2);
    return c;
}


/********************* Variable Declarations ****************/
int c = 1;



/********************* Functions definition  *******/
float  sommac(int a, float b, char* size){
float result;
result = a + b + c;
if(result > 100){
char valore[256] = "grande";strcpy(size,valore);
}
else {
char valore[256] = "piccola";
strcpy(size,valore);
}

return result;
}
void  stampa(char* messaggio){
int i = 1;
while(i <= 4){
int incremento = 1;printf("%s\n","");

i = i + incremento;
}
printf("%s\n",messaggio);

}
int main(){
int a = 1;
float b = 2.2;
char taglia[256];
char ans[256] = "no";
float risultato = sommac(a, b, (taglia));
stampa(stringConcat(stringConcat(stringConcat(stringConcat(stringConcat(stringConcat(stringConcat("la somma di ", toStringInt(a)), " e "), toStringFloat(b)), " incrementata di "), toStringInt(c)), " è "), taglia));
stampa(stringConcat("ed è pari a ", toStringFloat(risultato)));
printf("%s\t","vuoi continuare? (si/no)");

scanf("%s",&ans);
while((strcmp(ans,"si")==0)){
printf("%s","inserisci un intero:");
scanf("%d",&a);
printf("%s","inserisci un reale:");
scanf("%f",&b);
risultato = sommac(a, b, (taglia));
stampa(stringConcat(stringConcat(stringConcat(stringConcat(stringConcat(stringConcat(stringConcat("la somma di ", toStringInt(a)), " e "), toStringFloat(b)), " incrementata di "), toStringInt(c)), " è "), taglia));
stampa(stringConcat(" ed è pari a ", toStringFloat(risultato)));
printf("%s","vuoi continuare? (si/no):\t");
scanf("%s",&ans);
}
printf("%s\n","");

printf("%s","ciao");

}
