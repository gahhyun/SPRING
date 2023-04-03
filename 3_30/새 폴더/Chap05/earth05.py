'''
도돌이표
: 악보를 연주하는 순서를 출력하는 프로그램을 반복문을 이용하여 작성하시오

    A   B   (도돌이표)C     (도돌이표)D

    연주순서 : A - B - C - D - C - D
'''
print('연주순서')
print('A', end=' ')
print('B', end=' ')
for i in range(2):
    print('C', end=' ')
    print('D', end=' ')
