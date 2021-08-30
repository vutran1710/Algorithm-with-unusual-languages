def migratoryBirds(arr):
    collections = {}
    
    for i in arr:
        if i in collections:
            collections[i] += 1
        else:
            collections.update({i: 1})

    minn = None
    maxx = None
    for k, v in collections.items():
        if maxx is None:
            minn = k
            maxx = v
            continue

        if maxx < v or maxx == v and minn > k:
            minn = k
            maxx = v
        
    return minn
