package learn.ecommerce.scripts;

public class SumOnlyIntegers {

	public static void main(String[] args) {
		String[] str= {"a","12","b","c","13","14","qqq"};
		int sum=0;
		for(String ele:str) {
			try {
				int num=Integer.parseInt(ele);
				sum=sum+num;
			}catch(Exception e){
				//e.printStackTrace();
			}
		}
		System.out.println("Sum of Integers : "+sum);
	}

}
