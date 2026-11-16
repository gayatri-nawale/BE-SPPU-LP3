# Implement Gradient Descent Algorithm to find the local minima of a function.,
# For example, find the local minima of the function y=(x+3)² starting from the point x=2.

import numpy as np
import matplotlib.pyplot as plt

# 1. Define the function
def f(x):
    return (x + 3)**2

# 2. Define the derivative (gradient)
def gradient(x):
    return 2 * (x + 3)

# 3. Initialize values
x = 2
learning_rate = 0.1
iterations = 100
tolerance = 0.000001 # 5 zero
# Tolerance is a small threshold used to stop Gradient Descent when the change between consecutive values becomes very small.

# Store values for plotting
path = [x]

# 4. Gradient Descent
for i in range(iterations):

    new_x = x - learning_rate * gradient(x)

    path.append(new_x)

    if abs(new_x - x) < tolerance:
        x = new_x
        break

    x = new_x

# 5. Display result
print("Minimum x:", round(x, 3))
print("Minimum y:", round(f(x), 3))
print("Iterations:", i + 1)

# 6. Plot the function
X = np.linspace(-8, 4, 100)         # Creates 100 equally spaced values between -8 and 4 for drawing the graph.

plt.plot(X, f(X), label="y = (x + 3)^2")

plt.scatter(2, f(2), color="red", s=150, label="Starting Point")

plt.scatter(x, f(x), color="green", s=150, label="Minimum Point")

plt.plot(path, [f(v) for v in path], "o--", label="Gradient Descent Path")

plt.xlabel("x")
plt.ylabel("y")
plt.title("Gradient Descent")
plt.legend()                # Displays labels of graph elements.
plt.grid()
plt.show()
