#include <stdio.h>
#include <stdlib.h>

struct hracka{
    char nazov[20];
    float cena;
    char povod[3];
    int pocet;
};

void Sort(struct hracka toy[], int _x){
    struct hracka temp;
    for(int i = 0; i < _x; i++){
        for(int j = i + 1; j < _x; j++){
            if(strcmp(toy[i].nazov, toy[j].nazov) > 0){
                temp = toy[i];
                toy[i] = toy[j];
                toy[j] = temp;
            }
        }
    }
}

int main()
{
    struct hracka hracky[500];
    int n = 0;
    printf("n = ");
    scanf("%d", &n);
    int numberToys = 0;
    struct hracka Toys[500];
    for(int i = 0; i < n; i++){

        printf("nazov: ");
        scanf("%s", Toys[i].nazov);

        if(strcmp(Toys[i].nazov, "KONIEC") == 0){
            break;
        }

        printf("cena: ");
        scanf("%f", &Toys[i].cena);
        printf("povod: ");
        scanf("%s", Toys[i].povod);
        printf("kusy: ");
        scanf("%d", &Toys[i].pocet);

        if(numberToys + 1 > 500){
            printf("Too many toys!");
            break;
        }

        printf("\n");

        int found = 0;
        for(int j = 0; j < numberToys; j++){
            if(strcmp(Toys[i].nazov, hracky[j].nazov) == 0){
                found = 1;
                if((hracky[j].pocet + Toys[i].pocet) > 10000){
                    printf("Too many toys!!");
                    return 1;
                }else{
                    hracky[j].pocet = hracky[j].pocet + Toys[i].pocet;
                }
                break;
            }
        }
        if(!found){
            hracky[numberToys] = Toys[i];
            numberToys++;
        }
    }

    Sort(hracky, numberToys);

    for(int k = 0; k < numberToys; k++){
        printf("%s %.2f EUR %s %d ks\n", hracky[k].nazov, hracky[k].cena, hracky[k].povod, hracky[k].pocet);
    }
    return 0;
}
