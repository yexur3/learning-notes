#include <stdio.h>
#include <stdlib.h>

struct student{
    char name[20];
    int age;
    float grade;
};

int main()
{
    struct student peoples[] = { {"Tom", 21, 3.2}, {"Bob", 22, 5.0}, {"Anton", 20, 3.9}, {"Illia", 22, 4.1} };

    int n = sizeof(peoples)/sizeof(peoples[0]);

    for(int i = 0; i < n; i++){
        if(peoples[i].grade > 4.0){
            printf("Name: %s, Age: %d, Grade: %.1f\n", peoples[i].name, peoples[i].age, peoples[i].grade);

        }
    }
    return 0;
}
