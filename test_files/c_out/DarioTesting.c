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
float c = 2.2;
char d[256] = "donato";



/********************* Functions definition  *******/
int  esempio(int parametro, char* messaggio){
int nellino;
return parametro;
}
char  somma(float francesco, char *messaggio, int ciao){
char dario[256];
int frank;
int donato = 3;
if(frank){
esempio(5, "ciao");
}
strcpy(dario,"sono bello");
donato = esempio(5 + 4,"ciao")+esempio(4 * 2,"ciao")+esempio(donato,"ciao");
return * dario;
}
float  somma1(char* messaggio, char* pisello){
float dario;
int gilberto;
somma(dario, (messaggio), 0);
return dario;
}
void  somma2(char* messaggio){
int dario;
int donato;
int result;
result = dario + donato;
}
char  somma3(char* messaggio){
int donato;
int dario;
return * messaggio;
}
char  somma6(char* somma6){
int dario;
return * somma6;
}
int main(){
char dario[256];
strcpy(dario,"sono bello");
}
