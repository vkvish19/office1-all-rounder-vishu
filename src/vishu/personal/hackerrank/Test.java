package vishu.personal.hackerrank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Vishu");
		map.put(2, "VKK");
		map.put(3, "VKulkarni");
		
		Set<Entry<Integer, String>> set = map.entrySet();
		
		Iterator<Entry<Integer, String>> i = set.iterator();
		
		while(i.hasNext()){
			Map.Entry<Integer, String> m = i.next();
			System.out.println("ID:" +m.getKey() + " --> Name:" +m.getValue());
		}
	}
}
