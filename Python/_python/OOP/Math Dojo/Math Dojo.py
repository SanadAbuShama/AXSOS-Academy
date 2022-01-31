class MathDojo:
    def __init__(self):
        self.result = 0

    def add(self, num, *nums):
        self.result += num
        for a in nums:
            self.result += a
        return self

    def subtract(self, num, *nums):
        self.result -= num
        for a in nums:
            self.result -= a
        return self


md = MathDojo()

x = md.add(2).add(2, 5, 1).add(
    5, 6, 2, 3).subtract(3, 2).subtract(1, 2, 3).subtract(2, 3).result
print(x)
