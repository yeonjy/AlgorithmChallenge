S = input()
S_len = len(S)

# 문자열이 이미 팰린드롬인지 확인
if S == S[::-1]:
    print(S_len)
    exit()

for i in range(S_len):
    if S[i:] == S[i:][::-1]:
        print(S_len + i)
        exit()
