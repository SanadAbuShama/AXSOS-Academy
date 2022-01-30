

def insertionSort(arr):
    for i in range(1, len(arr)):
        counter = 0
        for j in range(i-1, -1, -1):
            if arr[i-counter] < arr[j]:
                arr[i-counter], arr[j] = arr[j], arr[i-counter]
                counter += 1

    print(arr)


insertionSort([25, 78, 45, 76, 25, 76, 98, 43, 29, 54])
