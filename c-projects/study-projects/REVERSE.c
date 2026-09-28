#include <stdio.h>
#include <stdlib.h>

int main()
{
    int numbers[] = {1, 2, 3, 4, 5, 6};

    int m = sizeof(numbers)/sizeof(numbers[0]);

    int n = m / 2;


    for(int i = 0; i < n; i++){
        int temp = numbers[i];
        numbers[i] = numbers[n-i+2];
        numbers[n-i+2] = temp;
    }


    for(int i = 0; i < m; i++){
        printf("%d", numbers[i]);
    }
    return 0;
}
