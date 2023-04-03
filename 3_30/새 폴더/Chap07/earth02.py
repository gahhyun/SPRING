# *args : 매개변수 개수가 정해져 있지 않은 경우에 사용
def args_func(*args):
    for i , v in enumerate(args):
        print('{}' , format(i),v , end=' ')
args_func('earth')
print()
args_func('earth', 'moon')
print()
args_func('earth', 'moon', 'sun')

print("-"*30)

#위치 인수
def calc(x, y):
    return  x-y
print(calc(10,20))
print(calc(20,10))

#키워드 인수
print(calc(y=10, x=20))
print(calc(y=20, x=10))

print("-"*30)

#중첩함수
def nested_func(num):
    def func_in_func(num):
        print(num)

    print('중첩함수')
    func_in_func(num + 100)

#func_in_func  >  중첩안의 함수는 호출 안됨
nested_func(1)

#함수의 힌트
def tot_length(word:str, num:int) -> int:
    return len(word) * num  #매개변수 정의는 str이였지만 리턴은 결국 int다

print('hint func : ', tot_length("heavy snow falls in Seoul", 10))




























