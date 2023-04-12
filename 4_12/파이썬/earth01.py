class Car:
    #객체를 초기화 하는 특별한 메서드
    #속도, 색상을 받아서 객체 안의 변수에 저장함
    def __init__(self, speed, color):
        self.speed = speed
        self.color = color

    def drive(self):    #메서드의 첫번째 인자는 항상 self
        self.speed = 60
        print('주행중입니다')

    def stop(self):
        self.speed = 0
        print('정지했습니다')

myCar = Car(0,'white')
print(myCar.speed)
print(myCar.color)

myCar.drive()
print(myCar.speed)

myCar.stop()
print(myCar.speed)

yourCar = Car(60, 'green')
earthCar = Car(70, 'silver')
moonCar = Car(30, 'red')

