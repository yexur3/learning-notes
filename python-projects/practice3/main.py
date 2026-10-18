data = {
    "Олена": [95, 90, 92],
    "Ігор": [70, 80, 75],
    "Анна": [55, 60, 58],
    "Максим": [100, 85, 90]
}

def analyze_scores(data):
    result = {}

    for name, scores in data.items():
        avg = sum(scores) / len(scores)

        if avg >= 90:
            result.update({name: "Відмінно"})
        elif avg >= 75:
            result.update({name: "Добре"})
        elif avg >= 60:
            result.update({name: "Задовільно"})
        elif avg < 60:
            result.update({name: "Пересдача"})
        elif avg < 0:
            print("Неправильно задані оцінки")


    return result


def clean_and_filter_words(words):
    filter = ("a", "e", "i", "o", "u", 'а', 'е', 'є', 'и', 'і', 'ї', 'о', 'у', 'ю', 'я')

    cleaned = [word.strip().lower() for word in words]
    return [word for word in cleaned if word.startswith(filter) and len(word) > 3]

print(clean_and_filter_words(["  Apple ", "cat", " elephant  ", " Dog", "Ананас ", "їжак", "Око"]))