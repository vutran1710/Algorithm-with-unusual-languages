def surfaceArea(A):
    W = len(A)
    H = len(A[0])
    top_bottom = 2 * (W * H)    
    sides = 0
    
    for x in A:
        sides += sum([
            abs(x[i]-x[i+1]) 
            for i in 
            range(H-1)
        ]) + x[0] + x[-1]
        
    for x in range(H):
        sides += sum([
            abs(A[i][x]-A[i+1][x]) 
            for i in 
            range(W-1)
        ]) + A[0][x] + A[-1][x]
    
    return top_bottom + sides
    
