import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;


public class jsonjava {

	public static void main(String[] args) {
		customer cus1 = new customer();
		cus1.id = "2";
		cus1.name = "Harry";
		address add =  new address();
		add.lane = "wdfg";
		add.pincode = "2345";
		cus1.map.put("home", add);
		
		Gson gson = new Gson();
		System.out.println(cus1);
		String json = gson.toJson(cus1);
		
		System.out.println(json);
		
		customer cus2 = gson.fromJson(json, customer.class);
		System.out.println(cus2);
		System.out.println(cus2.map.get("home"));
		
		String json2 = gson.toJson(cus2.map.get("home"));
		
		address add2 = gson.fromJson(json2, address.class) ;
		System.out.println(add2.lane);
		
		
		
	}

}

class customer{
	String id;
	String name;
	Map<String, Object> map = new HashMap<String, Object>();
	
}

class address{
	String lane;
	String pincode;
}