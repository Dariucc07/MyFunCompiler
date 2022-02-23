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




/********************* Functions definition  *******/
int main(){
float ultimo;
float penultimo;
float i;
float f;
i = 2;
penultimo = 0;
printf("%f\n",penultimo);

ultimo = 1;
printf("%f\n",ultimo);

while(i <= 10){
f = ultimo + penultimo;
printf("%s\n",stringConcat(toStringFloat(f), "\n"));

penultimo = ultimo;
ultimo = f;
i = i + 1;
f = 5 - 4;
}
}
