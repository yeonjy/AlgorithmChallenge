# 프로그래머스 - 2016년 (12901)
# 출제 의도를 너무 피한 것 같다 ..^^
from datetime import datetime, date

def solution(a,b):
    days = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
    day = date(2016, a, b).weekday()
    return days[day]

