'''
환전금액 = 한국돈/매매기준율

예) 환전 금액(원)을 입력하세요 : 1000원
    국가를 입력하세요 : 중국
    1000원은 5.05위안 입니다

예) 환전 금액(원)을 입력하세요 : 1000원
    국가를 입력하세요 : 미국
    1000원은 0.75달러 입니다

예) 환전 금액(원)을 입력하세요 : 1000원
    국가를 입력하세요 : 필리핀
    해당 국가 정보가 없습니다
'''

def exchange(money, county):

    if county in county_list:
        code = county_list.index(county)
    else:
        print("해당 국가 정보가 없습니다")
        return

    result = round(money / rate[code], 2)
    print(money, '원은', result, unit[code], '입니다')

county_list =[ '미국', '중국', '유럽','일본' ]
unit =['달러', '위안', '유로','엔화' ]
rate =[1313.88, 190.36, 1432.15, 979.96]

money1 = int(input('환전 금액(원)을 입력하세요 :'))
county1 = input('국가를 입력하세요 :')
exchange(money1, county1)

#......






















