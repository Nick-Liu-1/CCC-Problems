import sys
from collections import defaultdict

input = sys.stdin.readline

class Graph():
    def __init__(self):
        self.graph = defaultdict(list)

    def addEdge(self, u, v):
        self.graph[u].append(v)

g = Graph()
N = int(input())
for i in range(N):
    a, b = [int(i) for i in input().split()]
    a -= 1
    b -= 1
    g.addEdge(a, b)

def search(a, b):
    current = a
    count = 0
    visited = [False for i in range(9999)]
    while True:
        visited[current] = True
        if current == b:
            return count

        current = g.graph[current][0]
        count += 1
        
        if visited[current]:
            return -1
        

        
        
#print(g.graph)
    
while True:
    a, b = [int(i) for i in input().split()]
    if a == 0:
        break
    a -= 1
    b -= 1

    x = search(a, b)
    
    
    if x == -1:
        print("No")
    else:
        print("Yes", x-1)
"""
6
1 2
2 3
3 1
4 3
5 4
6 1
5 1
0 0
"""

    
