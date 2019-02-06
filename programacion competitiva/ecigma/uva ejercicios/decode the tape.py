from sys import stdin

def main():
    stdin.readline()
    l=""
    while True:
        k=stdin.readline().strip()
        if k[0]=="_":break
        k=k.replace("|","")
        k=k.replace(".","")
        k=k.replace(" ","0")
        k=k.replace("o","1")
        k="0b"+k
        l+=chr(int(k,2))
    print(l)
main()
