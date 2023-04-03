print('반복문을 환영합니다!')
print('반복문을 환영합니다!')
print('반복문을 환영합니다!')
print('반복문을 환영합니다!')
print('반복문을 환영합니다!')

print('-'* 30)

#반복 구조 이용
for i in range(5):
    print('반복문을 환영합니다!')

print('-'* 30)

for i in range(1,6,1):
    print(i, end=' ')

print('-'* 30)
#10부터 1까지 반복
for i in range(10,0,-1):
    print(i, end=' ')

print(end='\n')
print('-'*30)

sum =0
for i in range(1,101):
    sum += i
print('1부터 100가지의 합 : ',sum)

'''
    팩토리얼 계산 프로그램을 작성하시오
    n! = n * (n-1) * (n-2) * ... 3 * 2 * 1
    
    출력예시
    정수를 입력하시오 : 10
    18!은 3628800입니다
'''
fact = 1
x = int(input('정수를 입력하세요 : '))
for i in range(x, 0,-1):
    fact *= i
print(fact)



















