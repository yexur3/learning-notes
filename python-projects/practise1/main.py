def percentage_calculation():
    start_suma = input("Initial deposit amount: ")
    percent = input("Percentage: ")
    years = input("Amount of years: ")

    result = (float(start_suma) * float(percent) * float(years)) / 100

    print(f"Accrued Interest: {result}")

def from_celsius_to_fahrenheit():
    celsius = float(input("Enter temperature in Celsius: "))

    f = (9/5) * celsius + 32

    print(f"{celsius} degrees in Celsius equals to {f} in Fahrenheit")

from_celsius_to_fahrenheit()
