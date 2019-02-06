from sys import stdin

def main():
    setA=set()
    lit=list()
    n=1
    v=True
    while True:
        line=stdin.readline().strip()
        if len(line)==0:break
        if line=="9":
            for cad in lit:
                if cad in setA or lit.count(cad)>1:
                    v=False
                    break
            if v:
                print("Set "+str(n)+" is immediately decodable")
            else:
                print("Set "+str(n)+" is not immediately decodable")
            v=True
            setA=set()
            lit=list()
            n+=1
        else:
            pre=""
            for i in range(len(line)-1):
                pre+=line[i]
                setA.add(pre)
            lit.append(line)
main()
