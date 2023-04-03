'''
    원의 반지름을 입력하세요 :
    원의 색깔을 입력하세요 :

    캔버스에 터틀 불러오기 => 원의 크기 입력받기 => 원의 색깔 입력받기 => 원 그리기
'''
import turtle
t = turtle.Turtle()
t.shape("turtle")

radius = int(input("원의 반지름을 입력하세요: "))
color = input("원의 색깔을 입력하세요: ")
t.color(color)
t.begin_fill()
t.circle(radius)
t.end_fill()
turtle.exitonclick()


























