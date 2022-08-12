# 프로그래머스 - 최소직사각형 (86491)
def solution(sizes):
    for i in sizes:
        i.sort()
    rev_list = list(map(list, zip(*sizes)))
    return max(rev_list[0]) * max(rev_list[1])