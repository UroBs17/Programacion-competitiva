from sys import stdin

def main():
    n=int(stdin.readline().strip())
    for case in range(n):
        nombre=stdin.readline().strip()
        equipos=int(stdin.readline().strip())
        dic={}
        dic2={}
        for j in range(equipos):
            p=stdin.readline().strip()
            dic[p.lower()]=[0,0,0,0,0,0,0]#ep,ga,gc,pj,wins,lose,ties
            dic2[p.lower()]=p
        partidos=int(stdin.readline().strip())
        for k in range(partidos):
            equa,equb=stdin.readline().strip().split('@')
            noma,gola=equa.split('#')
            golb,nomb=equb.split("#")
            gola,golb=int(gola),int(golb)
            la=dic[noma.lower()]
            lb=dic[nomb.lower()]
            la[1]+=gola
            lb[1]+=golb
            la[2]+=golb
            lb[2]+=gola
            la[3]+=1
            lb[3]+=1
            if gola==golb:
                la[0]+=1
                lb[0]+=1
                la[-1]+=1
                lb[-1]+=1
            elif gola>golb:
                la[0]+=3
                la[4]+=1
                lb[-2]+=1
            else:
                lb[0]+=3
                lb[4]+=1
                la[-2]+=1
        l=[]
        for eq in dic.keys():
            k=dic[eq]
            ep=k[0]
            wi=k[4]
            lo=k[5]
            ti=k[6]
            ga=k[1]
            gc=k[2]
            pj=k[3]
            gd=ga-gc
            l.append([-ep,-wi,-gd,-ga,pj,eq,lo,ti])
        l.sort()
        print(nombre)
        for i in range(len(l)):
            print("{}) {} {}p, {}g ({}-{}-{}), {}gd ({}-{})".format(i+1,dic2[l[i][5]],-l[i][0],l[i][4],-l[i][1],l[i][-1],l[i][-2],-l[i][2],-l[i][3],l[i][2]-l[i][3]))
        if case<n-1:
            print()
            
main()
            
