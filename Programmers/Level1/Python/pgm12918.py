#프로그래머스 - 문자열 다루기 기본 (12918)
def solution(s):
    if s.isdigit() and (len(s) == 4 or len(s) == 6):
        return True
    return False
