from sys import stdin
import math
def main():
    bites=int(stdin.readline())
    n=1
    while bites:
        print("Output for data set "+str(n)+", "+str(bites)+" bytes:")
        n+=1
        archivos=0
        acumulador=0
        while bites>0:
            archivo=int(stdin.readline())
            archivos+=1
            if archivo>0:
                acumulador+=archivo
                bites-=archivo
            if archivos%5==0:
                if acumulador>0:
                    print("   Time remaining: "+str(int(math.ceil(bites*5/acumulador)))+" seconds")
                else:
                    print("   Time remaining: stalled")
                acumulador=0
        print("Total time: "+str(archivos)+" seconds")
        print()
        bites=int(stdin.readline())
main()
