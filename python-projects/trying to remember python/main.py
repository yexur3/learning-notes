from datetime import date

def first_program():
    print("what is your name?")
    name = input()

    print("year of birth?")
    year = int(input())

    age = date.today().year - year

    print("Hello:", name, "! You have around", age, "years")


def second_program():

    for i in range(50):
        if i % 3 == 0 and i % 5 != 0:
            print(i)



second_program()

