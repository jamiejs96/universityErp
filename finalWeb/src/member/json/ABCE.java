package member.json;

import java.util.Arrays;
import java.util.Comparator;

public class ABCE {
public static void main(String[] args) {
//	String[] strings = {"sun","bed","car"};
	String[] strings = {"abcdefghi","cax","abcdefghh"};
	int num = 1;
	ComCom.num=num;
	Arrays.sort(strings,new ComCom());
	System.out.println(Arrays.toString(strings));

}
}

class ComCom implements Comparator<String>{
	public static int num = 0;
	boolean first = true;
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public int compare(String o1, String o2) {
		char left= o1.charAt(num);
		char right=o2.charAt(num);
		int result =0;
		
		if(left==right) {
			return o1.compareTo(o2);
		}
		else if(left > right){
			result = 1;
		}
		else {
			result = -1;
		}
		return result;
	}
}
