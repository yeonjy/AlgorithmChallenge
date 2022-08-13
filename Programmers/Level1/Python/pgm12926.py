#프로그래머스 - 시저 암호 (12926)
def solution(s, n):
    answer = ""
    for i in range(len(s)):
        if not s[i] == " ":
            if s[i].isupper() and ord(s[i]) + n > 90:
                tmp = ord(s[i]) + n - 90
                answer += chr(64 + tmp)
            elif s[i].islower() and ord(s[i]) + n > 122:
                tmp = ord(s[i]) + n - 122
                answer += chr(96 + tmp)
            else:
                answer += (chr(ord(s[i]) + n))
        else:
            answer += " "
    return answer
