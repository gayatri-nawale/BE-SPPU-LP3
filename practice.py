# import numpy as np
# import matplotlib.pyplot as plt

# def f(x):
#     return x**2

# def gradient(x):
#     return 2*x

# x=5
# iterations=100
# learningrate=0.1
# tolerance=0.000001

# path=[x]

# for i in range(iterations):
#     newX=x-learningrate*gradient(x)
#     path.append(newX)

#     if(abs(newX-x)<tolerance):
#         x=newX
#         break
#     x=newX

# print("starting point : " ,round(x,3))
# print("minimum point : " ,round(f(x),3))
# print("iterations : " ,i+1)

# X1=np.linspace(-8,4,100)

# plt.plot(X1,f(X1),label="y=(x+3)^2")
# plt.scatter(2,f(2),color="blue",s=150,label="starting point")
# plt.scatter(x,f(x),color="green",s=150,label="minimum point")

# plt.plot(path,[f(v) for v in path],"o--",label="gradient descent")


# plt.xlabel("x")
# plt.ylabel("y")
# plt.legend()
# plt.grid()
# plt.show()