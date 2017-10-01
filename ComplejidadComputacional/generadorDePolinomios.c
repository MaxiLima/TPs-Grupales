#include<stdio.h>
#include<stdlib.h>
#include<time.h>

// PROGRAMA PARA GENERAR LOS POLINOMIOS
// ALEATORIAMENTE, SE INGRESA EL GRADO
// SOLAMENTE

int main()
{
    //valores
    int valor, grado=1, i;
    int hora=time(NULL);
    FILE *pf;
    pf=fopen("poliGradoXXX.in","w");

    srand(hora);

    //set
    printf("grado: ");
    scanf("%d",&grado);
	if(grado<=0)
		grado=100;

    //escribe el grado N al inicio del .IN
    fprintf(pf,"%d\n",grado);
    //copia los N valores siguientes
    for(i=0;i<=grado;i++)
    {
        valor=rand();
        fprintf(pf,"%d\n",valor);
    }

    fclose(pf);
    //system("pause");

    return 0;
}
