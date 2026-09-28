#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x = 9;
    int *p = &x;
    printf("Old Value: %d\n", *p);

    *p = 24;
    printf("New Value: %d\n", *p);

    return 0;
}
