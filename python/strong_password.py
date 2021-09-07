numbers = "0123456789"
lower_case = "abcdefghijklmnopqrstuvwxyz"
upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
special_characters = "!@#$%^&*()-+"

def minimumNumber(nn, password):
    # Return the minimum number of characters to make the password strong
    l = False
    u = False
    n = False
    s = False
    count = 4
    for c in password:
        if lower_case.__contains__(c) and not l:
            l = True
            count -= 1
            continue
        if upper_case.__contains__(c) and not u:
            u = True
            count -= 1
            continue
        if numbers.__contains__(c) and not n:
            n = True
            count -= 1
            continue
        if special_characters.__contains__(c) and not s:
            s = True
            count -= 1
            
    return count if nn + count >= 6 else 6 - nn