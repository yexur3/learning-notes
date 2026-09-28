#include <stdio.h>
#include <stdlib.h>

int multiple_by_two(int *x){
    for(int i = 0; i < 6; i++){
        x[i] = x[i] * 2;
    }
}

int main()
{
    int array[] = {1, 4, 6, 3, 8, 5};
    int *p = array;

    for(int i = 0; i < 6; i++){
        printf("%d ", *(p + i));
    }
    printf("\n");
    multiple_by_two(p);

    for(int i = 0; i < 6; i++){
        printf("%d ", *(p + i));
    }
    return 0;
}
