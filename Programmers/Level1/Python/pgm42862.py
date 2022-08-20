#프로그래머스 - 체육복(42862)

def solution(n, lost, reserve):
    real_lost = [i for i in lost if i not in reserve]
    real_reserve = [i for i in reserve if i not in lost]
    cnt = 0
    real_lost.sort()
    real_reserve.sort()
    for i in real_lost:
        if i-1 in real_reserve:
            cnt += 1
            real_reserve.remove(i-1)
        elif i+1 in real_reserve:
            cnt += 1
            real_reserve.remove(i+1)
    return n - len(real_lost) + cnt
