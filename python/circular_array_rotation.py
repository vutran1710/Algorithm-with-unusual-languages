def calculate_index(arr, q, k):
    return (q - k) % len(arr)


def circularArrayRotation(a, k, queries):
    return [a[calculate_index(a, q, k)] for q in queries]
