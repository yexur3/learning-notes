#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){
    int m[15];
    int max;

    // Инициализация генератора случайных чисел
    srand(time(0));

    // Заполняем массив случайными числами и выводим его
    for(int i = 0; i < 15; i++){
        m[i] = rand() % 100 + 1;
        printf("%d ", m[i]);  // Для наглядности выведем массив
    }
    printf("\n");

    // Ищем максимальный элемент
    max = m[0];  // Предполагаем, что первый элемент — максимальный
    for(int i = 1; i < 15; i++){
        if(m[i] > max){
            max = m[i];
        }
    }
    printf("Максимальное значение: %d\n", max);
    return 0;
}
