# 1 Update Values in Dictionaries and Lists

x = [[5, 2, 3], [10, 8, 9]]
students = [
    {'first_name':  'Michael', 'last_name': 'Jordan'},
    {'first_name': 'John', 'last_name': 'Rosales'}
]
sports_directory = {
    'basketball': ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer': ['Messi', 'Ronaldo', 'Rooney']
}
z = [{'x': 10, 'y': 20}]

# 1

x[1][0] = 15

# 2

students[0]['last_name'] = 'Bryant'

# 3

sports_directory['soccer'][0] = 'Andres'

# 4

z[0]['y'] = 30


# 2 Iterate Through a List of Dictionaries


students = [
    {'first_name':  'Michael', 'last_name': 'Jordan'},
    {'first_name': 'John', 'last_name': 'Rosales'},
    {'first_name': 'Mark', 'last_name': 'Guillen'},
    {'first_name': 'KB', 'last_name': 'Tonel'}
]


def iterateDictionary(list1):
    for val in list1:
        # new_list used to get them to appear as below(Bonus)
        new_list = []
        for key, value in val.items():
            new_list.append(key)
            new_list.append(value)
        print(f"{new_list[0] } - {new_list[1]}, {new_list[2]} - {new_list[3]}")


# iterateDictionary(students)
# should output: (it's okay if each key-value pair ends up on 2 separate lines;
# bonus to get them to appear exactly as below!)
""" first_name - Michael, last_name - Jordan
first_name - John, last_name - Rosales
first_name - Mark, last_name - Guillen
first_name - KB, last_name - Tonel """


# 3  Get Values From a List of Dictionaries


def iterateDictionary2(key_name, list1):
    for val in list1:
        print(val[key_name])


# iterateDictionary2('first_name', students)


# 4 Iterate Through a Dictionary with List Values

dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}


def printInfo(dict1):

    for key, value in dict1.items():
        print('\n')
        print(len(value), key)
        for val in value:
            print(val)


# printInfo(dojo)
