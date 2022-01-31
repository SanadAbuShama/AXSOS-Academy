import unittest


def coins(cents):
    quarters = int(cents/25)
    dimes = int((cents % 25)/10)
    nickels = int((cents % 25 % 10)/5)
    pennies = int(cents % 25 % 10 % 5)
    return [quarters, dimes, nickels, pennies]


print(coins(4))


class CoinsTests(unittest.TestCase):

    def testOne(self):
        self.assertEqual(coins(87), [3, 1, 0, 2])

    def testTwo(self):
        self.assertEqual(coins(82), [3, 0, 1, 2])

    def testThree(self):
        self.assertEqual(coins(76), [3, 0, 0, 1])

    def testFour(self):
        self.assertEqual(coins(25), [1, 0, 0, 0])

    def testFive(self):
        self.assertEqual(coins(52), [2, 0, 0, 2])

    def setUp(self):
        print("running setUp")

    def tearDown(self):
        print("running tearDown tasks")


if __name__ == '__main__':
    unittest.main()
