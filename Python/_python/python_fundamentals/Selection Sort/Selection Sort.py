

def selectionSort(arr):
    for j in range(0, len(arr)):
        for i in range(j, len(arr)):
            if arr[i] < arr[j]:
                arr[i], arr[j] = arr[j], arr[i]

    print(arr)


selectionSort([5, 3, 4, 2, 10, 9, 6, 7, 1, 8])
