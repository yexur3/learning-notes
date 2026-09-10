#include <stdio.h>
#include <stdlib.h>

struct Product{
    char name[30];
    float price;
    int quantity;
};

float calculate(struct Product *products, int n){
    float sum = 0;
    for(int i = 0; i < n; i++){
        sum += products[i].price * products[i].quantity;
    }
    return sum;
}

int main()
{
    struct Product products[3];
    struct Product *p = &products;

    for(int i = 0; i < 3; i++){
        printf("Enter product %d: \n", i + 1);
        printf("Name: ");
        scanf("%s", p[i].name);

        printf("Price: ");
        scanf("%f", &p[i].price);

        printf("Quantity: ");
        scanf("%d", &p[i].quantity);
        printf("\n");
    }

    printf("Products: \n");
    for(int  i = 0; i < 3; i++){
        printf("%d. %s, Price: %.2f, Count: %d", i + 1, p[i].name, p[i].price, p[i].quantity);
        printf("\n");
    }


    float x = calculate(p, 3);


    printf("Total cost: %.2f", x);

    return 0;
}
