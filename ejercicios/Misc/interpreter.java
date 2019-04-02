import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class interpreter {
	public static DecimalFormat formatter=new DecimalFormat("000");
	public static int operacion(int i,int[] register,String[] ram) {
		String s=ram[i];
		int op=s.charAt(0)-'0';
		int op1=s.charAt(1)-'0';
		int op2=s.charAt(2)-'0';
		if (op==0 && register[op2]!=0)return register[op1];
		else if(op==1)return -1;
		else if(op==2)register[op1]=op2;
		else if(op==3)register[op1]=(register[op1]+op2)%1000;
		else if(op==4)register[op1]=(register[op1]*op2)%1000;
		else if(op==5)register[op1]=register[op2];
		else if(op==6)register[op1]=(register[op1]+register[op2])%1000;
		else if(op==7)register[op1]=(register[op1]*register[op2])%1000;
		else if(op==8)register[op1]=Integer.parseInt(ram[register[op2]]);
		else if(op==9) ram[register[op2]]=formatter.format(register[op1]);
		return i+1;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[] register;
		String[] ram;
		int n=Integer.parseInt(br.readLine());
		br.readLine();
		for (int nos=0;nos<n;nos++) {
			int number=0,ind=0,actRun=0;
			ram=new String[1000];
			register=new int[10];
			while(true) {
				String s=br.readLine();
				if(s==null || s.length()==0)break;
				ram[ind]=s;
				ind++;
			}
			while(actRun!=-1 && actRun<1000) {
				actRun=operacion(actRun,register,ram);
				number++;
			}
			System.out.println(number);
			if (nos<n-1) System.out.println();
		}
	}
}
