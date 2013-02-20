import java.util.ArrayList;
import java.util.regex.Pattern;


public class StringCalc {

	public int add(String string) throws NegativeNumberException {
		if(string == "") {
			return 0;
		} else {
			if(string.startsWith("//")) {
				string = string.substring(4,string.length());
			}
			String[] temp = string.split("[^-0-9]");
			int sum = 0;
			
			for(int i = 0 ; i < temp.length ; i++) {
				sum += Integer.parseInt(temp[i]);
			}
			return sum;
		}
	}

}
