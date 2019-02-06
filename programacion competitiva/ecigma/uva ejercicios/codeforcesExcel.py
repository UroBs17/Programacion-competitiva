from sys import stdin
def ExcelToNum(crd):
    num=ord(crd[0])-63
    print(num)
    crd=crd[::-1]
    for i in range(1,len(crd)):
        num+=((ord(crd[i])-64)*(26*i))
    return num
def NumToExcel(num):
    cad=""
    while num>0:
        c=(num%26)
        cad+=chr(c+64)
        num=num//26
    return cad[::-1]

def main():
    n=int(stdin.readline())
    for i in range(n):
        line=stdin.readline().strip()
        if line[0]=="R":
            num=int(line.split("C")[-1])
            cad=NumToExcel(num)
            print(cad+line.split("C")[0][1:])
        else:
            cad=""
            k=""
            for x in line:
                if x in "0123456789":
                    k+=x
                else:
                    cad+=x
            num=ExcelToNum(cad)
            print("R"+k+"C"+str(num))
main()
