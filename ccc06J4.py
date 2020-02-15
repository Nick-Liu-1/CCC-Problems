from collections import defaultdict

class Graph:
    def __init__(self):
        self.graph = defaultdict(list)

    def addEdgeStart(self, u):
        self.graph[u] = []
    
    def addEdge(self, u, v):
        self.graph[u].append(v)


g = Graph()
for i in range(1, 8):
    g.addEdgeStart(i)

g.addEdge(1, 4)
g.addEdge(1, 7)
g.addEdge(2, 1)
g.addEdge(3, 4)
g.addEdge(3, 5)


while True:
    x = int(input())
    y = int(input())
    if x == 0:
        break
    g.addEdge(x, y)

gr = Graph()
for i in range(1, 8):
    gr.addEdgeStart(i)

for v in g.graph:
    for n in g.graph[v]:
        gr.addEdge(n, v)
    g.graph[v].sort(reverse=True)

queue = []

for v in gr.graph:
    if len(gr.graph[v]) == 0:
        queue.append(v)

queue.sort(reverse=True)
visited = defaultdict(bool)

ans = ""

while len(queue) > 0:
    temp = queue.pop()
    visited[temp] = True
    ans += str(temp) + " "
    #print(temp, queue)
    for v in g.graph[temp]:
        count = 0
        for n in gr.graph[v]:
            if n not in visited:
                count += 1
    
        if v not in visited and count == 0:
            queue.append(v)
            queue.sort(reverse=True)

if len(visited) == 7:
    print(ans)
else:
    print("Cannot complete these tasks. Going to bed.")
    

