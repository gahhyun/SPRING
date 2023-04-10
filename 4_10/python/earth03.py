import matplotlib.pyplot as plt         #library 호출

x = [1,2,3]
y = [4,5,6]

plt.figure()
#plt.plot(y)         # lineplot은 y값만 있으면 그림을 그릴 수 있음 이때 x의 값은 0,1,2...순서로 자동 지정됨

#plt.plot(x,y,linewidth = 10)           # linewidth를 이용한 선 굵기 조정
#plt.plot(x,y,color = 'red')            # color를 통한 건 색상 조정
plt.plot(x,y,linestyle = ':')           # 선 형태 변경
plt.title('test', fontsize=50)
plt.grid(True, axis='y')
plt.show()