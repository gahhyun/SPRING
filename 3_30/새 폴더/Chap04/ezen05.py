'''
    자판기에 들어갈 프로그램을 구현하시오.
    자판기에 입력될 돈이 300이면 커피를 주고,
    300원보다 적은 경우엔 돈을 그냥 돌려주고,
    300원보다 많은 경우에는 커피와 함께 거스름돈을 주어야 한다.

'''
money = 300
if money == 300:
    print("Coffee")
elif money < 300:
    print("거스름 %d원을 돌려줍니다. " % money)
else:
    print("Coffee")
    print("거스름 %d원을 돌려줍니다. " % (money-300))


print("=" * 30)

if money == 300:
    print("Coffee")
else:
    if money < 300:
        print("거스름 %d원을 돌려줍니다. " % money)
    else:
        print("Coffee")
        print("거스름 %d원을 돌려줍니다. " % (money - 300))



















