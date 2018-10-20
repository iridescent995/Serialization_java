import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class VersionUid2 {
	
public static void main(String[] args) {
		
		test obj = new test();
//		obj.id="123";
//		obj.Name="Harry";
//		
//		obj.getbytes(obj);
		System.out.println("========");
		//System.out.println(data);
		
		test obj1 = obj.getobj();
		System.out.println(obj1.id);
	}


}


class test implements Serializable{
	
static final long serialVersionUID = 1L;
String id;
String Name;
String address;

	//Convert byte array to test
		test getobj() {
			test obj = null;
			try {
			FileInputStream filein = new FileInputStream("Obj.prop");
			ObjectInputStream is = new ObjectInputStream(filein);
			obj = (test) is.readObject();
			is.close();
			filein.close();
			System.out.println(obj.address);
			}catch(Exception e) {
				System.out.println(e);
			}
			return obj;
		}

//	//convert object to bye	
//		void getbytes(test obj) {
//			//byte[] data= null;
//			try {
//				
//				FileOutputStream file = new FileOutputStream("Obj.prop");
//				ObjectOutputStream oos =  new ObjectOutputStream(file);
//				oos.writeObject(obj);
//				oos.close();
//				file.close();
//				System.out.println("written in obj.prop file");
//			}catch(Exception e) {
//				System.out.println(e);
//			}
//			
//			
//		}


}