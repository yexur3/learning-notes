#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x = 0;
    int array[] = {4, 2, 6, 3, 1};

    int *p = array;

    for(int i = 0; i < 5; i++){
        x = x + *(p + i);
    }
    printf("Value: %d", x);
    return 0;
}
