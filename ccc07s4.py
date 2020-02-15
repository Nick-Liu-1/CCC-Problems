import sys
from collections import defaultdict

class Graph:
    def __init__(self):
        self.graph = defaultdict(list)
        

    def addEdge(self, u, v):
        self.graph[u].append(v)

N = int(input())
g = Graph()

while True:
    a, b = [int(i) for i in input().split()]
    if a == 0:
        break
    a -= 1
    b -= 1
    g.addEdge(a, b)

queue = []
queue.append(0)

costs = [0 for i in range(N)]
costs[0] = 1
visited = defaultdict(bool)
visited[0] = True
    
while len(queue) > 0:
    v = queue.pop(0)
    for temp in g.graph[v]:
        if visited[temp] == False:
            queue.append(temp)
            visited[temp] = True
        
        costs[temp] += costs[v]
        
print(costs[-1])

"""
9
1 2
1 3
1 4
1 5
2 6
3 6
4 6
4 7
5 7
6 8
7 8
7 9
8 9
0 0
"""
