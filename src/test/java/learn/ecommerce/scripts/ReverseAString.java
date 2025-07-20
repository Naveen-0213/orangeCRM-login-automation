package learn.ecommerce.scripts;

public class ReverseAString {

	public static void main(String[] args) {
		String name="Naveen";
		String reversed="";
		char[] ch=name.toLowerCase().toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
			reversed=reversed+ch[i];
		}
		System.out.println(reversed);
		
	}

}
