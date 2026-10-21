words = ["python", "is", "a", "really", "nice", "language"]

def longest_word(data):
    result = max(data, key=len)

    return result

def sorted_words(data):
    result = sorted(data, key = len)

    return result

def average_word_length(data):
    sum_of_characters = 0
    for word in data:
        sum_of_characters += len(word)

    return sum_of_characters / len(data)

print(longest_word(words))
print(sorted_words(words))
print(average_word_length(words))