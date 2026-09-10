#include <stdio.h>
#include <stdlib.h>



int main()
{
    int array[] = {2, 1, 54, 23, 8, 3};

    int *p = {&array[0], &array[1], &array[2], &array[3], &array[4], &array[5]};

    for(int i = 0; i < 6; i++){
        printf("%d ", p[i]);
    }
    return 0;
}
