package learn.ecommerce.scripts;

public class findVowelsConsonants {

	public static void main(String[] args) {
		String name="Naveen Kumar$";
		//String updated=name.replaceAll(" ", ""); 
		String updated=name.replaceAll("[^a-zA-Z0-9]", "");
		char[] ch=updated.toLowerCase().toCharArray();
		StringBuilder sb=new StringBuilder();
		StringBuilder sbTwo=new StringBuilder();
		for(Character c:ch) {
			//boolean alphabetic = Character.isAlphabetic(c);
			//boolean digit = Character.isDigit(c);
			switch(c) {
			  	case 'a':
			  	case 'e':
			  	case 'i':
			  	case 'o':
			  	case 'u':
			  		//System.out.println("vowel "+c);
			  		sb.append(c);
			  		break;
			  	default:
			  		//System.out.println("Consonants "+c);
			  		sbTwo.append(c);
			}
			
		}
		
		System.out.println("The Vowels are: "+sb.toString());
		System.out.println("The Consonants are: "+sbTwo.toString());
		
	}

}
