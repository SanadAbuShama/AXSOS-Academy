import unittest


def reverseList(myList):
    for i in range(int(len(myList)/2)):
        myList[i], myList[len(myList)-1-i] = myList[len(myList)-1-i], myList[i]
    return myList


class ReverseListTests(unittest.TestCase):

    def testOne(self):
        self.assertEqual(reverseList([1, 2, 3, 4]), [4, 3, 2, 1])

    def testTwo(self):
        self.assertEqual(reverseList(['a', 'b', 'c', 'd', 'e']), [
                         'e', 'd', 'c', 'b', 'a'])

    def testThree(self):
        self.assertEqual(reverseList(['Sanad', 'Ahmad', 'Mahmoud']), [
                         'Mahmoud', 'Ahmad', 'Sanad'])

    def setUp(self):
        print("running setUp")

    def tearDown(self):
        print("running tearDown tasks")


if __name__ == '__main__':
    unittest.main()
