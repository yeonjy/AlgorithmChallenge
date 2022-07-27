# 완주하지 못한 선수 (42576)
def solution(participant, completion):
    participant.sort()
    completion.sort()
    for i in range(len(completion)):
        if participant[i] != completion[i]:
            return participant[i]
        elif i == len(completion)-1:
            return participant[i+1]