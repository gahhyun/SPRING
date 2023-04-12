class Client:
    client_cnt = 0

    def __init__(self, id, name, age, gender, point):
        self.id = id
        self.name = name
        self.age = age
        self.gender = gender
        self.point = point
        Client.client_cnt +=1

    def show(self):
        print('=========고객 정보========')
        print(f'고객 번호 : {self.id}' )
        print(f'이름 : {self.name}')
        print(f'나이 : {self.age}')
        print(f'성별 : {self.gender}')
        print(f'고객 점수 : {self.point}')
        print(f'현재 총 고객 수 : {Client.client_cnt}')

    def __del__(self):
        Client.client_cnt -= 1


client1 = Client(1,'이순신', 20, '남성', 20000)
client2 = Client(2,'유관순', 30, '여성', 15000)
client3 = Client(3, '제레미 레너',40, '남성', 10000)

client1.show()
client2.show()
client3.show()
print(f'현재 총 고객 수 : {Client.client_cnt}')