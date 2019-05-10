public static char[] T,P;
public static int[] b;
public static int n,m;
public static final int MAX = 400005;
public static void kmpPreprocess(){
       int j = -1;
       for(int i = 0; i < m; i++){
       	       if(j>=0 && P[i]==P[j]) b[i]=b[j];
	       else b[i]=j;
	       while(j>=0 && P[i]!=P[j]) j=b[j];
	       j++;
	}
}
public static int kmpSearch(){
       	int j = 0;
	int i = 0;
	int cont = 0;
	while(i < n){
		while(j>=0 && T[i]!=P[j]) j = b[j];
		i++;j++;
		if(j==m){j=b[j];return i-j}
	}
	return -1;
}
