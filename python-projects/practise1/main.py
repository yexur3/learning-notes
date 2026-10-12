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

def if_leap_year():
    year = int(input("Enter a year: "))
    if year % 100 == 0:
        if year % 100 == 0 and year % 400 == 0:
            print("This year not leap")
        else:
            print("This year is not leap")
    elif year % 4 == 0:
        print("This year is leap")
    else:
        print("This year is not leap")

if_leap_year()