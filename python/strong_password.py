numbers = "0123456789"
lower_case = "abcdefghijklmnopqrstuvwxyz"
upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
special_characters = "!@#$%^&*()-+"


def minimumNumber(n, password):
    low = False
    upp = False
    num = False
    spe = False
    count = 4
    for c in password:
        if c in lower_case and not low:
            low = True
            count -= 1
            continue
        if c in upper_case and not upp:
            upp = True
            count -= 1
            continue
        if c in numbers and not num:
            num = True
            count -= 1
            continue
        if c in special_characters and not spe:
            spe = True
            count -= 1

    return count if n + count >= 6 else 6 - n
