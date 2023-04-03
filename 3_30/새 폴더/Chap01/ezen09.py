import turtle

t=turtle.Turtle()
t.shape("turtle")

t.down()    #펜을 내림
t.goto(100, 0)  #선을 그리며 이동
t.up()      #펜을 올림
t.goto(0, 200)  #선을 그리지 않고 이동
t.down()   #펜을 내림
t.goto(100, 200) #선을 그리며 이동

turtle.exitonclick()
