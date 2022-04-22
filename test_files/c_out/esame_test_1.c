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
int c = 1;



/********************* Functions definition  *******/
float  sommac(int a, float b, char *size){
float result;
result = a + b + c;
if(result > 100){
char valore[256] = "grande";*size = valore;
}
else {
char valore[256] = "piccola";
*size = valore;
}

for(int i = 1,j = 1;i < 20 && j > -20;i = i + 1,j = j - 1) {
printf("%s\n",stringConcat(stringConcat(stringConcat("ciao", toStringInt(i)), " "), toStringInt(j)));
}
for(float i = 1.1;i < 10;i = i + 1) {
printf("%s\n",stringConcat("ciao ", toStringFloat(i)));
}
return result;
}
int main(){
char size[256] = "ciao";
float result = sommac(1, 2.2, (size));
printf("%s\n","finito");

}
