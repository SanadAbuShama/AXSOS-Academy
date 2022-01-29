
# Print all integers from 0 tp 150

for i in range(0, 151):
    print(i)

# Multiples of five

for val in range(5, 1001, 5):
    print(val)

# Counting, the Dojo Way

for num in range(1, 101):
    if num % 10 == 0:
        print('Coding Dojo')
    elif num % 5 == 0:
        print('Coding')
    else:
        print(num)

# Whoa. That Sucker's Huge
sum = 0
for number in range(0, 500001):
    if(number % 2 != 0):
        sum += number
print(sum)


# Countdown by Fours

j = 2018
while j >= 0:
    print(j)
    j -= 4


# Flexible Counter

lowNum = 2
highNum = 9
mult = 3
for k in range(lowNum, highNum + 1):
    if k % mult == 0:
        print(k)
