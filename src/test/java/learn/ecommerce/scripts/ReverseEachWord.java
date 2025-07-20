package learn.ecommerce.scripts;

public class ReverseEachWord {

	public static void main(String[] args) {
		String str="My Name is Naveen kumar";
		
		String[] arr=str.split(" ");
		for(String s:arr) {
			
			char[] ch=s.toCharArray();
			for(int i=ch.length-1;i>=0;i--) {
				System.out.print(ch[i]);
			}
			System.out.print(" ");
		}

	}

}
