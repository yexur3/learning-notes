#include <stdio.h>
#include <stdlib.h>

struct point{
    int x;
    int y;
};

int change(int *a, int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

int main()
{
    struct point loc[] = { {3, 2}, {5, 1}, {1, 7} };
    struct point *p = loc;

    int n = sizeof(loc)/sizeof(loc[0]);


    printf("Old values:\n");

    for(int i = 0; i < n; i++){
        printf("x = %d, y = %d\n", p[i].x, p[i].y);
    }

    printf("New Values:\n");
    for(int i = 0; i < n; i++){
        change(&p[i].x, &p[i].y);
        printf("x = %d, y = %d\n", p[i].x, p[i].y);
    }


    return 0;
}
