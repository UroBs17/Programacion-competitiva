from sys import stdin
def main():
    fuerza, dragones= [int(x) for x in stdin.readline().strip().split()]
    y = []
    for d in range(dragones):
        fuerzad , sumaf =[int(x) for x in stdin.readline().strip().split()]
        if fuerza > fuerzad:
            y.append(1)
        else:
            y.append(0)
        fuerza += sumaf
    if 0 in y:
        print("NO")
    else:
        print("YES")
main()
