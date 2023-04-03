'''
랜덤으로 동전을 던져 결과를 확인하는 프로그램을 구현하시오.
그래픽버전으로 구현하시오.
'''
import random
import turtle               # 터틀 그래픽 모듈을 불러움

screen = turtle.Screen()
image1 = "C:\\Users\\ezen\\Desktop\\Python_Math\\Python\\Chap04\\front.gif"
image2 = "C:\\Users\\ezen\\Desktop\\Python_Math\\Python\\Chap04\\back.gif"

screen.addshape(image1)
screen.addshape(image2)

t1 = turtle.Turtle()    # 터틀 생성
coin = random.randint(0,1)     # 동전의 앞, 뒤 정보 만들기

if coin == 0:
    t1.shape(image1)
    t1.stamp()
    turtle.exitonclick()
else:
    t1.shape(image2)
    t1.stamp()
    turtle.exitonclick()



