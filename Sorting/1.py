def quicksort(arr, left, right):
    i = left
    j = right
    if i >= j:
        return
    pivot = arr[i]
    while i < j:
        while i < j and pivot <= arr[j]:
            j -= 1
        arr[i] = arr[j]
        while i < j and pivot >= arr[i]:
            i += 1
        arr[j] = arr[i]
    arr[i] = pivot
    quicksort(arr, left, j-1)
    quicksort(arr, i+1, right)

arr = [10,7,8,9,1,5,3,2]
n = len(arr)
print("Before sorted: ", arr)
quicksort(arr, 0, n-1)
print("After sorted: ", arr)
