x = -123
x = 0
print(x)
print(type(x))

print()

x = -3.14
x = 0.0
print(x)
print(type(x))

print()
msg = "Hello"
msg = "She said 'Hi'"
print(msg)

print()
#x = input("정수를 입력하세요: ")
#y = input("정수를 입력하세요: ")
#print(x + y)

print()
#t = input("정수를 입력하세요: ")   # 사용자가 입력한 데이터를 문자열 형태로 리턴
#x = int(t)

#t = input("정수를 입력하세요: ")
#y = int(t)
#print(x + y)


print()
#x = float(input("실수를 입력하세요: "))
#y = float(input("실수를 입력하세요: "))
#print(x + y)

# 문자열과 문자열만 연결가능함
# print('나는 현재' +20+ '살입니다.')   #오류

# 정수를 문자열로 변환
print('나는 현재' +str(20)+ '살입니다.')

# 실수를 문자열로 변환
print('원주율은 ' +str(3.14)+ '입니다.')

# * 연산자를 이용해서 반복시킬수 있음
print("=" * 30)

s = "Hello Python"
print(s[0])
print(s[1])
print(s[-1])
print(s[-12])

print("=" * 30)

s = "Hello World"
#인덱스 3까지의 접두사 가져오기
prefix = s[0:4]
prefix = s[:4]
print(prefix)

#인덱스 2부터의 접미사 가져오기
suffix = s[2:]
print(suffix)

#중간에 있는 부분 문자열 가져오기
# orl
print(s[7:10])
print(s[-4:-1])




