# 프로그래머스 - 문자열을 정수로 바꾸기 (12925)
def solution(s):
    if s[0].isdigit():
        return int(s)
    elif s[0] == "+":
        return int(s[1:])
    else:
        return - int(s[1:])