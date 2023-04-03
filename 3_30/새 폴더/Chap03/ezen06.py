import turtle
t = turtle.Turtle()
t.shape("turtle")

s = turtle.textinput("","이름을 입력하시오: ")
t.write("안녕하세요? " +s+ "님, 거북이 인사드릴께요!")

#사각형 그리기
t.left(90)
t.forward(100)
t.left(90)
t.forward(100)
t.left(90)
t.forward(100)
t.left(90)
t.forward(100)

turtle.exitonclick();