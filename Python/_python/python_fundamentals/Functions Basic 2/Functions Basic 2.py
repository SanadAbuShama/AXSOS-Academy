# Countdown

def countdown(num):
    countList = []
    for val in range(num, -1, -1):
        countList.append(val)
    return countList


# Print and Return

def print_and_return(nums):
    print(nums[0])
    return nums[1]


# First Plus Length


def first_plus_length(numList):
    return numList[0] + len(numList)


# Values Greater than Second

def values_greater_than_second(nums):
    newList = []
    if len(nums) >= 2:
        for i in nums:
            if i > nums[1]:
                newList.append(i)
        print(len(newList))
        return newList
    else:
        return False


# This Length, That Value

def length_and_value(size, value):
    newList = []
    for i in range(0, size):
        newList.append(value)

    return newList
