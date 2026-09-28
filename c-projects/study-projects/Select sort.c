#include <stdio.h>
#include <stdlib.h>

void output(int x[], int _x){
    for(int i = 0; i < _x; i++){
        printf("%d ", x[i]);
    }
}

void Change(int *a, int *b){
    int term = *a;
    *a = *b;
    *b = term;
}

void SelectSort(int x[], int _x){
    int i, j, min;
    for(i = 0; i < _x; i++){
        min = i;
        for(j = i + 1; j < _x; j++){
            if(x[min] > x[j]){
                min = j;
            }
        }
        Change(&x[min], &x[i]);
    }
}

int main()
{
    int numbers[] = {1, 2, 6, 9, 4, 5, 8, 7};
    int size = 8;

    SelectSort(numbers, size);

    output(numbers, size);

    return 0;
}
