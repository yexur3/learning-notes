#include <stdio.h>
#include <stdlib.h>

struct people{
    int id;
    char name[30];
};

int main()
{
    struct people peoples[] = {
        {1, "Kate"},
        {2, "Alexey"},
        {3, "Ivan"},
        {4, "Sasha"},
        {5, "Aboba"}
    };


    int x;
    printf("Enter the Id of people that you want to find: ");
    scanf("%d", &x);

    int found = 0;

    for(int i = 0; i < 5; i++){
        if(peoples[i].id == x){
            printf("People has founded: %d, %s", peoples[i].id, peoples[i].name);
            found = 1;
            break;
        }
    }

    if(!found){
        printf("People with ID %d not founded", x);
    }


    return 0;
}
