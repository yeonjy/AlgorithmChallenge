S = input()
S_len = len(S)
result = set()

for i in range(S_len):
    for j in range(S_len - i + 1):
        result.add(S[i:i + j])

print(len(result) - 1)