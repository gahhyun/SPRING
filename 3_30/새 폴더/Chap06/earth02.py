for i in [1,2,3]:
    print("i = ", i)

casino_characters = []
for i in range(5):
    name = input("카지노의 등장인물 이름을 입력하시오 : ")
    casino_characters.append(name)

for i in casino_characters:
    print(i, end=" ")

num = [100, 96, 209, 22, 30, 117]
for i in num:
    if i%2 == 1:
        print(i, end=" ")