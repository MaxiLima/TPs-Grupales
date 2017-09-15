#include<stdio.h>
#include<stdlib.h>
#include<time.h>

// PROGRAMA PARA GENERAR LOS POLINOMIOS
// ALEATORIAMENTE, SE INGRESA EL GRADO
// SOLAMENTE

int main()
{
    //valores
    int valor, grado=2, i;
    int hora=time(NULL);
    FILE *pf;
    pf=fopen("poliGradoXXX.in","w");

    srand(hora);

    //set
    printf("grado: ");
    scanf("%d",&grado);
	if(grado<=0)
		grado=100;
	
    //grado=5;

    //genera
    fprintf(pf,"%d\n",grado);
    for(i=0;i<=grado;i++)
    {
        valor=rand();
        fprintf(pf,"%d\n",valor);
    }

    fclose(pf);
    //system("pause");

    return 0;
}
