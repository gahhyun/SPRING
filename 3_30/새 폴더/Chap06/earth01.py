theglory = ["송혜고", "이도현", "임지연", "염혜란"]

numbers = [7, 12, 33, 777]

slists = ["영어", "수학", "사회", "과학"]
print(slists)
print(slists[0])        #리스트 항목 하나씩 접근하기
print(slists[1])
print(slists[2])
print(slists[3])


#공백 리스트
cart = []
cart.append("사과")
print(cart)
cart.append("세제")
print(cart)


letters = ["A", "B", "C", "D", "E", "F"]
print(letters[0:3])
print(letters[:3])
print(letters[3:])
print(letters[:])


copy = letters[:]
print(copy)


cart = ["사과", "세제", "화장지", "치약"]
cart[1] = "섬유유연제"
print(cart)  #세제가 사라짐

#cart[10] = "양말"   --아직 존재하지 않는 인덱스 항목은 당연히 할당불가능
cart.insert(1,"건전지")
print(cart)

cart.remove("화장지")
print(cart)

if "치약" in cart:
    cart.remove("치약")
print(cart)

del cart[2]        #리스트 항목 삭제하기
print(cart)

cart = ["사과", "세제", "화장지", "치약"]
item = cart.pop()           # 마지막 요소를 꺼내서 삭제
print(cart)
print(item)                 #삭제된 요소 출력

#항목을 탐색하기
#index() : 해당 할목의 인덱스 번호 리턴함
print(cart.index("화장지"))

if "화장지" in cart:
    print(cart.index("화장지"))

#리스트 정렬하기
theglory = ["송혜고", "이도현", "임지연", "염혜란"]
theglory.sort()     #기존리스트 정렬(기존리스트 영향o)
print(theglory)

theglory.sort(reverse=True)     #내림차순
print(theglory)

#sortes() : 새로운 정렬된 리스트가 생성(기존리스트 영향x)
new_theglory = sorted(theglory)
print(theglory)
print(new_theglory)


#2차원 리스트
num = [[10,20,30], [40,50,60]]
print(num)
print(num[0][0])
print(num[0][1])
print(num[1][1])    #위치읽기
num[1][2] = 100     #수정
print(num)











