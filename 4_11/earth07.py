s = set()

s = {1,2,5}

#추가
s.add(10)
s.add(3)
print(s)

#삭제
s.discard(5)
print(s)

s.remove(2)
print(s)

#전체삭제
s.clear()
print(s)

#가위, 바위, 보 게임
'''
가위, 바위, 보 입력: 가위
비겼습니다
가위, 바위, 보 입력: 바위
이겼습니다
'''
import random

def rps_game(c,m):
    if c==m:
        return '비겼습니다'
    elif match_dic[c] == m:
        return '졌습니다'
    else:
        return '이겼습니다'

rps_dic = {1:'가위', 2:'바위', 3:'보'}
match_dic = {'가위':'보', '바위':'가위', '보':'바위'}

computer = rps_dic[random.randint(1,3)]
print('computer : ' , computer)
me= input('가위, 바위, 보 입력 : ')

result = rps_game(computer, me)
print(result)
























