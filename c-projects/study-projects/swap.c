#include <stdio.h>
#include <stdlib.h>

void swap(int *q, int *r){
    int time;
    time = *q;
    *q = *r;
    *r = time;
}

int main()
{
    int x =  10;
    int y = 63;

    int *p = &x;
    int *f = &y;

    printf("Values before swap: x = %d, y = %d\n", *p, *f);

    swap(p, f);

    printf("Values after swap: x = %d, y = %d\n", *p, *f);

    return 0;
}
