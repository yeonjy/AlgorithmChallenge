cro = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
lens = [2, 2, 3, 2, 2, 2, 2, 2]

string = input()
count = 0
i = 0
while i < len(string):
    count += 1
    for idx, item in enumerate(cro):
        if string[i:i + lens[idx]] == cro[idx]:
            i += lens[idx] - 1
            break
    i += 1

print(count)
