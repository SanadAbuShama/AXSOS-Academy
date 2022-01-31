import unittest


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


class IsPalindromeTests(unittest.TestCase):

    def testAdd(self):
        self.assertEqual(self.md.add(2).add(2, 5, 1).add(
            5, 6, 2, 3).result, 26)

    def testSubstract(self):
        self.assertEqual(self.md.subtract(
            3, 2).subtract(1, 2, 3).subtract(2, 3).result, -16)

    def setUp(self):
        print("running setUp")
        self.md = MathDojo()

    def tearDown(self):
        print("running tearDown tasks")


if __name__ == '__main__':
    unittest.main()
