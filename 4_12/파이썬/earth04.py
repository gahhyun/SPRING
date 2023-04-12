class Student:
    def __init__(self, id, name, age, gender, department):
        self.id = id
        self.name = name
        self.age = age
        self.gender = gender
        self.department = department

    def show(self):
        print("=======학생 정보=======")
        print(f"학번: {self.id}")
        print(f'이름: {self.name}')
        print(f'나이: {self.age}')
        print(f'성별: {self.gender}')
        print(f'학과: {self.department}')

    def add_age(self, offset):
        self.age += offset

student1 = Student('20230001', '이순신', 23, '남성', '컴퓨터공학과')
student2 = Student('20230002', '신사임당', 30, '여성', '산업디자인공학과')
student3 = Student('20250003', '차무식', 40, '남성', '영어교육학과')

student1.show()
student2.show()
student3.show()

student1.add_age(5)
student1.show()