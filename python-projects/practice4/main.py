words = ["python", "is", "a", "really", "nice", "language"]

def longest_word(data):
    result = max(data, key=len)

    return result



print(longest_word(words))