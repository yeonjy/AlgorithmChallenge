#프로그래머스 - 약수의 합(12928)

def solution(n):
    total = n
    for i in range(1, n//2 + 1):
        if n % i == 0:
            total += i
    return total
