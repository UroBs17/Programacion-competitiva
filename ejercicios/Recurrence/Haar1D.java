import java.util.ArrayList;


public class Haar1D {
	public int[] transform(int[] data, int L) {
		int n=data.length;
		return f(data,L,n,n);
	}
	public int[] f(int[] arr,int times,int n,int nE) {
		if(times==0)return arr;
		ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i=0;i<n;i+=2) {
			a.add(arr[i]+arr[i+1]);
		}
		for(int i=0;i<n;i+=2) {
			a.add(arr[i]-arr[i+1]);
		}
		int[] temp=new int[nE];
		for(int i=0;i<a.size();i++) {
			temp[i]=a.get(i);
		}
		for(int i=a.size();i<nE;i++) {
			temp[i]=arr[i];
		}
		return f(temp,times-1,(int)n/2, nE);
	}

}
