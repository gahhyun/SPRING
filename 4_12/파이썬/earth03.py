class Human:
    def __init__(self):
        self.age = 0

    def old(self):
        self.age += 1

# 사람 인스턴스 생성
human1 = Human()
human2 = Human()

for i in range(10):     # 10세
    human1.old()

for i in range(20):     # 20세
    human2.old()

# 각 사람 나이 출력하시오
print(human1.age)
print(human2.age)


