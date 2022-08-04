# 프로그래머스 - 두 개 뽑아서 더하기 (68644)
def solution(numbers):
    arr = []
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            arr.append(numbers[i] + numbers[j])

    arr = list(set(arr))
    arr.sort()
    return arr
