'''
직각삼각형을 출력하는 프로그램을 작성하시오
*
**
***
****
*****
'''

for i in range(5):
    for j in range(i+1):
        print('*',end="")
    print(end='\n')

print('-'*30)

#무한반복을 이용한 신호등 (red면 무한반복, blue이면 무한반복 종료)
sign = True
while sign:
    light = input('신호등 색상을 입력하세여 : ')
    if light == 'blue':
        sign = False  #무한루프 탈출
print('출발')

print('-'*30)

while True:
    light = input('신호등 색상을 입력하세여 : ')
    if light == 'blue':
        break   #강제종료
print('출발')
print('-'*30)

while True:
    light = input('신호등 색상을 입력하세여 : ')
    if light == 'blue':
        break   #강제종료
print('출발')
print('-'*30)

#홀수만 출력하기
for n in range(10):
    if n % 2 == 0:
        continue  #무시하고 다음 반복을 진행함
    print(n)

















