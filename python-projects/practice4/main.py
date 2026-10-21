words = ["python", "is", "a", "really", "nice", "language"]

def longest_word(data):
    result = max(data, key=len)

    return result

def sorted_words(data):
    result = sorted(data)

    return result


print(longest_word(words))
print(sorted_words(words))