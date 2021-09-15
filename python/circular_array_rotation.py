def circularArrayRotation(a, k, queries):
    len_a = len(a)
    if k > len(a):
        k = k % len_a
        
    first = a[len_a - k:]
    last = a[:len_a - k]
    join = first + last
    
    q = []
    for i in queries:
        q.append(join[i])

    return q