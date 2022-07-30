# 프로그래머스 - 자연수 뒤집어 배열로 만들기 (12932)
def solution(n):
    return list(map(int, list(str(n)[::-1])))