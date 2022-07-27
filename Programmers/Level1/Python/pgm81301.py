# 숫자 문자열과 영단어
def solution(s):
    number = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    for i in range(len(number)):
        s = s.replace(number[i], str(i))
    return s

string1 = "one4seveneight"
print(solution(string1))

