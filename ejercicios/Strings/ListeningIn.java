
public class ListeningIn {
	public String probableMatch(String typed, String phrase) {
		if (typed.length() > phrase.length()) return "UNMATCHED";
		String k="";
		int i=0;
		for (int j=0;j<phrase.length();j++){
			if (i < typed.length() && typed.charAt(i) == phrase.charAt(j))i++;
            else k += phrase.charAt(j);
		}
		return i==typed.length()?k:"UNMATCHED";
	}
}
