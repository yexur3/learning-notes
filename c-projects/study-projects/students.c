#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Student {
    char name[20];
    int age;
    char id[10];
};

int main()
{
    int x;
    int c;

    printf("Enter amount of student: ");
    scanf("%d", &x);

    struct Student *students = (struct Student *)malloc(x * sizeof(struct Student));
    if (students == NULL) {
        printf("Memory allocation failed.\n");
        return 1;
    }

    printf("Enter the names, ages and id of students:\n");
    for(int i = 0; i < x; i++){
        scanf("%s %d %s", students[i].name, &students[i].age, students[i].id);
    }

    printf("Choose how you want to search a student: 1. By name. 2. By ID\n");

    do{
        fflush(stdin);
        c = getch();
    } while(c != '1' && c != '2');
    if(c == '1'){
        char find[20];
        printf("Enter the name of student, that you wanna find: ");
        scanf("%19s", find);

        int found = 0;

        for (int i = 0; i < x; i++){
            if(strcmp(students[i].name, find) == 0){
                printf("Student has founded: %s %d %s", students[i].name, students[i].age, students[i].id);
                found = 1;
                break;
            }
        }

        if(!found){
            printf("Student %s not founded", find);
        }
    } else {
        char f[10];
        printf("Enter the ID of student, that you want to search: ");
        scanf("%9s", f);

        int fo = 0;

        for(int i = 0; i < x; i++){
            if(strcmp(students[i].id, f) == 0){
                printf("Student has founded: %s %d %s", students[i].name, students[i].age, students[i].id);
                fo = 1;
                break;
            }
        }
        if(!fo){
            printf("Student with ID %s not founded", f);
        }
    }

    return 0;
}
