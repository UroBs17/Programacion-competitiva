import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CNTPRIME_spoj {
	public static class SegmentTree {
		int size;
		private int[] sum;
		private int[] lazy;
		public SegmentTree(int[] array){
			size = array.length;
			sum=new int[array.length*4];
			lazy=new int[array.length*4];
			buildTree(array,1,0,size-1);
		}
		private void buildTree(int[] array, int position, int front, int end){
			//Basis case for returning the elements itself
			if(front==end){
				sum[position]=array[front];
				return;
			}
			//Building trees by dividing into two subtrees
			buildTree(array, position*2,front,(front+end)/2);
			buildTree(array, position*2+1,(front+end)/2+1,end);
			sum[position]=getSum(position*2,front,(front+end)/2)+getSum(position*2+1,(front+end)/2+1,end);
		}
		private int getSum(int position,int front,int end){
			return sum[position]+lazy[position]*(end-front+1);
		}
		public int querySum(int queryFront, int queryEnd) {
			return querySum(1,0,size-1,queryFront,queryEnd);
		}
		private int querySum(int position,int front,int end, int queryFront, int queryEnd){
			//Case for entirely inclusive
			if(front>=queryFront&&queryEnd>=end){
				return getSum(position,front,end);
			}
			//Case for entirely exclusive
			if(end<queryFront||queryEnd<front){
				return 0;
			}
			propagate(position,front,end);
			int leftAns=querySum(position*2,front,(front+end)/2,queryFront,queryEnd);
			int rightAns=querySum(position*2+1,(front+end)/2+1,end,queryFront,queryEnd);
			return leftAns+rightAns;
		}
		private void propagate(int position,int front, int end){
			lazy[position*2]+=lazy[position];
			lazy[position*2+1]+=lazy[position];
			sum[position]=getSum(position,front,end);
			lazy[position]=0;
			//Set the propagation to 0 so that it will not propagate the value again and again
		}
		public void update(int updateFront, int updateEnd, int value){
			update(1,0,size-1,updateFront,updateEnd,value);
		}
		private void update(int position, int front, int end, int updateFront,int updateEnd,int value){
			//Case for entirely inclusive
			if(front>=updateFront&&updateEnd>=end){
				lazy[position]+=value;
				return;
			}
			//Case for entirely exclusive
			if(end<updateFront||updateEnd<front){
				return;
			}
			propagate(position,front,end);
			update(position*2,front,(front+end)/2,updateFront,updateEnd,value);
			update(position*2+1,(front+end)/2+1,end,updateFront,updateEnd,value);
			sum[position]=getSum(position*2,front,(front+end)/2)+getSum(position*2+1,(front+end)/2+1,end);
		}
	}
	public static boolean[] isPrime;
	public static int N=1000010;
	public static void sieve() {
		isPrime=new boolean[N];
		for(int i=2;i<N;i++)isPrime[i]=true;
		for(long i=2;i<N;i++) {
			if(isPrime[(int)i]) {
				for(long j=i*i;j<N;j+=i) {
					isPrime[(int)j]=false;
				}
			}
		}			
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		sieve();
		int cases=Integer.parseInt(br.readLine());
		for(int c=1;c<=cases;c++) {
			StringTokenizer stk=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(stk.nextToken()),q=Integer.parseInt(stk.nextToken());
			stk=new StringTokenizer(br.readLine());
			int[] arr=new int[n];
			for(int i=0;i<n;i++)arr[i]=(isPrime[Integer.parseInt(stk.nextToken())])?1:0;
			SegmentTree st=new SegmentTree(arr);
			System.out.println("Case "+c+":");
			for(int qr=0;qr<q;qr++) {
				stk=new StringTokenizer(br.readLine());
				int cm=Integer.parseInt(stk.nextToken());
				if(cm==0) {
					int x=Integer.parseInt(stk.nextToken()),y=Integer.parseInt(stk.nextToken()),v=(isPrime[Integer.parseInt(stk.nextToken())]?1:0);
					st.update(x-1,y-1, v);
				}else {
					int x=Integer.parseInt(stk.nextToken()),y=Integer.parseInt(stk.nextToken());
					System.out.println(st.querySum(x-1, y-1));
				}
			}
		}
	}
}
