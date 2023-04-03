#튜플 선언
a = ()
b = (1,)
c = (1,2,3,4)
d =(10, 100, 'powerful', 'health', 'Feature')
e =(10, 100,('powerful', 'health', 'Feature'))

#튜플 인덱스
print()
print('d : ', type(d), d)
print('d : ', d[1])
print('d : ', d[0]+d[1]+d[1])
print('d : ', d[-1])
print('d : ', d[-1][1])
print('d : ', d[-1][1][3])

#튜플 슬라이싱
print()
print('d : ', d[0:3])
print('d : ', d[2:])
print('e : ', e[2][1:3])

#튜플 연산
print()
print('c+d', c+d)
print('c*3 : ', c*3)

#튜플 함수
a = (5,2,3,1,4)
print('a : ', a)
print('a : ', a.index(5))
print('a; ', a.count(4))