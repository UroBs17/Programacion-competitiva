from sys import stdin

def main():
    n=int(stdin.readline())
    for i in range(n):
        lineA=stdin.readline().strip().split("<")
        lineB=stdin.readline().strip()
        secondA=lineA[1].split(">")
        thirdA=lineA[2].split(">")
        s1=lineA[0]
        s2=secondA[0]
        s3=secondA[1]
        s4=thirdA[0]
        s5=thirdA[1]
        lineB=lineB[:-3]
        print(s1+s2+s3+s4+s5)
        print(lineB+s4+s3+s2+s5)
main()
