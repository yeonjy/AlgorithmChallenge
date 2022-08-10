# 프로그래머스 - 약수의 개수와 덧셈 (77884)
def solution(left, right):
    answer = 0
    for i in range(left, right + 1):
        num = 0
        for j in range(1, i + 1):
            if i % j == 0:
                num = num + 1
        answer = answer + i if num % 2 == 0 else answer - i

    return answer