#include <stdio.h>
#include <string.h>
#include <math.h>




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
double op1;
double op2;
printf("%s\n","\n(1) SOMMA\n");

printf("%s","Inserisci il primo operando: ");
scanf("%f",&op1);
printf("%s","Inserisci il secondo operando: ");
scanf("%f",&op2);
printf("%s\n","");

printf("%s\n",strcat(strcat(strcat(strcat(strcat("La somma tra ", op1), " e "), op2), " vale "), op1 + op2));

}
void  do_mul(){
double op1;
double op2;
printf("%s\n","\n(2) MOLTIPLICAZIONE");

printf("%s","\nInserisci il primo operando: ");
scanf("%f",&op1);
printf("%s","Inserisci il secondo operando: ");
scanf("%f",&op2);
printf("%s\n","");

printf("%s\n",strcat(strcat(strcat(strcat(strcat("La moltiplicazione tra ", op1), " e "), op2), " vale "), op1 * op2));

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

printf("%s\n",strcat(strcat(strcat(strcat(strcat("La divisione intera tra ", op1), " e "), op2), " vale "), op1 / op2));

}
void  do_pow(){
double op1;
double op2;
printf("%s\n","\n(4) POTENZA");

printf("%s","\nInserisci la base: ");
scanf("%f",&op1);
printf("%s","Inserisci l'esponente: ");
scanf("%f",&op2);
printf("%s\n","");

printf("%s\n",strcat(strcat(strcat(strcat(strcat("La potenza di ", op1), " elevato a "), op2), " vale "), pow(op1, op2)));

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

message = strcat(strcat("Il numero di Fibonacci in posizione ", n), " vale ");
if(recursive){
message = strcat(message, recursive_fib(n));
}
else {
message = strcat(message, iterative_fib(n));
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
if(in == "s"){
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
