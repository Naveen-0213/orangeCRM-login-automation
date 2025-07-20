package learn.ecommerce.scripts;

public class ReverseString {

	public static void main(String[] args) {
		String name="naveen";
		//output: navnee
		
		String res=name.substring(3);
		String ini=name.substring(0, 3);
		
		char[] ch=res.toCharArray();
		String rev="";
		for(int i=ch.length-1;i>=0;i--) {
			rev=rev+ch[i];
		}
		
		
		System.out.println(ini+rev);
		
		
		
		
		

	}

}
