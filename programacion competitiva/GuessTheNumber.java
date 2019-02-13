public class GuessTheNumber {
	public int noGuesses(int upper, int answer) {
		int tries=0,lower=1;
		while (true) {
			int middle=(upper+lower)/2;
			if (middle==answer) {
				tries++;
				break;
			}else if(middle<answer) {
				lower=middle+1;
			}else {
				upper=middle-1;
			}
			tries++;
		}
		return tries;
	}

}
