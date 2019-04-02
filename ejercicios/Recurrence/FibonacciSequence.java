

public class FibonacciSequence {

	 public static int numFibs(int a, int b) {
		 int[] l={ 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987};
		 int p=0;
		 for(Integer k:l) {
			 if(k>=a && k<=b) {
				 p++;
			 }
		 }
		 return p;
	 }

}
