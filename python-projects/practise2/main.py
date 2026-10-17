def practice_with_tuple():
    point = (2, 7)

    x, y = point

    print(x + y)

def practice_with_arrays():
    names = ["anna", "ivan", "anna", "olga", "ivan", "petro"]

    only_unique_names = set(names)

    # for name in names:
    #     only_unique_names.add(name)

    print(only_unique_names)

def practice_with_sets():
    a = {1, 2, 3, 4}
    b = {3, 4, 5, 6}

    print(a & b)
    print(a | b)
    print(a - b)

def practice_with_enumerated():
    fruits = ["apple", "banana", "cherry"]

    for number, fruit in enumerate(fruits, start=1):
        print(f"{number}: {fruit}")

def practice_with_zip():
    students = ["Anna", "Ivan", "Olga"]
    grades = [90, 75, 82]

    for name, grade in zip(students, grades):
        print(f"{name}: {grade}")

    y = dict(zip(students, grades))

    print(max(y, key=y.get))

practice_with_zip()