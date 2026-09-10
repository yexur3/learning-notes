#include <stdio.h>
#include <stdlib.h>

int main()
{
    char x[] = {"Hello, file operations in C!"};

    char c;

    int n = sizeof(x)/sizeof(x[0]);

    FILE *f = fopen("output.txt", "w");
    if (f){
        for(int i = 0; i < n; i++){
            putc(x[i], f);
        }
    }


    fclose(f);

    f = fopen("output.txt", "r");

    while((c = getc(f)) != EOF){
        printf("%c", c);
    }
    fclose(f);

    return 0;
}
