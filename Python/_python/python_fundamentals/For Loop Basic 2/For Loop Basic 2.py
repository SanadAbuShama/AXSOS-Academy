# Bigger Size

def biggie_size(numList):
    for i in range(0, len(numList)):
        if numList[i] > 0:
            numList[i] = 'big'
    return numList


# Count Positives

def count_positives(numList):
    positiveCount = 0
    for val in numList:
        if val > 0:
            positiveCount += 1
    numList[len(numList)-1] = positiveCount
    return numList


# Sum Total

def sum_total(numList):
    sum = 0
    for val in numList:
        sum += val
    return sum


# Average

def average(numList):
    sum = 0
    for val in numList:
        sum += val
    return sum/len(numList)


# Length

def length(someList):
    count = 0
    for val in someList:
        count += 1
    return count


# Minimum

def minimum(numList):
    if len(numList) != 0:
        minimum = numList[0]
        for val in numList:
            if val < minimum:
                minimum = val
        return minimum
    else:
        return False


# Maximum

def maximum(numList):
    if len(numList) != 0:
        maximum = numList[0]
        for val in numList:
            if val > maximum:
                maximum = val
        return maximum
    else:
        return False


# ultimate Analysis

def ultimate_analysis(numsList):
    return {
        "sumTotal": sum_total(numsList),
        "average": average(numsList),
        "minimum": minimum(numsList),
        "maximum": maximum(numsList),
        "length": length(numsList)}


# Reverse List

def reverse_list(numsList):
    L = len(numsList)
    for i in range(0, int(L/2)):
        n = numsList[L-1-i]
        numsList[L-1-i] = numsList[i]
        numsList[i] = n
    return numsList
