def permutationEquation(p):
    arr_y = []
    for idx in range(0, len(p)):
        for k, v in enumerate(p):
            if v == idx + 1:
                for kk, vv in enumerate(p):
                    if vv == k + 1:
                        arr_y.append(kk + 1)
                        break
    return arr_y
