#include <stdio.h>
#include <stdlib.h>
#include <string.h>


struct obce{
    char name[25];
    int population;
    float rozloha;
};

int main()
{
    struct obce obec[10000];

    FILE *f = fopen("obce.txt", "r");
    fclose(f);

    for(int i = 0; i < 5; i++){
        printf("Enter the name of the obec: ");
        scanf("%s", obec[i].name);
        if(strcmp(obec[i].name, "KONIEC") == 0){
            break;
        }
        printf("Enter the population: ");
        scanf("%d", &obec[i].population);
        printf("Enter the rozloha: ");
        scanf("%f", &obec[i].rozloha);
        if(obec[i].population > 1000){
            if(obec[i].population > 10000){
                FILE *f = fopen("velke.txt", "a");
                fprintf(f, "%s %d %.2f ", obec[i].name, obec[i].population, obec[i].rozloha);
                fclose(f);
            }else{
                FILE *f = fopen("stredne.txt", "a");
                fprintf(f, "%s %d %.2f ", obec[i].name, obec[i].population, obec[i].rozloha);
                fclose(f);
            }
        }else{
            FILE *f = fopen("male.txt", "a");
            fprintf(f, "%s %d %.2f ", obec[i].name, obec[i].population, obec[i].rozloha);
            fclose(f);
        }
        FILE *f = fopen("obce.txt", "a");
        fprintf(f, "%s %d %.2f\n", obec[i].name, obec[i].population, obec[i].rozloha);
        printf("\n");
    }
    fclose(f);
    return 0;
}
