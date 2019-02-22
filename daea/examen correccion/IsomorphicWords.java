
public class IsomorphicWords{
	public int countPairs(String[] words){
		for(int i = 0; i < words.length; i++){
			char c = 'A';
			for(int j = 0; j < words[i].length(); j++) {
				if(words[i].charAt(j)>='a'&&words[i].charAt(j)<='z'){
					words[i] = words[i].replaceAll(""+words[i].charAt(j), ""+c);
					c++;
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < words.length; i++)for(int j = i+1; j < words.length; j++)if(words[i].equals(words[j]))ans++;
		return ans;
	}
  
  

	public static void main(String[] args)  {
		IsomorphicWords fw=new IsomorphicWords();
		String[] case1= {"abca","zbxz","opqr"};
		String[] case2= {"aa","bb","cc","ab","cd"};
		System.out.println(fw.countPairs(case1));
		System.out.println(fw.countPairs(case2));
	}
}