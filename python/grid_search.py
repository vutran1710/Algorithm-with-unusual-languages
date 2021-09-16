def gridSearch(G, P):
    pattern_len = len(P[0])

    for idx, row in enumerate(G):

        if idx + len(P) > len(G):
            break

        start = 0

        while start <= (len(row) - pattern_len):
            find_idx = row.find(P[0], start)

            if find_idx >= 0:
                check = True

                for n in range(1, len(P)):
                    next_row = G[idx + n]
                    substring = next_row[find_idx : find_idx + pattern_len]

                    if substring != P[n]:
                        check = False
                        break

                if check:
                    return "YES"

            start += 1

    return "NO"
