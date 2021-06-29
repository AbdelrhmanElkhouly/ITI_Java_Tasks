
public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String string1 = "abdelrhmanElkhouly" ;
		String string2 = "elsayedMostafa";
		String betterString =StringUtil.betterString(string1, string2, (s1,s2)->s1.length()>s2.length());
		System.out.println(betterString);
		
		boolean a = StringUtil.isLetter(string1,s1->{
			char[] t ;
			t = s1.toCharArray();
			
					
			for(char i : t) 
			{
			if(Character.isDigit(i)) 
			{
				return true;
			}
			
			}
			
			return false;
		
			});
		System.out.println(a);
	
	}

}
