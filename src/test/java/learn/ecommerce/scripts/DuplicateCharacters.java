package learn.ecommerce.scripts;

public class DuplicateCharacters {

	public static void main(String[] args) {
		String name="Naveen Kumar";
		char[] ch=name.toLowerCase().toCharArray();
		
		for(int i=0;i<=ch.length-1;i++) {
			for(int j=i+1;j<ch.length;j++) {
				if(ch[i]==ch[j]) {
				System.out.println(ch[i]);
				}
			}
		}

	}

}
