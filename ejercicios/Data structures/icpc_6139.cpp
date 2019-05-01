#include<bits/stdc++.h>
using namespace std;
struct SegmentTree {
    int start, end;
    SegmentTree *leftTree, *rightTree;
    int rValue;

    SegmentTree(int start, int end) {
        this->start = start;
        this->end = end;
        this->rValue = 1;
        if(start == end) {  // es una hoja
            leftTree = rightTree = NULL;
            return;
        }
        int mid = (start + end) / 2;
        leftTree = new SegmentTree(start, mid);
        rightTree = new SegmentTree(mid + 1, end);
    }

    void set(int pos, int value) {
        // es una hoja, CASO BASE
        if(start == end) {
            rValue = value;
            return;
        }
        int mid = (start + end) / 2;
        if(pos <= mid) leftTree->set(pos, value);
        else rightTree->set(pos, value);
        rValue =(leftTree->rValue * rightTree->rValue);
    }

    int getMin(int low, int high) {
        // [low,high] = [start,end]
        if(start == low && end == high)return rValue;
        int mid = (start + end) / 2;
        // [low,high] totalmente incluido en [start,mid]
        if(high <= mid)return leftTree->getMin(low, high);
        // [low,high] totalmente incluido en [mid+1,end]
        if(low > mid) return rightTree->getMin(low, high);
        // debemos dividir el intervalo en [low,mid] y [mid+1,high]
        int leftV = leftTree->getMin(low, mid);
        int rightV = rightTree->getMin(mid+1, high);
        return leftV*rightV;
    }

};

int main() {
	int n,q;
	//freopen("in.txt","r",stdin);
    //freopen("out.txt","w",stdout);
	while(scanf("%d %d",&n,&q)!= EOF){
		SegmentTree st(0,n-1);
		int v;
		for(int i=0;i<n;i++){
			scanf("%d",&v);
			if(v==0)st.set(i,0);
			else if (v<0) st.set(i,-1);
			else st.set(i,1);
		}
		char cmd[3];
		int v1,v2;
		while(q--){
			scanf("%s %d %d",cmd,&v1,&v2);
			if(cmd[0]=='C'){
				if(v2==0)st.set(v1-1,0);
				else if (v2<0)st.set(v1-1,-1);
				else st.set(v1-1,1);
			}else{
				int ans=st.getMin(v1-1,v2-1);
				if ( ans == 1 ) printf ("+");
                else if ( ans == -1 ) printf ("-");
                else printf ("0");
			}
		}
		printf("\n");
	}
    return 0;
}
