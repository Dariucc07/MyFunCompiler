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
int prova1 = 1;
int prova2 = 2;



/********************* Functions definition  *******/
int  sommaout(int *a, int *b){
int c = 0;
c = *a + *b;
*a = c;
*b = c;
return 1;
}
int main(){
int a = 1;
int b = 2;
printf("%s\n","Ciao!");

printf("%s\n","Scegli due numeri");

printf("%s","Numero1:");
scanf("%d",&a);
printf("%s","Numero2:");
scanf("%d",&b);
if(sommaout(&(a), &(b)) == 1){
printf("%s\n",stringConcat("Ora la somma e ", toStringInt(a)));

printf("%s\n","Entrambi i numeri ora hanno lo stesso valore della somma");

printf("%s\t","Infatti");

printf("%s\t",stringConcat(stringConcat(stringConcat("A=", toStringInt(a)), "B="), toStringInt(b)));

}
}
