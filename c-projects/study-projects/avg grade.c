#include <stdio.h>
#include <stdlib.h>

struct student{
    char name[20];
    float grade;
};

float calc(struct student a[], int n){
    float b = 0;
    for(int i = 0; i < n; i++){
        b += a[i].grade;
    }
    return b / n;
}

int main()
{
    struct student s[] = { {"Kate", 4.0}, {"Bob", 2.1}, {"Alex", 3.8} };
    int n = sizeof(s)/sizeof(s[0]);

    float t = calc(s, n);

    printf("Avarage grade: %.1f", t);
    return 0;
}
