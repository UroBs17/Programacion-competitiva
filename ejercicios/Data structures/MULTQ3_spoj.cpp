#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef int64_t   ll;
typedef pair<int,int> ii;

#define EL printf("\n")
#define pb push_back
#define mp make_pair
#define X  first
#define Y  second

const int N = 1e5+1;
int n, q, lazy[4*N];
ii  t[4*N], nil;

void lazy_update(int k, int l, int r) {
    lazy[k] %= 3;
    int s0 = t[k].X;
    int s1 = t[k].Y;
    int s2 = (r-l+1)-s0-s1;
    if (lazy[k] == 0) return ;
    if (lazy[k] == 1) {
        t[k].X = s2;
        t[k].Y = s0;
    }
    else {
        t[k].X = s1;
        t[k].Y = s2;
    }
    if (l < r) {
        lazy[k*2] += lazy[k];
        lazy[k*2+1] += lazy[k];
    }
    lazy[k] = 0;
}

ii combine(ii u, ii v) {
    ii ans;
    ans.X = u.X + v.X;
    ans.Y = u.Y + v.Y;
    return ans;
}

void build(int k, int l, int r) {
    if (l == r) {
        t[k] = mp(1,0);
        return ;
    }
    int mid = (l+r)>>1;
    build(k*2,l,mid);
    build(k*2+1,mid+1,r);
    t[k] = combine(t[k*2], t[k*2+1]);
}

void update(int k, int l, int r, int L, int R) {
    lazy_update(k,l,r);
    if (r < L or R < l) return ;
    if (L <= l and r <= R) {
        lazy[k]++;
        lazy_update(k,l,r);
        return ;
    }
    int mid = (l+r)>>1;
    update(k*2,l,mid,L,R);
    update(k*2+1,mid+1,r,L,R);
    t[k] = combine(t[k*2], t[k*2+1]);
}

ii get(int k, int l, int r, int L, int R) {
    lazy_update(k,l,r);
    if (r < L or R < l) return nil;
    if (l == L and r == R) return t[k];
    int mid = (l+r)>>1;
    if (mid < L) return get(k*2+1,mid+1,r,L,R);
    if (R < mid+1) return get(k*2,l,mid,L,R);
    return
        combine(
            get(k*2,l,mid,L,mid),
            get(k*2+1,mid+1,r,mid+1,R)
        );
}

int main()
{
    //freopen("INP.INP","r",stdin);
    //freopen("OUT.OUT","w",stdout);

    scanf("%d%d\n", &n,&q);
    nil = mp(0,0);
    build(1,1,n);
    while (q--) {
        int type, l, r;
        scanf("%d%d%d\n", &type, &l, &r);
        l++; r++;
        if (type == 0) update(1,1,n,l,r);
        else printf("%d\n", get(1,1,n,l,r).X);
    }

    return 0;
}
