#include <stdio.h>
#include <stdlib.h>
#define ML (Atom*)malloc(sizeof(Atom))

typedef struct {
    char text[256];
} Task;

typedef struct atom {
    Task h;
    struct atom *nasl, *pred;
} Atom;

Atom *head = NULL;

void ini(Atom **z){
    *z = NULL;
}

int test(Atom *z){
    return z == NULL;
}

void vloz(Atom **z, Task x){
    if(test(*z)){
        *z = ML;
        (*z)->nasl = *z;
        (*z)->pred = *z;
        (*z)->h = x;

    } else {
        Atom *pom = ML;
        pom->h = x;
        pom->nasl = (*z)->nasl;
        pom->pred = *z;
        pom->nasl->pred = pom;
        (*z)->nasl = pom;
        *z = pom;
    }
}

void add_task(Atom **z){
    Task h;
    printf("Write task (empty line to stop):\n");
    while (fgets(h.text, sizeof h.text, stdin)){
        if (h.text[0]=='\n') break;
        h.text[strcspn(h.text, "\n")] = '\0';
        vloz(z, h);
    }
}

void load_tasks(Atom **z){
    FILE *fp = fopen("tasks.txt", "r");
    if (!fp) return;
    Task h;
    while (fgets(h.text, sizeof h.text, fp)){
        h.text[strcspn(h.text, "\n")] = '\0';
        vloz(z, h);
    }
    fclose(fp);
}


void show_list(Atom *z){
    if (test(z)){
        printf("List is empty\n");
        return;
    }
    Atom *p = z;
    int i = 1;
    putchar('\n');
    do {
        printf("%d) %s\n", i++, p->h.text);
        p = p->nasl;
    } while (p != z);
    putchar('\n');
}

void save_tasks(Atom *z){
    FILE *f = fopen("tasks.txt", "w");
    if (!f) return;
    if (!test(z)){
        Atom *p = z;
        do {
            fprintf(f, "%s\n", p->h.text);
            p = p->nasl;
        } while (p != z);
    }
    fclose(f);
}

void delete_task(Atom **head, int ind){
    if(*head == NULL) return;

    Atom *pom = *head;
    for(int i = 1; i < ind; i++){
        pom = pom->nasl;
        if(pom == *head){
            printf("There aren't that many tasks\n");
            return;
        }
    }
    if(pom == *head){
        free((void*)pom);
        *head = NULL;
    } else {
        pom->nasl->pred = pom->pred;
        pom->pred->nasl = pom->nasl;
        free((void*)pom);
    }
}

int main()
{
    ini(&head);
    load_tasks(&head);
    int choice;
    while(1){
        printf("1.Add task\n2. Show list\n3. Delete\n4. Exit\nMake choice: ");
        scanf("%d", &choice);
        getchar();

        if(choice == 1){
            add_task(&head);
        } else if (choice == 2){
            show_list(head);
        } else if (choice == 3){
            int ind;
            printf("Enter number that you want to delete: ");
            scanf("%d", &ind);
            delete_task(&head, ind);
        } else if (choice == 4){
            save_tasks(head);
            break;
        } else {
            printf("Wrong choice\n");
        }
    }
    return 0;
}
