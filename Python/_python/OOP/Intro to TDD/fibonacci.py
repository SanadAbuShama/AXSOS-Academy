
import unittest


def fib(n):
    my_list = [0, 1]
    for i in range(0, n):
        my_list.append(my_list[i]+my_list[i+1])

    return my_list[n]


class FibonnacciTests(unittest.TestCase):

    def testOne(self):
        self.assertEqual(fib(4), 3)

    def testTwo(self):
        self.assertEqual(fib(5), 5)

    def testThree(self):
        self.assertEqual(fib(6), 8)

    def testFour(self):
        self.assertEqual(fib(7), 13)

    def testFive(self):
        self.assertEqual(fib(8), 21)

    def setUp(self):
        print("running setUp")

    def tearDown(self):
        print("running tearDown tasks")


if __name__ == '__main__':
    unittest.main()
