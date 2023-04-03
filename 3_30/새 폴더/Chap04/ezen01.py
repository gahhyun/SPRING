'''
    score가 60 이상이면 '합격입니다./ 수고하셨습니다.
    를 출력하는 프로그램을 작성하시오.
'''
score = 90
if score >= 60:             # 마지막에 콜론(:)을 사용
    print("합격입니다")       # 반드시 들여 쓰기 사용
    print("장학금을 받을 수 있습니다.")
else:
    print("불합격입니다.")
print("수고하셨습니다")

print("-" * 30)

'''
    언어를 선택하세요(1=한국어, 2=영어, 3=프랑스, 4=독일어) 1 
    안녕
   
    언어를 선택하세요(1=한국어, 2=영어, 3=프랑스, 4=독일어) 3
    Bonjour
        
    언어를 선택하세요(1=한국어, 2=영어, 3=프랑스, 4=독일어) 4 
    Guten Morgen   
'''
language = int(input("언어를 선택하세요(1=한국어, 2=영어, 3=프랑스, 4=독일어)"))
if language == 1:
    print("안녕")

if language == 2:
    print("Hello")

if language == 3:
    print("Bonjour")

if language == 4:
    print("Guten Morgen")

