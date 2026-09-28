#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int m[10];
    int sum = 0;
    float avarage = 0;

    srand(time(0));

    size_t count = sizeof(m)/sizeof(int);

    for(int i = 0; i < count; i++){
        m[i] = rand() % 50 + 1;
        printf("%d ", m[i]);
    }
    printf("\n");


    for(int i = 0; i < count; i++){
        sum += m[i];
    }

    avarage = (float)sum / count;
    printf("%.2f\n", avarage);
    return 0;
}
