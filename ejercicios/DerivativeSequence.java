



public class DerivativeSequence {
	public static int[] derSeq(int[] a, int n) {
		for(int i=0;i<n;i++) {
			int[] b=new int[a.length-1];
			for(int j=0;j<a.length-1;j++) {
				b[j]=a[j+1]-a[j];
			}
			a=b;
		}
		return a;
	}
}
