def saveThePrisoner(n, m, s):
    last = s + m - 1
    return last - math.ceil(last / n - 1) * n