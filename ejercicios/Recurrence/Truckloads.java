

public class Truckloads {
	public static int numTrucks(int numCrates, int loadSize) {
		if(numCrates<=loadSize) {
			return 1;
		}else {
			if(numCrates%2==0) {
				return numTrucks(numCrates/2,loadSize)+numTrucks(numCrates/2,loadSize);
			}else {
				return numTrucks(numCrates/2,loadSize)+numTrucks((int)(numCrates/2)+1,loadSize);
			}
			
		}
	}
	public static void main(String[] args) {
		System.out.println(numTrucks(18,8));

	}

}
