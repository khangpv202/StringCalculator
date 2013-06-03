package StringCalculator.Qsoft_Calculator2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public int add(String string) {
		// TODO Auto-generated method stub
		int result = 0;
		String regex = "";
		if(!string.isEmpty()){
			if(string.contains("//")){
				regex = "\\d+";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(string);
				while(m.find()){
					if(Integer.parseInt(string.substring(m.start(), m.end()))<0)
						throw new IllegalArgumentException("negatives not allowed");
					if(Integer.parseInt(string.substring(m.start(), m.end()))<=1000)
							result+=Integer.parseInt(string.substring(m.start(), m.end()));
				}
				
			}else{
				regex = "[,;\n]";
				String []tmp= string.split(regex);
				for(String i:tmp){
					if(Integer.parseInt(i)<0)
						throw new IllegalArgumentException("negatives not allowed");
					if(Integer.parseInt(i)<=1000)
						result+=Integer.parseInt(i);
				}
			}
			return result;
		}
		else return 0;
	}

}
