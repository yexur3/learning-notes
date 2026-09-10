#include <stdio.h>
#include <stdlib.h>

typedef struct {
    char * name;
    int age;
    double salary;
} employee;

int main()
{
    employee sam = {"Sam", 23, 4500};
    employee tom = {"Tom", 38, 7130};
    printf("Name: %s\n", sam.name);
    printf("Age: %d\n", sam.age);
    printf("Salary: %.2f\n", sam.salary);
    printf("Name: %s\n", tom.name);
    printf("Age: %d\n", tom.age);
    printf("Salary: %.2f", tom.salary);
    return 0;
}
