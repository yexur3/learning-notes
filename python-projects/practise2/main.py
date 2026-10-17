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
    result = enumerate(fruits, 1)

    print(list(result))

practice_with_enumerated()