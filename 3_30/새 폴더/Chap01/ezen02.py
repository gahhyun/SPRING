'''
    * turtle graphic 모듈
'''
import turtle

t = turtle.Turtle()
t.shape("turtle")
# 앞으로 전진
t.forward(100)
# 왼쪽으로 90도 회전
t.left(90)
t.forward(50)
turtle.exitonclick()