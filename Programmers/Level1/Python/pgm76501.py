#프로그래머스 - 음양 더하기 (76501)
def solution(absolutes, signs):
    answer = 0
    for i, num in enumerate(absolutes):
        if signs[i]:
            answer += num
        else:
            answer -= num
    return answer
