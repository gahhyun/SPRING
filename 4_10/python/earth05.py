'''
    2차 함수 그래프 그리기
        -2차 함수의 계수 입력받아서 2차함수 그리기
'''
import matplotlib.pyplot as plt

xlist = []

#-10.0에서 10.0까지의 실수 200개 생성하시오
for i in range(-100, 100):
    xlist.append(i/10.0)

a = int(input('a : '))
b = int(input('b : '))
c = int(input('c : '))

ylist = []
for i in xlist:
    ylist.append(a*i**2 + b+i + c)

plt.plot(xlist, ylist)
plt.show()