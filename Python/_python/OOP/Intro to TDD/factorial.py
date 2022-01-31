

import unittest


def factorial(num):
    fact = 1
    for i in range(num, 0, -1):
        fact = fact * i
    return fact


class FactorialTests(unittest.TestCase):

    def testOne(self):
        self.assertEqual(factorial(2), 2)

    def testTwo(self):
        self.assertEqual(factorial(4), 24)

    def testThree(self):
        self.assertEqual(factorial(5), 120)

    def testFour(self):
        self.assertEqual(factorial(6), 720)

    def testFive(self):
        self.assertEqual(factorial(3), 6)

    def setUp(self):
        print("running setUp")

    def tearDown(self):
        print("running tearDown tasks")


if __name__ == '__main__':
    unittest.main()
