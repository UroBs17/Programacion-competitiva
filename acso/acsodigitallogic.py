for f0 in range(2):
    for f1 in range(2):
        for a1 in range(2):
            for a0 in range(2):
                for b1 in range(2):
                    for b0 in range(2):
                        c0=0
                        c1=0
                        of=0
                        if(f0==0 and f1==0):
                            
                                
                            c0=(a0+b0)%2
                            carry=(a0+b0)//2
                            c1=(a1+b1+carry)%2
                            of=(a1+b1+carry)//2
                        if(f0==0 and f1==1):
                            v1=True if a0==1 else False
                            v2=True if a1==1 else False
                            c0=1 if not v1 else 0
                            c1=1 if not v2 else 0
                        if(f0==1 and f1==0):
                            v11=True if a0==1 else False
                            v21=True if a1==1 else False
                            v12=True if b0==1 else False
                            v22=True if b1==1 else False
                            c0=1 if v11 or v12 else 0
                            c1=1 if v21 or v22 else 0
                        if(f0==1 and f1==1):
                            v11=True if a0==1 else False
                            v21=True if a1==1 else False
                            v12=True if b0==1 else False
                            v22=True if b1==1 else False
                            c0=1 if v11 and v12 else 0
                            c1=1 if v21 and v22 else 0
                        print("| {}{} | {}{} | {}{} | {}{} | {} |".format(f0,f1,a1,a0,b1,b0,c1,c0,of))
                            

                        
                            
                            
                            
