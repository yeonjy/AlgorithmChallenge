# 프로그래머스 - 부족한 금액 계산하기 (82612)
def solution(price, money, count):
    sumAll = 0
    for i in range(count):
        sumAll += price * (i+1)
    return sumAll - money if sumAll - money >= 0 else 0
