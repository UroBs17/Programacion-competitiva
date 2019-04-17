public class longestPalindromeSubstring {
	public static String convertToNewString(String s) {
	    String newString = "@";
	    for (int i = 0; i < s.length(); i++)newString += "#" + s.charAt(i);
	    return newString+"#$";
	}
	public static String lps(String s) {
	    char[] Q = convertToNewString(s).toCharArray();
	    int P[]=new int[Q.length*2];
	    int c = 0, r = 0;
	    for (int i = 1; i < Q.length- 1; i++) {
	        int iMirror = c - (i - c);
	        if(r > i) P[i] = Math.min(r - i, P[iMirror]);
	        while (Q[i + 1 + P[i]] == Q[i - 1 - P[i]]) P[i]++;
	        if (i + P[i] > r) {
	            c = i;
	            r = i + P[i];
	        }
	    }
	    int maxPalindrome = 0;
	    int centerIndex = 0;
	    for (int i = 1; i < Q.length - 1; i++) {
	        if (P[i] > maxPalindrome) {
	            maxPalindrome = P[i];
	            centerIndex = i;
	        }
	    }
	    return s.substring((centerIndex - 1 - maxPalindrome) / 2, ((centerIndex - 1 + maxPalindrome) / 2));
	}
}
