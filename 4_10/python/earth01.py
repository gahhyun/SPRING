#딕셔너리 자료형 선언
a = {'name':'earth', 'phone':'01023456789', 'birth':'20100101' }
b = {0:"hello Earth"}
c = {'arr': [1,2,3,4,5]}

print('a : ', type(a), a)
print('b : ', type(b), b)
print('c : ', type(c), c)

#출력
print('a : ', a['name'])            #존재X => 에러 발생
print('a : ', a.get('phone1'))      #존재X =>  None 처리
print('b : ', b[0])
print('b : ', b.get(0))
print('c : ', c['arr'])
print('c : ', c['arr'][3])
print('c : ', c.get('arr'))

#딕셔너리 추가
a['address'] = 'seoul'
print('a : ', a)

#rank [1,2,3]
a['rank'] = [1,2,3]
print('a : ', a)


arr1 = ['컴퓨터', '키보드', '모니터']
arr2 = ['computer' , 'keyboard', 'monitor']
date = {}
for i in range(3):
    date[arr1[i]] = arr2[i]

print(date)

#keys()
data = {}
data['apple'] = '사과'
data['banana'] = '바나나'
data['carrot'] = '당근'
print(data)

for key in date.keys():
    print('key : ', key, 'value : ',date[key] )

#keys()
print('a : ', a.keys())
print('b : ', b.keys())
print('c : ', c.keys())

#values
print('a : ', a.values())
print('b : ', b.values())
print('c : ', c.values())

#items 키-벨류 동시출력
print('a : ', a.items())
print('b : ', b.items())
print('c : ', c.items())

'''
딕셔너리 자료형은 데이터의 횟수를 셀때 사용하면 효과적임
{1:2, 3:3, 5:1, 4:2}
'''
data = [1,3,3,5,4,3,1,4]
counter = {}

for x in data:
    if x not in counter:
        counter[x] = 1
    else:
        counter[x] += 1
print(counter)


















