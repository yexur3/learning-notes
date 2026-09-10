#include <stdio.h>
#include <stdlib.h>

int main()
{
    int numbers[20];
    FILE *f = fopen("input.txt", "r");

    for(int i = 0; i < 10; i++){
        fscanf(f, "%d ", &numbers[i]);
    }

    fclose(f);

    int sum = 0;

    for(int i = 0; i < 10; i++){
        sum = sum + numbers[i];
    }

    FILE *fp = fopen("output.txt", "w");

    for(int i = 0; i < 10; i++){
        fprintf(fp, "%d ", numbers[i]);

    }

    fprintf(fp, "Sum: %d", sum);

    fclose(fp);

    return 0;
}
