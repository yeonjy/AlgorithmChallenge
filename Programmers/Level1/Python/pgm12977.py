#프로그래머스 - 소수 만들기 (12977)
def solution(nums):
    num = len(nums)
    answer = 0

    for i in range(num-2):
        for j in range(i+1, num-1):
            for k in range(j+1, num):
                count = 0
                sum_all = nums[i] + nums[j] + nums[k]
                for p in range(2, sum_all//2+1):
                    if sum_all % p == 0:
                        count += 1
                if count == 0:
                    answer += 1
    return answer
