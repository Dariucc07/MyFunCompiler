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
    sprintf(c, "%d", f);
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
float c = 1.1;



/********************* Functions definition  *******/
float  somma(float numero){

c = c + numero;
return c;
}
int main(){
float app;
printf("%s\n","Benvenuto!");

printf("%s\t","Inserisci un numero e io continuerò a sommarlo finchè non sceglierai 0");

printf("%s","Numero:");
scanf("%f",&app);
while(app > 0){
app = somma(app);
printf("%s\n",stringConcat("Ora il numero è:", toStringFloat(app)));

printf("%s\n","Scegli un altro numero:");

scanf("%f",&app);
}
printf("%s\n","Okk hai scelto un numero minore di 0, ciao!");

}
