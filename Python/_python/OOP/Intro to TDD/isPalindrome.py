import unittest


def isPalindrome(str):
    right = 0
    for i in range(int(len(str)/2)):
        right = len(str) - 1 - i
        if (str[i] != str[right]):
            return False

    return True


class IsPalindromeTests(unittest.TestCase):

    def testOne(self):
        self.assertTrue(isPalindrome('racecar'))

    def testTwo(self):
        self.assertFalse(isPalindrome('sanad'))

    def testThree(self):
        self.assertFalse(isPalindrome('geeks'))

    def testFour(self):
        self.assertTrue(isPalindrome('madam'))

    def testFive(self):
        self.assertTrue(isPalindrome('radar'))

    def setUp(self):
        print("running setUp")

    def tearDown(self):
        print("running tearDown tasks")


if __name__ == '__main__':
    unittest.main()
