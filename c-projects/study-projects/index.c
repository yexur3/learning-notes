#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x = 9;
    int *p = &x;
    printf("Address: %p, Value: %d", (void *)p, *p);
    return 0;
}
