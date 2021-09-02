def pickingNumbers(a):
    arr = sorted(a)
    collections = {}

    for i in arr:
        if i in collections:
            collections[i] += 1
        else:
            collections.update({i: 1})

    values = [v for _, v in collections.items()]
    max_values = max(values)

    # edge case
    if len(values) == 1:
        return values[0]

    prev_key = None
    maxx = 0

    for k in collections.keys():
        if prev_key is None:
            prev_key = k
            continue

        if k - prev_key > 1:
            prev_key = k
            continue

        if k - prev_key <= 1:
            current = collections[prev_key] + collections[k]
            maxx = max(maxx, current)

        prev_key = k

    return max(maxx, max_values)
