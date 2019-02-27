from sys import stdin
import re
def main():
    n=int(stdin.readline())
    blank=stdin.readline()
    for kl in range(n):
        linea=stdin.readline().strip()
        dic={}
        ascci={}
        lista=[]
        while linea:
            x=re.findall("[a-zA-z]+",linea)
            for ele in x:
                r=ele.lower()
                if r in dic:
                    dic[r]+=1
                else:
                    dic[r]=1
                    lista.append(r)
            linea=stdin.readline().strip()
        maxi=max(list(dic.values()))
        for u in dic:
            if dic[u]==maxi:
                f=0
                for hn in u:
                    f+=ord(hn)
                ascci[f]=u
        print(maxi,"occurrences")
        for t in ascci:
            print(ascci[t])
        if kl != n-1:
            print()
main()
