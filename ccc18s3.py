import sys
from collections import defaultdict
import pprint
input = sys.stdin.readline

class Graph():
    def __init__(self):
        self.graph = defaultdict(list)

    def addEdge(self, u, v):
        self.graph[u].append(v)

    
N, M = [int(i) for i in input().split()]

grid = [[] for i in range(N)]

for i in range(N):
    for j in input().strip():
        grid[i].append(j)

impossible = False

for i in range(N):
    for j in range(M):
        if grid[i][j] == "C":
            for k in range(i, N):
                if grid[k][j] == "W":
                    break
                
                elif grid[k][j] == ".":
                    grid[k][j] = "w"

                elif grid[k][j] == "S":
                    impossible = True
                    
            for k in range(i, 0, -1):
                if grid[k][j] == "W":
                    break
                
                elif grid[k][j] == ".":
                    grid[k][j] = "w"

                elif grid[k][j] == "S":
                    impossible = True

            for k in range(j, M):
                if grid[i][k] == "W":
                    break
                
                elif grid[i][k] == ".":
                    grid[i][k] = "w"

                elif grid[i][k] == "S":
                    impossible = True
            
            for k in range(j, 0, -1):
                if grid[i][k] == "W":
                    break
                
                elif grid[i][k] == ".":
                    grid[i][k] = "w"

                elif grid[i][k] == "S":
                    impossible = True


g = Graph()
start = 0
for i in range(N):
    for j in range(M):
        if grid[i][j] == "." or grid[i][j] == "S":
            g.graph[M*i+j] = []

def travel(a, b):
    count = 0
    while True:
        count += 1
        current = grid[a][b]
        if current == "U":
            a -= 1
        if current == "D":
            a += 1
        if current == "L":
            b -= 1
        if current == "R":
            b += 1
        if current in "WwC" or count > 1000:
            return None
        if current == ".":
            return a, b


for i in range(N):
    for j in range(M):
        if grid[i][j] == "S":
            start = i*M + j
        
        if grid[i][j] == "." or grid[i][j] == "S":
            # up
            if i - 1 >= 0:
                if grid[i-1][j] == "." or grid[i-1][j] == "S":
                    g.addEdge(i*M + j, (i-1)*M + j)

                if grid[i-1][j] in "UDLR":
                    if travel(i-1, j) is not None:
                        a, b = travel(i-1, j)
                        g.addEdge(i*M + j, a*M + b)
            
            # down
            if i + 1 < N:
                if grid[i+1][j] == "." or grid[i+1][j] == "S":
                    g.addEdge(i*M + j, (i+1)*M + j)

                if grid[i+1][j] in "UDLR":
                    if travel(i+1, j) is not None:
                        a, b = travel(i+1, j)
                        g.addEdge(i*M + j, a*M + b)

            # left
            if j - 1 >= 0:
                if grid[i][j-1] == "." or grid[i][j-1] == "S":
                    g.addEdge(i*M + j, i*M + (j-1))

                if grid[i][j-1] in "UDLR":
                    if travel(i, j-1) is not None:
                        a, b = travel(i, j-1)
                        g.addEdge(i*M + j, a*M + b)


            # right
            if j + 1 < M:
                if grid[i][j+1] == "." or grid[i][j+1] == "S":
                    g.addEdge(i*M + j, i*M + (j+1))

                if grid[i][j+1] in "UDLR":
                    if travel(i, j+1) is not None:
                        a, b = travel(i, j+1)
                        g.addEdge(i*M + j, a*M + b)

MAXINT = 2**31 - 1
dist = [MAXINT for i in range(N*M)]
sptSet = defaultdict(bool)

        

def dijkstra(src):
    def minDistance():
        minimum = MAXINT
        min_index = None
        for v in g.graph:
            if dist[v] < minimum and sptSet[v] == False:
                minimum = dist[v]
                min_index = v
        return min_index
    
    dist[src] = 0

    for x in g.graph:
        u = minDistance()
        if u is not None:
            sptSet[u] = True

            for v in g.graph[u]:
                if sptSet[v] == False and dist[v] > dist[u] + 1:
                    dist[v] = dist[u] + 1    
       
    printStuffs()

"""print(g.graph)
print()
pprint.pprint(grid)
print()"""

def printStuffs():
    for i in range(N):
        for j in range(M):
            if not impossible:
                if grid[i][j] == ".":
                    if dist[M*i + j] < 1000000:
                        print(dist[i*M + j])
                    else:
                        print(-1)
                elif grid[i][j] == "w":
                    print(-1)
            else:
                if grid[i][j] == "." or grid[i][j] == "w":
                    print(-1)

dijkstra(start)


