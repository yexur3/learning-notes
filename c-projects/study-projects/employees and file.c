#include <stdio.h>
#include <stdlib.h>

struct employee{
    int id;
    char name[50];
    float salary;
};


int main()
{
    struct employee employers[5];


    FILE *f = fopen("employees.txt", "w");
    for(int i = 0; i < 5; i++){
        printf("Enter employee %d ID: ", i + 1);
        scanf("%d", &employers[i].id);
        printf("Enter employee %d name: ", i + 1);
        scanf("%s", employers[i].name);
        printf("Enter employee %d salary: ", i + 1);
        scanf("%f", &employers[i].salary);
        printf("\n");
    }

    for(int i = 0; i < 5; i++){
        fprintf(f, "%d %s %f\n", employers[i].id, employers[i].name, employers[i].salary);
    }

    fclose(f);

    printf("Reading data from file: \n");
    f = fopen("employees.txt", "r");
    for(int i = 0; i < 5; i++){
        fscanf(f, "%d %s %f", &employers[i].id, employers[i].name, &employers[i].salary);
        printf("Employee %d: ID = %d, Name = %s, Salary = %.2f\n", i + 1, employers[i].id, employers[i].name, employers[i].salary);
    }
    fclose(f);

    f = fopen("employees.txt", "r");

    int find;
    printf("Enter the Id of person that you want to find: ");
    scanf("%d", &find);

    int found = 0;
    struct employee temp;

    while(fscanf(f, "%d %s %f", &temp.id, temp.name, &temp.salary) == 3){
        if(temp.id == find){
            printf("Employee found: Name = %s, Salary = %.2f", temp.name, temp.salary);
            found = 1;
            break;
        }
    }

    if(!found){
        printf("Employee with ID %d not founded", find);
    }

    fclose(f);

    return 0;
}
