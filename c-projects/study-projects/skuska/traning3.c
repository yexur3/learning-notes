#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int m[10];
    int min;
    int max;
    int x[10];
    FILE *f = fopen("data.txt", "w");

    srand(time(0));

    for(int i = 0; i < 10; i++){
        m[i] = rand() % 100 + 1;
        fprintf(f, "%d ", m[i]);
    }

    fclose(f);

    FILE *fp = fopen("data.txt", "r");


    for(int i = 0; i < 10; i++){
        fscanf(fp, "%d ", &x[i]);

        if (i == 0) {
            min = max = x[i]; // Инициализация min и max
        } else {
            if (x[i] > max) max = x[i];
            if (x[i] < min) min = x[i];
        }
        printf("%d ", x[i]);

    }
    printf("\n");
    printf("Smallest number: %d", min);
    printf("\n");
    printf("Largest number: %d", max);

    fclose(fp);


    int sum = 0;
    for(int i = 0; i < 10; i++){
       sum = sum + x[i];
    }

    float avg = (float)sum / 10;

    printf("\n%.2f", avg);

    FILE *fx = fopen("results.txt", "w");
    fprintf(fx, "Numbers: ");
    for(int i = 0; i < 10; i++){
        fprintf(fx, "%d ", x[i]);
    }
    fprintf(fx, "\nSmallest number: %d", min);
    fprintf(fx, "\nHighest number: %d", max);
    fprintf(fx, "\nAvarage: %.2f", avg);

    fclose(fx);

    return 0;
}
