import sys
input = sys.stdin.readline
N, M = [int(i) for i in input().split()]
grid = []
dists = [[0 for i in range(M)] for j in range(N)]

for i in range(N):
    grid.append([int(j) for j in input().split("")])

def getCameraTiles():
    for i in range(N):
        for j in range(M):
            if grid[i][j] == "C":
                x = i
                y = j
                while True:
                    if x + 1 < N:
                        x += 1
                        if grid[x][y] == "W":
                            break
                        elif grid[x][y] in "LRUDS":
                            continue
                        else:
                            grid[x][y] = "w"
                x = i
                y = j
                while True:
                    if x - 1 >= 0:
                        x -= 1
                        if grid[x][y] == "W":
                            break
                        elif grid[x][y] in "LRUDS":
                            continue
                        else:
                            grid[x][y] = "w"

                x = i
                y = j
                while True:
                    if y + 1 < M:
                        if grid[x][y] == "W":
                            break
                        elif grid[x][y] in "LRUDS":
                            continue
                        else:
                            grid[x][y] = "w"


                x = i
                y = j
                while True:
                    if y - 1 > 0:
                        if grid[x][y] == "W":
                            break
                        elif grid[x][y] in "LRUDS":
                            continue
                        else:
                            grid[x][y] = "w"

getCameraTiles()

for i in range(N):
    for j in range(M):
        if grid[i][j] == "W" or grid[i][j] == "w":
            dists[i][j] = -1
        if grid[i][j] == "S":
            start = (i, j)
            dists[i][j] = 0


        
        
     



                            
