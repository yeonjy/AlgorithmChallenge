import sys

n, m = map(int, input().split())
note = dict()

for _ in range(n):
    s = sys.stdin.readline().strip()
    if len(s) >= m:
        if s in note:
            note[s] += 1
        else:
            note[s] = 1

note = sorted(note.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))
for word in note:
    print(word[0])