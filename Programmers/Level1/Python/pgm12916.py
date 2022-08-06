#프로그래머스 - 문자열 내 p와 y의 개수(12916)
def solution(s):
    return True if s.count('p') + s.count('P') == s.count('y') + s.count('Y') else False
