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
int i = 1;



/********************* Functions definition  *******/
void  somma(){

while(i < 3){
int messaggio = 3;printf("%d\n",-i);

i = i + 1;
}
 while(! i < 3) { 
 	 char messaggio[256] = "ciao"; printf("%d\n",i);

i = i + 1;
if(i == 5){
i = 0;
printf("%s\n",messaggio);

} }
}
int main(){


}
