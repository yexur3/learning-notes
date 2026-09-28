#include <stdio.h>
#include <stdlib.h>

struct Book {
    char title[100];
    char author[50];
    int year;
};

int main()
{
    struct Book books[5];
    struct Book *p = &books;

    FILE *f = fopen("books.txt", "w");

    for(int i = 0; i < 5; i++){
        printf("Enter title of a book: ");
        scanf("%s", books[i].title);
        printf("Enter author of the book: ");
        scanf("%s", books[i].author);
        printf("Enter year of book: ");
        scanf("%d", &books[i].year);
        printf("\n");
    }

    for(int i = 0; i < 5; i++){
        fprintf(f, "Title: %s, Author: %s, Year: %d\n", books[i].title, books[i].author, books[i].year);
    }
    fclose(f);

    int min = p->year;


    for(int i = 0; i < 5; i++){
        if(min > p[i].year){
            min = p[i].year;
        }
    }
    printf("\n");
    printf("%d", min);


    return 0;
}
