from sys import stdin
import re

def isPalindrome(line):
    for i in range(len(line)//2):
        if line[i]!=line[-i-1]:
            return False
    return True
def vertical(line):
    l=[[]]*(int(len(line)**(1/2)))
    for i in range(len(line)):
        l[i%int(len(line)**(1/2))].append(line[i])
    k=[]
    for x in l:
        for c in x:
            k.append(c)
    return k
def main():
    n=int(stdin.readline())
    for i in range(n):
        line=stdin.readline().strip()
        line = re.findall('\w', line)
        tam=len(line)
        side=int(len(line)**(1/2))
        print("Case #{}:".format(i+1))
        if side**2 != tam:
            print("No magic :(")
        elif not isPalindrome(line):
            print("No magic :(")
        elif vertical(line)[0:tam]!=line:
            print(vertical(line))
            print ("No magic :(")
        else:
            print(side)
main()
