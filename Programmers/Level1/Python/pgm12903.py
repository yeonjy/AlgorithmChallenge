# 프로그래머스 - 가운데 글자 가져오기 (12903)
def solution(s):
    l = len(s)
    return s[l//2-1: l//2+1] if l%2 == 0 else s[l//2]
