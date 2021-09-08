def search(queen, bounds, obs_set, direction=[0, 0]):
    x0, y0, x1, y1 = bounds
    
    x, y = queen["x"] + direction[0], queen["y"] + direction[1]
    
    count = 0
    
    while x0 <= x <= x1 and y0 <= y <= y1 and f"{x}_{y}" not in obs_set:
        count += 1
        x += direction[0]
        y += direction[1]

    return count
    
def queensAttack(n, k, r_q, c_q, obstacles):
    obs_set = {f"{o[0]}_{o[1]}" for o in obstacles}    
    queen = { "x": r_q, "y": c_q }
    bounds = [1, 1, n, n]
    direction = range(-1, 2)
    count = 0

    for x in direction:
        for y in direction:
            if x == y == 0:
                continue
            
            count += search(queen, bounds, obs_set, [x, y])

    return count
