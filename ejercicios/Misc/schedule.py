from sys import stdin
def isPossible(sch):
    assignment=[0 for i in range(len(sch))]
    assignment[sch[0][2]]="C"
    currC=[sch[0][0],sch[0][1]]
    currJ=[0,0]
    for i in range(1,len(sch)):
        act_stt,act_end=sch[i][0],sch[i][1]
        if act_stt<currJ[1] and act_stt<currC[1]:
            return "IMPOSSIBLE"
        if act_stt<currJ[1] and act_stt>=currC[1]:
            currC=[act_stt,act_end]
            assignment[sch[i][2]]="C"
        if act_stt<currC[1] and act_stt>=currJ[1]:
            currJ=[act_stt,act_end]
            assignment[sch[i][2]]="J"
        if act_stt>=currJ[1] and act_stt>=currC[1]:
            currC=[act_stt,act_end]
            assignment[sch[i][2]]="C"
    return "".join(assignment)
def main():
    t=int(stdin.readline())
    for case in range(t):
        n_act=int(stdin.readline())
        sch=[]
        for ind in range(n_act):
            stt,end=[int(x) for x in stdin.readline().strip().split()]
            sch.append([stt,end,ind])
        sch.sort()
        fl=isPossible(sch)
        print("Case #{}: {}".format(case+1,fl))
main()
