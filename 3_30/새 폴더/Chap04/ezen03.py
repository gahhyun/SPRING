# if-elif-else
# if 중첩

num = int(input("정수입력하세요: "))

if num > 0:
    print("양수입니다.")
elif num == 0:
    print("0입니다.")
else:
    print("음수입니다.")

print("-" * 30)

num = int(input("정수입력하세요: "))
if num >= 0:
    if num == 0:
        print("0입니다.")
    else:
        print("양수입니다.")
else:
    print("음수입니다.")

