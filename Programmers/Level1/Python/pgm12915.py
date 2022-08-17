#프로그래머스 - 문자열 내 마음대로 정렬하기(12915)

def solution(strings, n):
    n_strings = []
    i = 0
    for s in strings:
        n_strings.append(s[n] + s)
    n_strings.sort()
    for v in n_strings:
        n_strings[i] = v[1:]
        i+=1
    return n_strings