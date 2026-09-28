#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int m[15];
    int max, min;
    int max_index = 0, min_index = 0;

    srand(time(0));

    for(int i = 0; i < 15; i++){
        m[i] = 10 + rand() % 100 + 1;
        printf("%d ", m[i]);
    }
    printf("\n");

    max = m[0];
    for(int i = 1; i < 15; i++){
        if(m[i] > max){
            max = m[i];
            max_index = i;
        }
    }
    min = m[0];
    for (int i = 1; i < 15; i++){
        if(m[i] < min){
            min = m[i];
            min_index = i;
        }
    }

    printf("Max number and index: %d, %d, min number and index: %d, %d", max, max_index, min, min_index);

    return 0;
}
