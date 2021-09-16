def stockmax(prices):
    profit = 0
    len_prices = len(prices)
    current_max = prices[len_prices - 1]

    for i in range(len_prices - 2, -1, -1):
        prev_item = prices[i]

        if current_max < prev_item:
            current_max = prev_item
            continue

        if current_max > prev_item:
            profit += current_max - prev_item

    return profit
