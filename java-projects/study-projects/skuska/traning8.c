#include <stdio.h>
#include <stdlib.h>

struct city{
    char name[50];
    int population;
    float square;
};

int main()
{
    struct city cities[9];

    FILE *f = fopen("cities.txt", "r");
    for(int i = 0; i < 8; i++){
        fscanf(f, "%s %d %f\n", cities[i].name, &cities[i].population, &cities[i].square);
    }
    fclose(f);
    printf("Enter info of the new city(name, population, square):\n");
    scanf("%s %d %f", cities[8].name, &cities[8].population, &cities[8].square);
    printf("Info saved\n");
    FILE *fp = fopen("small.txt", "w");
    FILE *fx = fopen("large.txt", "w");
    FILE *fv = fopen("medium.txt", "w");
    for(int i = 0; i < 9; i++){
        if(cities[i].population > 5000){
            if(cities[i].population > 50000){
                fprintf(fx, "%s %d %.2f\n", cities[i].name, cities[i].population, cities[i].square);
            }else{
                fprintf(fv, "%s %d %.2f\n", cities[i].name, cities[i].population, cities[i].square);
            }
        }else{
            fprintf(fp, "%s %d %.2f\n", cities[i].name, cities[i].population, cities[i].square);
        }
    }
    fclose(fp);
    fclose(fx);
    fclose(fv);
    int max;
    int n = 0;
    for(int i = 0; i < 9; i++){
        if(max < cities[i].square){
            max = cities[i].square;
            n = i;
        }
        
    }
    printf("City with biggest square: %s, %d, %.2f\n", cities[n].name, cities[n].population, cities[n].square);

    char search[50];
    printf("Enter name of city for serching:");
    scanf("%s", search);
    int fr = 0;
    for(int i = 0; i < 9; i++){
        if(strcmp(cities[i].name, search) == 0){
            printf("Info about city: %s %d %.2f", cities[i].name, cities[i].population, cities[i].square);
            fr = 1;
            break;
        }
    }

    if(!fr){
        printf("City %s not found", search);
    }
    return 0;
}
