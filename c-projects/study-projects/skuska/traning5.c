#include <stdio.h>
#include <stdlib.h>

struct Student {
    char name[50];
    int grade;
};

int main()
{
    struct Student students[10];
    struct Student *p = &students;

    for(int i = 0; i < 10; i++){
        printf("Enter name of student: ");
        scanf("%s", students[i].name);
        printf("Enter grade of student: ");
        scanf("%d", &students[i].grade);
        printf("\n");
    }

    FILE *f = fopen("students.txt", "w");
    for(int i = 0; i < 10; i++){
        fprintf(f, "Name: %s, Grade: %d\n", students[i].name, students[i].grade);
    }
    fclose(f);

    int n = 0;
    for(int i = 0; i < 10; i++){
        n = n + students[i].grade;
    }
    float m = n / 10;
    printf("\nAvarage grade: %.2f", m);

    FILE *fp = fopen("high_scores.txt", "w");
    for(int i = 0; i < 10; i++){
        if(m < p[i].grade){
            fprintf(fp, "Name: %s, Grade: %d\n", p[i].name, p[i].grade);
        }
    }

    return 0;
}
