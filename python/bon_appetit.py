def bonAppetit(bill, k, b):
    should_pay = (sum(bill) - bill[k]) / 2
    difference = round(b - should_pay)
    print(difference if difference > 0 else "Bon Appetit")
