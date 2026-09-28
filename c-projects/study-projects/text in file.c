#include <stdio.h>
#include <stdlib.h>

int main()
{
    char text[100];
    FILE *f = fopen("output.txt", "w");
    if(f == NULL){
        printf("Error while opening file\n");
        return 1;
    }

    // запрашиваем у пользователя текст
    printf("Enter text: ");
    scanf("%99s", text); // считываем текст

    fprintf(f, "%s\n", text);
    fclose(f);
    return 0;
}
