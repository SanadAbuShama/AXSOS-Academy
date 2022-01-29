import random


def randInt(min=0, max=100):
    if(max >= 0 and max >= min):
        while True:
            num = round(random.random() * max)
            if(num >= min):
                return num
    else:
        return('Wrong Input')


print(randInt(20, 50))
