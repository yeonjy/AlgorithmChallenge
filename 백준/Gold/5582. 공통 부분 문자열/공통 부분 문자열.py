def get_longest_common_substring(x, y):
    x = " " + x
    y = " " + y
    n = len(x)
    m = len(y)

    max_length = 0
    dp = [0] * n

    for r in range(1, m):
        saved = [0] * n
        for c in range(1, n):
            if x[c] == y[r]:
                saved[c] = dp[c - 1] + 1
                max_length = max(max_length, saved[c])
        dp = saved[:]
    return max_length


str1 = input()
str2 = input()

print(get_longest_common_substring(str1, str2))