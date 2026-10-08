from datetime import date

def first_program():
    print("what is your name?")
    name = input()

    print("year of birth?")
    year = int(input())

    age = date.today().year - year

    print("Hello:", name, "! You have around", age, "years")

def second_program():

    for i in range(1, 51):
        if i % 3 == 0 and i % 5 != 0:
            print(i)

def third_program():
    nums = [4, 8, 15, 16, 23, 42]

    newList = [num ** 2 for num in nums if num % 2 == 0]

    return newList

def fourth_program(text):
    dict = {}
    for word in text.split():
        if word not in dict:
            dict[word] = 1
        else:
            dict[word] += 1

    return dict


def is_palindrome(s):
    string = s.lower().replace(" ", "")
    reversedString = string[::-1]
    return reversedString == string

print(fourth_program("Hello world"))
print(is_palindrome("print world"))

