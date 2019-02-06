from sys import stdin
def main():
    exp=stdin.readline().strip()
    while exp:
        g=eval(exp)
        print("%.3f"%float(g))
        exp=stdin.readline().strip()
main()
