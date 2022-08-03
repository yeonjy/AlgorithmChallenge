# 프로그래머스 - 모의고사 (42840)
def solution(answers):
    answer1 = [1, 2, 3, 4, 5]
    answer2 = [2, 1, 2, 3, 2, 4, 2, 5]
    answer3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    res = [0, 0, 0]

    ans_len = len(answers)
    for an in answer1, answer2, answer3:
        an *= (ans_len // len(an) + 1)
    j = 0
    for an in answer1, answer2, answer3:
        for i in range(ans_len):
            if answers[i] == an[i]:
                res[j] += 1
        j += 1

    answer = []
    tmp = max(res)

    if res[0] == tmp:
        answer.append(1)
    if res[1] == tmp:
        answer.append(2)
    if res[2] == tmp:
        answer.append(3)
    return answer
