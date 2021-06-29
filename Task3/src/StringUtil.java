
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
public class StringUtil {

	public static boolean isLetter(String s ,Predicate<String> p) 
	{
	
		if(p.test(s)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public static String betterString(String s1 , String s2 , BiPredicate<String , String> bp) 
	{
		
		if(bp.test(s1 , s2)) 
		{
			return s1;
		}
		else 
		{
			return s2 ;
		}
			
		
	}
	
	
	
	
	
}
