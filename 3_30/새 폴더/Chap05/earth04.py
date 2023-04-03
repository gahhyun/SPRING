'''
반지름이 100인 원을 그려라
60도 만큼 터틀을 왼쪽으로 회전하세여
'''
import turtle

t = turtle.Turtle()
for i in range(6):
    t.circle(100)    #반지름 100
    t.left(360/6)   #60도 만큼
    t.speed(50)
turtle.exitonclick()