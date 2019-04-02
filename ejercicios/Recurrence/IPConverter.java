import java.util.*;
public class IPConverter {

	
	public String[] possibleAddresses(String ambiguousIP) {
		if( ambiguousIP.length()>12 ||  ambiguousIP.length()<4) return new String[0];
		int n=ambiguousIP.length();
		ArrayList<String> arr=new ArrayList<String>();
		for(int i=1;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					String oByte,sByte,tByte,fByte;
					oByte=ambiguousIP.substring(0, i);
					sByte=ambiguousIP.substring(i, j);
					tByte=ambiguousIP.substring(j, k);
					fByte=ambiguousIP.substring(k);
					if(isValid(oByte,sByte,tByte,fByte)){
						arr.add(oByte+"."+sByte+"."+tByte+"."+fByte);
					}
				}
			}
		}
		String[] list=(String[])arr.toArray(new String[0]);
		Arrays.sort(list);
		
		return list;
	}
	public boolean isValid(String oByte, String sByte,String tByte,String fByte) {
		return isValidUnit(oByte)&&isValidUnit(sByte)&&isValidUnit(tByte)&&isValidUnit(fByte);
	}
	public boolean isValidUnit(String s) {
		if (s.length() > 3) {
			return false ;
		}
		if (s.length() < 1) {
			return false ;
		}
		if (s.charAt(0) == '0' && s.length() > 1) {
			return false ;
		}
		int i = new Integer(s).intValue() ;
		if (i > 255) {
			return false ;
		}
		return true ;
	}
	/*public static void main(String[] args) {
		IPConverter ic=new IPConverter();
		System.out.println(Arrays.toString(ic.possibleAddresses("11111111")));

	}*/
}
