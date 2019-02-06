dic={"A":"A","E":"3","H":"H","I":"I","J":"L","L":"J","M":"M","O":"O","S":"2","T":"T","U":"U","V":"V","W":"W","X":"X","Y":"Y","Z":"5","1":"1","2":"S","3":"E","5":"Z","8":"8"}
def isPalindrome(word):
    wordL=list(word)
    for i in range(len(word)//2):
        if wordL[i]!=wordL[-i-1]:
            return False
    return True
def isMirrored(word):
    wordL=list(word)
    mirrL=list()
    for i in range(len(word)):
        if wordL[i] in dic:
            mirrL.append(dic[wordL[i]])
        else:
            return False
    mirrL=mirrL[::-1]
    return wordL==mirrL
def main():
    while True:
        word=stdin.readline().strip()
        if len(word)==0:break
        palin=isPalindrome(word)
        mirro=isMirrored(word)
        if not palin and not mirro:
            print(word+" -- is not a palindrome.")
        elif not palin and mirro:
            print(word+" -- is a mirrored string.")
        elif palin and not mirro:
            print(word+" -- is a regular palindrome.")
        elif palin and mirro:
            print(word+" -- is a mirrored palindrome.")
        print()
main()
