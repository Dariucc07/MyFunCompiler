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
void  myFun(int esempio){
int j;
for( int i = 1; i < 20 && j > -20 ; i = i + 1;) {
	 printf("%s\n","ciao");
 
 }
}
int main(){


}
