# 프로그래머스 - 나누어 떨어지는 숫자 배열 (12910)
def solution(arr, divisor):
    answer = []
    for i in arr:
        if i % divisor == 0:
            answer.append(i)
    answer.sort() if len(answer) != 0 else answer.append(-1)
    return answer
