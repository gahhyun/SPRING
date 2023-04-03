def print_address():
    print("서울 강남구 강남대로 646")
    print("020-500-6456")
    print("Applr 강남")

print_address()

print("-"*30)

def print_address(name):
    print("서울 강남구 강남대로 646")
    print("020-500-6456")
    print(name)

print_address("이순신")
print_address("신사임당")
print_address("대한민국")

print("-"*30)

def get_sum(start, end):
    sum = 0
    for i in range(start, end+1):
        sum += i
    print("sum = ", sum)

get_sum(1, 10)

#기본 매개변수
def operate(first, second = 1):
    print(first + second)

operate(10, 20)
operate(10)

print("-"*30)

def calculate_area(redicus):
    area = 3.14 * redicus**2
    return  area        #함수값의 반환

area = calculate_area(5.0)
print(area)

def get_input():
    return 2,3

x, y = get_input()
print(x, " ", y)

print("-"*30)

#다중리턴
def fun_mul(x):
    y1 = x *2
    y2 = x *4
    y3 = x *6
    return y1, y2, y3

val1, val2, val3 = fun_mul(3)
print(val1, val2, val3)

print("-"*30)

#튜플 리턴
def fun_mul2(x):
    y1 = x *2
    y2 = x *4
    y3 = x *6
    return (y1, y2, y3)

tup = fun_mul2(4)
print(type(tup), tup)

print("-"*30)

#리스트 리턴
def fun_mul3(x):
    y1 = x *2
    y2 = x *4
    y3 = x *6
    return [y1, y2, y3]

lis = fun_mul3(6)
print(type(lis), lis)

print("-"*30)

#calculate_area() 안의 (전역)변수 r을 밖에서 함께 사용가능
def calculate_area():
    result = 3.14 * r **2
    return result

r = float(input("원의 반지름 : "))
area = calculate_area()         #나중에 정의된 것이 호출된다
print(area)














