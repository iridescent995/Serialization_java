# Serialization of Java Object for Hyperledger v1.3
Serialization and Deserialization in Java. Object to Byte[] Array and Byte[] Array to Object to use in:
```
putState(java.lang.String key, byte[] value)
```
instead of 

```
putStringState(java.lang.String key, java.lang.String value)
```

## Code
```
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Bytearray {

		public static void main(String[] args) {
			
			test obj = new test();
			obj.id="123";
			obj.Name="Harry";
			
			byte[] data = getbytes(obj);
			System.out.println("========");
			System.out.println(data);
			
			test obj1 = getobj(data);
			System.out.println(obj1.Name);
		}

		private static test getobj(byte[] data) {
			test obj = null;
			try {
			ByteArrayInputStream in = new ByteArrayInputStream(data);
			ObjectInputStream is = new ObjectInputStream(in);
			obj = (test) is.readObject();
			}catch(Exception e) {
				System.out.println(e);
			}
			return obj;
		}

		private static byte[] getbytes(test obj) {
			// TODO Auto-generated method stub
			byte[] data= null;
			
			try {
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos =  new ObjectOutputStream(bos);
				oos.writeObject(obj);
				data = bos.toByteArray();
				System.out.println(data);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			return data;
		}
}


class test implements Serializable{
	String id;
	String Name;
}
```
