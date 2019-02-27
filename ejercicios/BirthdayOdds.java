public class BirthdayOdds {
	public int minPeople(int minOdds, int daysInYear) {
		int number=1;
		while (true) {
			float odd=(float) 100;
			int temp=0;
			for(int i=0;i<number;i++) {
				odd=odd*(daysInYear-temp)/(float)(daysInYear);
				temp++;
			}
			if(100-odd>minOdds) {
				return number;
			}
			number++;
			
		}
		
	}

}
