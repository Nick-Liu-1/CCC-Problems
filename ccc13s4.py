from collections import defaultdict
import sys
input = sys.stdin.readline

class Graph:
    def __init__(self):
        self.graph = defaultdict(list)

    def addEdge(self, u, v):
        self.graph[u].append(v)

    def BFS(self, v, end):
        visited = defaultdict(bool)
        visited[v] = True

        queue = []
        queue.append(v)

        while len(queue) > 0:
            temp = queue.pop(0)
            if temp == end:
                return True
            for i in g.graph[temp]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True

        return False


N, M = [int(i) for i in input().split()]

g = Graph()

for i in range(M):
    a, b = [int(i) for i in input().split()]
    g.addEdge(a, b)

p, q = [int(i) for i in input().split()]
x = g.BFS(p, q)
y = g.BFS(q, p)

if x and not y:
    print("yes")
elif not x and y:
    print("no")
else:
    print("unknown")




