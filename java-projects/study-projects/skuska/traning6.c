#include <stdio.h>
#include <stdlib.h>

struct Employee {
    char name[50];
    int age;
    float salary;
};

int main()
{
    struct Employee employees[5];
    struct Employee *p = &employees;


    for(int i = 0; i < 5; i++){
        printf("Enter name of employee: ");
        scanf("%s", employees[i].name);
        printf("Enter age of employee: ");
        scanf("%d", &employees[i].age);
        printf("Enter salary of employee: ");
        scanf("%f", &employees[i].salary);
        printf("\n");
    }

    FILE *f = fopen("employees.txt", "w");
    for(int i = 0; i < 5; i++){
        fprintf(f, "Name: %s, Age: %d, Salary: %.2f\n", employees[i].name, employees[i].age, employees[i].salary);
    }
    fclose(f);

    float max = 0;
    int index = 0;
    for(int i = 0; i < 5; i++){
        if(max < p[i].salary){
            max = p[i].salary;
            index = i;
        }
    }
    printf("Employee with highest amount of salary: Name: %s, Age: %d, Salary: %.2f", p[index].name, p[index].age, p[index].salary);
    return 0;
}
