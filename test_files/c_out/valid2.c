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




/********************* Functions definition  *******/
int  print_menu(){
int choose;
printf("%s\n","Scegli l'operazione da svolgere per continuare");

printf("%s\n","\t(1) Somma di due numeri");

printf("%s\n","\t(2) Moltiplicazione di due numeri");

printf("%s\n","\t(3) Divisione intera fra due numeri positivi");

printf("%s\n","\t(4) Elevamento a potenza");

printf("%s\n","\t(5) Successione di Fibonacci (ricorsiva)");

printf("%s\n","\t(6) Successione di Fibonacci (iterativa)");

printf("%s\n","\t(0) Esci");

printf("%s","--> ");
scanf("%d",&choose);
return choose;
}
void  do_sum(){
float op1;
float op2;
printf("%s\n","\n(1) SOMMA\n");

printf("%s","Inserisci il primo operando: ");
scanf("%f",&op1);
printf("%s","Inserisci il secondo operando: ");
scanf("%f",&op2);
printf("%s\n","");

printf("%s\n",stringConcat(stringConcat(stringConcat(stringConcat(stringConcat("La somma tra ", toStringFloat(op1)), " e "), toStringFloat(op2)), " vale "), toStringFloat(op1 + op2)));

}
void  do_mul(){
float op1;
float op2;
printf("%s\n","\n(2) MOLTIPLICAZIONE");

printf("%s","\nInserisci il primo operando: ");
scanf("%f",&op1);
printf("%s","Inserisci il secondo operando: ");
scanf("%f",&op2);
printf("%s\n","");

printf("%s\n",stringConcat(stringConcat(stringConcat(stringConcat(stringConcat("La moltiplicazione tra ", toStringFloat(op1)), " e "), toStringFloat(op2)), " vale "), toStringFloat(op1 * op2)));

}
void  do_div_int(){
int op1;
int op2;
printf("%s\n","\n(3) DIVISIONE INTERA");

printf("%s","\nInserisci il primo operando: ");
scanf("%d",&op1);
printf("%s","Inserisci il secondo operando: ");
scanf("%d",&op2);
printf("%s\n","");

printf("%s\n",stringConcat(stringConcat(stringConcat(stringConcat(stringConcat("La divisione intera tra ", toStringInt(op1)), " e "), toStringInt(op2)), " vale "), toStringInt(op1 / op2)));

}
void  do_pow(){
float op1;
float op2;
printf("%s\n","\n(4) POTENZA");

printf("%s","\nInserisci la base: ");
scanf("%f",&op1);
printf("%s","Inserisci l'esponente: ");
scanf("%f",&op2);
printf("%s\n","");

printf("%s\n",stringConcat(stringConcat(stringConcat(stringConcat(stringConcat("La potenza di ", toStringFloat(op1)), " elevato a "), toStringFloat(op2)), " vale "), toStringFloat(pow(op1, op2))));

}
int  recursive_fib(int n){

if(n == 1){
return 0;
}
if(n == 2){
return 1;
}
return recursive_fib(n - 1) + recursive_fib(n - 2);
}
int  iterative_fib(int n){

if(n == 1){
return 0;
}
if(n == 2){
return 1;
}
if(n > 2){
int i = 3;
int res = 1;
int prev = 0;while(i <= n){
int tmp = res;res = res + prev;
prev = tmp;
i = i + 1;
};
return res;
}
return -1;
}
void  do_fib(int recursive){
int n;
char message[256];
printf("%s\n","\n(5) FIBONACCI");

printf("%s","\nInserisci n: ");
scanf("%d",&n);
printf("%s\n","");

strcpy(message,stringConcat(stringConcat("Il numero di Fibonacci in posizione ", toStringInt(n)), " vale "));
if(recursive){
strcpy(message,stringConcat(message, toStringInt(recursive_fib(n))));
}
else {
strcpy(message,stringConcat(message, toStringInt(iterative_fib(n))));
}

printf("%s\n",message);

}
void  do_operation(int choose){

if(choose == 1){
do_sum();
}
else {
if(choose == 2){
do_mul();
}
else {
if(choose == 3){
do_div_int();
}
else {
if(choose == 4){
do_pow();
}
else {
if(choose == 5){
do_fib(1);
}
else {
if(choose == 6){
do_fib(0);
}
}

}

}

}

}

}
void  print_continua(int* continua){
char in[256];
printf("%s","Vuoi continuare? (s/n) --> ");
scanf("%s",&in);
if((strcmp(in,"s")==0)){
continua = 1;
}
else {
continua = 0;
}

}
int main(){
int choose = 0;
int continua = 1;
while(continua){
choose = print_menu();
if(choose == 0){
continua = 0;
}
else {
do_operation(choose);
print_continua(&(continua));
}

}
}
