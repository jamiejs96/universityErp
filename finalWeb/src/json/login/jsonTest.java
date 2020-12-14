package json.login;

import org.json.JSONObject;

public class jsonTest {
public static void main(String[] args) {
	
	JSONObject a = new JSONObject();
	a.put("a", 3);
	a.put("b","아아");
	
	JSONObject b = new JSONObject();
	b.put("a", 4);
	b.put("b","으악");
	
	
	JSONObject json = new JSONObject();
	json.put("ㄱ", a);
	json.put("ㄴ", b);
	

	
	System.out.println(json.toString());
	System.out.println(json);
	
	
	
}
}

class JSONTT{
	int a;
	String b;
	public JSONTT() {
		
	}
	public JSONTT(int a, String b) {
		this.a = a;
		this.b = b;
	}
	
	
}
