package vishu.personal.practice;

import java.util.Arrays;

public class LambdaExprPractice {

	public static void main(String[] args) {
		String s = "Vishu";
		MyHello vishu = (s1) -> System.out.println("Hello " + s);
		vishu.hello(s);
		int x=3, y=7;
		int [] xyz = { 1,2,3,4,5,6,7,8,9,10 };
		MyAdd w = (a,b) -> {return a+b;};
		System.out.println(w.add(x, y));
		System.out.println(Arrays.stream(xyz)
				.sum());
		
	}

}

interface MyAdd{
	int add(int a, int b);
}
interface MyAddAll{
	int addAll(int ...abc);
}

interface MyHello{
	void hello(String name);
}

interface methodBodyTest{
	public static final int NUM = 7;
	abstract void body1(String s);
	static int body2(int x){
		return x*x;
	}
}