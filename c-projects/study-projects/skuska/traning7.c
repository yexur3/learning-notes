#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Car{
    char brand[50];
    char plate[10];
    int year;
    int mileage;
};

void sortCars(struct Car cars[], int x){
    struct Car term;
    int min, i, j;
    for(i = 0; i < x; i++){
        min = i;
        for(j = i + 1; j < x; j++){
            if(strcmp(cars[min].brand, cars[j].brand) > 0){
                term = cars[min];
                cars[min] = cars[j];
                cars[j] = term;
            }
        }
    }
}

int main()
{
    int n = 0;
    int totalCars = 0;
    printf("Enter the number of cars to add: ");
    scanf("%d", &n);

    struct Car cars[300];

    for(int i = 0; i < n; i++){
        printf("Car brand: ");
        scanf("%s", cars[i].brand);

        if(strcmp(cars[i].brand, "STOP") == 0){
            break;
        }

        printf("License plate: ");
        scanf("%s", cars[i].plate);



        printf("Year: ");
        scanf("%d", &cars[i].year);
        printf("Mileage: ");
        scanf("%d", &cars[i].mileage);

        if(totalCars + 1 > 300){
            printf("Too much cars on parking!");
            break;
        }
        totalCars++;
        
        printf("\n");
    }

    sortCars(cars, totalCars);

    printf("\nCar park records: \n");
    for(int i = 0; i < totalCars; i++){
        printf("%s, %s, %d, %d km\n", cars[i].brand, cars[i].plate, cars[i].year, cars[i].mileage);
    }

    return 0;
}
