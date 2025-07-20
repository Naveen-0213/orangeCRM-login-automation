package learn.ecommerce.scripts;

import java.util.Arrays;

public class PhotoCode {

	public static void main(String[] args) {
		//input = {0,0,0,0,1,1}
		//Output={0,1,1,0,0,0}
		int count=0;
		int[] input= {0,0,0,0,1,1};
		int[]  output=new int[input.length];
		
		for(int i=0;i<=input.length-1;i++) {
			if(input[i]==1) {
				count++;
			}
		}
		
		if(count>=2) {
			output[1]= 1;
		}
		if(count>1) {
			output[2]=1;
		}
		
		System.out.println(Arrays.toString(output));
		
	}

}
