package vishu.personal.practice;

import java.util.HashMap;
import java.util.Iterator;

public final class ImmutableClassExample {
	private int id;
	private String name;
	private HashMap<Integer, String> map;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<Integer, String> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, String> map) {
		this.map = map;
	}

	public ImmutableClassExample(int id, String name, HashMap<Integer, String> hmap) {
		System.out.println("Constructor with Deep Copy");
		this.id = id;
		this.name = name;
		HashMap<Integer, String> tmap = new HashMap<>();
		Iterator<Integer> it = hmap.keySet().iterator();
		int k;
		while (it.hasNext()) {
			k = it.next();
			tmap.put(k, hmap.get(k));
		}
		this.map = tmap;
	}

	// public ImmutableClassExample(int id, String name, HashMap<Integer,
	// String> hmap) {
	// System.out.println("Constructor with Shallow copy");
	// this.id = id;
	// this.name = name;
	// this.map = hmap;
	// }

	public static void main(String[] args) {
		HashMap<Integer, String> tmap = new HashMap<>();
		tmap.put(1, "Vishu");
		tmap.put(2, "VKK");
		int i = 10;
		String s = "hahaha";

		ImmutableClassExample ice = new ImmutableClassExample(i, s, tmap);
		System.out.println("s == ice.getName() :: " + (s == ice.getName()));
		System.out.println("tmap == ice.getMap() :: " + (tmap == ice.getMap()));

		System.out.println(ice.getId());
		System.out.println(ice.getName());
		System.out.println(ice.getMap());

		i = 20;
		s = "modified";
		tmap.put(3, "third");
		// print the values again
		System.out.println("ce id after local variable change:" + ice.getId());
		System.out.println("ce name after local variable change:" + ice.getName());
		System.out.println("ce testMap after local variable change:" + ice.getMap());

		HashMap<Integer, String> hmTest = ice.getMap();
		hmTest.put(4, "new");

		System.out.println("ce testMap after changing variable from accessor methods:" + ice.getMap());
	}
}
