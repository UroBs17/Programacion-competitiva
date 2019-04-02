import java.io.*;
import java.util.*;

public class XORonSegment {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		SegmentTree st=new SegmentTree(0,n);
		StringTokenizer stk=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(stk.nextToken());
			st.set(i, num);
		}
		int q=Integer.parseInt(br.readLine());
		for(int j=0;j<q;j++) {
			stk=new StringTokenizer(br.readLine());
			int querie=Integer.parseInt(stk.nextToken());
			if(querie==1) {
				int low=Integer.parseInt(stk.nextToken()),high=Integer.parseInt(stk.nextToken());
				System.out.println(st.getSum(low-1, high-1));
			}else {
				int low=Integer.parseInt(stk.nextToken())-1,high=Integer.parseInt(stk.nextToken())-1,x=Integer.parseInt(stk.nextToken());
				for(int i=low;i<=high;i++) {
					st.set(i, x^st.getSum(i, i));
				}
			}
		}
	}
	static class SegmentTree {
	    int start, end;
	    SegmentTree leftTree, rightTree;
	    int sumValue;
	
	    public SegmentTree(int start, int end) {
	        this.start = start;
	        this.end = end;
	        this.sumValue = 0;
	        if(start == end) {  // es una hoja
	            leftTree = rightTree = null;
	            return;
	        }
	        int mid = (start + end) / 2;
	        leftTree = new SegmentTree(start, mid);
	        rightTree = new SegmentTree(mid + 1, end);
	    }
	    public void set(int pos, int value) {
	        // es una hoja, CASO BASE
	        if(start == end) {
	            sumValue = value;
	            return;
	        }
	
	        int mid = (start + end) / 2;
	
	        if(pos <= mid)
	            leftTree.set(pos, value);
	        else
	            rightTree.set(pos, value);
	
	        sumValue = leftTree.sumValue+ rightTree.sumValue;
	    }
	
	    public int getSum(int low, int high) {
	        // [low,high] = [start,end]
	        if(start == low && end == high)
	            return sumValue;
	
	        int mid = (start + end) / 2;
	
	        // [low,high] totalmente incluido en [start,mid]
	        if(high <= mid)
	            return leftTree.getSum(low, high);
	
	        // [low,high] totalmente incluido en [mid+1,end]
	        if(low > mid)
	            return rightTree.getSum(low, high);
	        
	        // debemos dividir el intervalo en [low,mid] y [mid+1,high]
	        int leftMin = leftTree.getSum(low, mid);
	        int rightMin = rightTree.getSum(mid+1, high);
	        return leftMin+rightMin;
	    }
	
	}

}
