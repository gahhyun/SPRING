import matplotlib as mpl        # 별칭은 mpl
import matplotlib.pyplot as plt # motplotlib 모듈의 서브 모듈

'''
    레이블을 가진 이차원 평명에서의 선차트 작성
'''
plt.plot([0,1,2,3],[1,2,3,4])             # x값의 범위는 생략가능
plt.ylabel('y label')                     # y축 레이블 (속성)
plt.xlabel('x label')
plt.show()
