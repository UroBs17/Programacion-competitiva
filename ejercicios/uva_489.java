import java.io.*;
import java.util.*;
public class uva_489 {

	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int round=Integer.parseInt(br.readLine()),error=0;
			if(round==-1)break;
			boolean h=true;
			String word=br.readLine(),Wtry=br.readLine();
			Set<Character> set=new HashSet<Character>();
			Set<Character> guess=new HashSet<Character>();
			System.out.println("Round "+round);
			for(Character ch:word.toCharArray()) {
				set.add(ch);
			}
			for(Character ch:Wtry.toCharArray()) {
				boolean alreadyGuessed = guess.add(ch);
				if (!alreadyGuessed)continue;
				if(set.contains(ch)) {
					set.remove(ch);
					if(set.isEmpty()) {
						System.out.println("You win.");
						h=false;
						break;
					}
				}else {
					error++;
					if(error==7) {
						System.out.println("You lose.");
						h=false;
						break;
					}
				}
				
			}
			if(h) {
				System.out.println("You chickened out.");
			}
			
			
		}
	}

}
