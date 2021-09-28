mymap = {}

def run(num, arr, i, cnt):
    m = math.floor(num / arr[i])
    
    for x in range(0, m+1):
        rem = num - (arr[i] * x)
        
        if rem == 0:
            return cnt + 1
        
        if i == len(arr) - 1:
            continue
        
        key = f"{rem}-{i+1}"

        if key not in mymap:
            n = run(rem, arr, i+1, 0)
            mymap.update({key: n})

        cnt += mymap[key]

    return cnt

def getWays(n, c):
    c = sorted(c, reverse=True)
    return run(n, c, 0, 0)
