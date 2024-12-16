string = input()
M = len(string)

arr = string.split('-')
total = 0
nums = arr[0].split('+')
for num in nums:
    total += int(num)

for i in range(1, len(arr)):
    nums = arr[i].split('+')
    for num in nums:
        total -= int(num)

print(total)
