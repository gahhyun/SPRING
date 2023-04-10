'''
    리스트로 그래프 그리기
        -리스트를 10개의 난수로 채우고 이 데이터를 그래프로 시각화하시오
'''
import random
import matplotlib.pyplot as plt

ran = []
#난수로 리스트를 채움
for i in range(10):
    ran.append(random.randint(1,10))
print(ran)

plt.plot(ran)
plt.ylabel('some random ran')
plt.show()