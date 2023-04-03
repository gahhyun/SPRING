s = "Hello Python"
print(s[6:10])
print(s[-6:-2])
print(s[0:10:2])
print(s[-1:-7:-1])

'''
1.  소금물의 농도를 구하는 프로그램입니다.
    소금의 양은 몇 g입니까?  50
    물의 양은 몇 g입니까?    80
    소금물의 농도 :  38.46153846%
'''
print("소금물의 농도를 구하는 프로그램입니다.")
salt = int(input("소금의 양은 몇 g입니까?"))
water = int(input("물의 양은 몇 g입니까?"))
density = salt / (salt + water) * 100
print("소금물의 농도 : " + str(density) + "%")