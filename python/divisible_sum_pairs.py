def divisibleSumPairs(n, k, arr):
    count = 0
    # sorted_arr = sorted(arr)
    for idx, val in enumerate(arr):
        for i in range(idx + 1, n):
            if (val + arr[i]) % k == 0:
                count += 1
    return count


def divisibleSumPairs_Solution2(n, k, arr):
    count = 0
    ndc = []  # not_divisible_collection
    for item in arr:
        div = item % k
        if div != 0:
            ndc.append(div)
    # sort not divisible collection
    ndc = sorted(ndc)
    length = len(ndc)

    for i in range(0, length - 1):
        for j in range(length - 1, i, -1):
            if ndc[i] + ndc[j] < k:
                break
            if ndc[i] + ndc[j] == k:
                count += 1

    count_div = 0
    len_div = n - len(ndc)
    if len_div != 1:
        count_div = int(len_div * (len_div - 1) / 2)  # = C(2, len_div)
    return count + count_div
