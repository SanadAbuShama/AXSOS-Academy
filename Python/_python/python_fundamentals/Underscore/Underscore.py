from subprocess import call


class Underscore:
    def map(self, iterable, callback):
        list2 = []
        for item in iterable:
            list2.append(callback(item))
        return list2
        # your code here

    def find(self, iterable, callback):
        for item in iterable:
            if callback(item):
                return item

    def filter(self, iterable, callback):
        list2 = []
        for item in iterable:
            if callback(item):
                list2.append(item)
        return list2

    def reject(self, iterable, callback):

        list2 = []
        for item in iterable:
            if not callback(item):
                list2.append(item)
        return list2


        # you just created a library with 4 methods!
        # let's create an instance of our class
_ = Underscore()  # yes we are setting our instance to a variable that is an underscore
print(_.filter([1, 2, 3, 4, 5, 6], lambda x: x % 2 == 0))
# should return [2, 4, 6] after you finish implementing the code above

print(_.map([1, 2, 3], lambda x: x**2))  # should return [2,4,6]


print(_.find([1, 2, 3, 4, 5, 6], lambda x: x > 4))
# should return the first value that is greater than 4

print(_.filter([1, 2, 3, 4, 5, 6], lambda x: x %
      2 == 0))  # should return [2,4,6]
print(_.reject([1, 2, 3, 4, 5, 6], lambda x: x %
      2 == 0))  #  should return [1,3,5]
