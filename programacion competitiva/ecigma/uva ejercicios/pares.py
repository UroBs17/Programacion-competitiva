from sys import stdin
def par(a):
    if a %2 == 0:
        return a
    else:
        return "No"
def main():
    a = [int(x) for x in stdin.readline().strip().split()]
    y = []
    for i in a:
        x = par(i)
        y.append(x)
    while "No" in y:
        y.remove("No")
    numImpar = len(a)-len(y)
    numPar = len(y)
    print(numImpar, numPar)
main()
