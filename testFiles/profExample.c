#include <stdio.h>
#include <string.h>
#include <math.h>




/********************* Variable Declarations ****************/
int c = 1;
int prova1 = 1;
int prova2 = 2;



/********************* Functions definition  *******/
double  sommac(int a, double b, char* size){
double result;
char valore[256] = "grande";
char valore2[256] = "piccola";
result = a + b * c;
if(result > 100){
size = valore;
}
else {
size = valore;
}

return result;
}
void  stampa(char* messaggio){
int incremento = 1;
int i = 1;
while(i <= 4){
printf("%s\n","");

i = i + incremento;
}
printf("%s\n",messaggio);

}
int main(){
int a = 1;
double b = 2.2;
char ans[256];
char ans2[256];
int resu = a + a;
char taglia[256];
double risultato = sommac(a, b, &(taglia));
stampa(strcat(strcat(strcat(strcat(strcat(strcat(strcat("la somma di ", a), " e "), b), " incrementata di "), c), " è "), taglia));
stampa(strcat("ed è pari a ", risultato));
printf("%s\t","vuoi continuare? (si/no)");

scanf("%s%s",&ans,&ans2);
while(ans == "si"){
printf("%s","inserisci un intero:");
scanf("%d",&a);
printf("%s","inserisci un reale:");
scanf("%f",&b);
risultato = sommac(a, b, &(taglia));
stampa(strcat(strcat(strcat(strcat(strcat(strcat(strcat("la somma di ", a), " e "), b), " incrementata di "), c), " è "), taglia));
stampa(strcat(" ed è pari a ", risultato));
printf("%s","vuoi continuare? (si/no):\t");
scanf("%s",&ans);
}
printf("%s\n","");

printf("%s","ciao");

}
