from collections import defaultdict

complete = False

class Graph:
    def __init__(self):
        self.graph = defaultdict(list)

    def addEdge(self, u, v):
        self.graph[u].append(v)

    def removeEdge(self, u, v):
        self.graph[u].pop(self.graph[u].index(v))

    def DFSUtil(self, v, visited):
        global complete
        visited[v] = True
        if v == "B":
            complete = True
            
        for i in self.graph[v]:
            if visited[i] == False:
                self.DFSUtil(i, visited)
            
        
    def DFS(self, v):
        global complete
        complete = False
        visited = defaultdict(bool)
        self.DFSUtil(v, visited)
        return complete


g = Graph()
        
while True:
    s = input()
    if s == "**":
        break
    g.addEdge(s[0], s[1])
    g.addEdge(s[1], s[0])

ans = []
    
for road in g.graph:
    for connection in g.graph[road]:
        if road + connection not in ans and connection + road not in ans:
            g.removeEdge(connection, road)
            g.removeEdge(road, connection)
            if "A" in g.graph and not g.DFS("A"):
                ans.append(road+connection)

            g.addEdge(connection, road)
            g.addEdge(road, connection)


for road in ans:
    print(road)

print("There are " + str(len(ans)) + " disconnecting roads.")

        
