# 프로그래머스 - K번째 수 (42748)

def solution(array, commands):
    size = len(commands)
    ans = [0 for i in range(size)]
    for i in range(size):
        arr = array[commands[i][0]-1 : commands[i][1]]
        arr.sort()
        ans[i] = arr[commands[i][2] - 1]
    return ans
