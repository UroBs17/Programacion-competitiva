a = int(input("#"))
b = int(input("#2"))

def pro(x,y):
    if y != 0 and x != 0:
        return pro(x, y-1)+x
    else:
        return 0
def main():
    k= pro(a,b)
    print(k)
main()
