#include <stdio.h>
#include <stdlib.h>

int main()
{
    char c;
    char text[100];
    FILE *f = fopen("input.txt", "w");
    if (f == NULL) {
        printf("Error while opening file for write\n");
        return 1;
    }
    printf("Enter text: ");
    scanf("%99s", text);
    fprintf(f, "%s", text);
    fclose(f);

    FILE *fp = fopen("input.txt", "r");
    if (fp == NULL) {
        printf("Error while opening file for read\n");
        return 1;
    }
    while((c = getc(fp))!= EOF){
            printf("%c", c);
    }
    fclose(fp);
    return 0;
}
