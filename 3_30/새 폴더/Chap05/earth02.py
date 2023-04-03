#while

response = '아냐'
while response == '아냐':
    response = input('엄마, 밥 다 됐어요? ')
print('밥 먹어요')

print('-'*30)

#1부터 100까지의 합을 구하시오(while사용)
count = 1
sum = 0
while count<=100:
    sum += count
    count += 1  #1이 증가하도록
print(sum)

'''
암호를 입력하세요:
암호를 입력하세요:
암호를 입력하세요: no
로그인 성공
'''

x = ''
while x != 'python':
    x = input('암호를 입력하세요')  #입력받은 값을 x에 할당 => 맞지 않다면 loop돌기
print('로그인 성공')

print('-'*30)

'''
**********
**********
**********
**********
**********

'''
for i in range(5):
    print('*'*10 ,end='\n')  #end를 안붙이면 한줄이 띄어져서 반복된다

for i in range(5):
    for j in range(10):
        print('*',end='')
    print('')



