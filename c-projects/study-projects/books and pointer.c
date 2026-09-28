#include <stdio.h>
#include <stdlib.h>

struct book{
    char title[50];
    char author[50];
    int year;
};

int main()
{
    struct book books[10];
    struct book *p = &books;

    printf("Enter name of the book: ");
    scanf("%s", p->title);

    printf("\n");

    printf("Enter author of the book: ");
    scanf("%s", p->author);

    printf("\n");

    printf("Enter year of publication: ");
    scanf("%d", &p->year);

    printf("Title: %s\n",  p->title);
    printf("Author: %s\n",  p->author);
    printf("Year of publication: %d",  p->year);
    return 0;
}
