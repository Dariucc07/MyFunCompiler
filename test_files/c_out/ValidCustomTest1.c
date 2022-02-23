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
int apparente;



/********************* Functions definition  *******/
int  scambia(int *a, int *b){
int app;
app = *b;
*b = *a;
*a = app;
return 1;
}
int main(){
int numero1;
int numero2;
char scelta[256] = "no";
printf("%s","vuoi vedere una magia?(si/no)");
scanf("%s",&scelta);
if((strcmp(scelta,"si")==0)){
printf("%s\n",stringConcat("Bene. La Magia Inizia!", "Inserisci due Numeri:"));

printf("%s","Numero1:");
scanf("%d",&numero1);
printf("%s","Numero2:");
scanf("%d",&numero2);
if(scambia(&(numero1), &(numero2))){
printf("%s\n","Perfetto!");

printf("%s",stringConcat("Ora il tuo Numero1 e' ", toStringInt(numero1)));

printf("%s\n",stringConcat(" e il tuo Numero2 e' ", toStringInt(numero2)));

printf("%s\t","");

}
}
else {
printf("%s\n"," Ah ma allora sei cattivo! Va bene...");

}

printf("%s\t","ciao bello!!!");

}
