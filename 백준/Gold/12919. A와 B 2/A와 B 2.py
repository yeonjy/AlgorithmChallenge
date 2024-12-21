import sys
sys.setrecursionlimit(10**6)

S = input()
T = input()

def reverse_dfs(now):
    if len(now) == len(S):
        return now == S

    if now[-1] == 'A':
        if reverse_dfs(now[:-1]):
            return True

    if now[0] == 'B':
        reversed_now = now[::-1][:-1]
        if reverse_dfs(reversed_now):
            return True

    return False

print(1 if reverse_dfs(T) else 0)
