# 프로그래머스 - 나머지가 1이 되는 수 찾기 (87389)

def solution(n):
    if n == 3:
        return 3
    for i in range(1, n):
        if n % i == 1:
            return i
