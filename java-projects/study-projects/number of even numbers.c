#include <stdio.h>
#include <stdlib.h>

int count_even(int *x){
    int count = 0;
    for(int i = 0; i < 10; i++){
        if(x[i]%2 == 0){
            count++;
        }
    }
    return count;
}

int main()
{
    int array[] = {2, 4, 3, 7, 1, 8, 10, 6, 9, 5};
    int *p = array;

    // сохраняет результат ретурн в каунт
    int count = count_even(p);

    printf("Number of even numbers: %d\n", count);

    return 0;
}
