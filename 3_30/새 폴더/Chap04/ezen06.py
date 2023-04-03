'''
    랜덤으로 나오는 값을 주민등록번호 뒷자리 중 첫번재 숫자로 보고
    남, 여를 출력하는 프로그램을 작성하시오.
'''
import random

print("주민등록번호의 성별 정보를 생성합니다.")
gender = random.randrange(4)
gender = gender + 1

print("생성번호 : " + str(gender))      #  문자와 숫자 연결하여 출력

if gender == 1 or gender == 3:
    print("남성입니다.")
else:
    print("여성입니다.")
print("프로그램을 종료합니다.")
