#프로그래머스 - 두 정수 사이의 합 (12912)
def solution(a, b):
    answer = 0
    if a > b:
        tmp = a
        a = b
        b = tmp
    for i in range(a, b+1):
        answer += i
    return answer
