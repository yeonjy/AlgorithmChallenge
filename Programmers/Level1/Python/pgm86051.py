# 프로그래머스 - 없는 숫자 더하기 (86051)

def solution(numbers):
    arr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    for i in numbers:
        arr.remove(i)
    return sum(arr)
