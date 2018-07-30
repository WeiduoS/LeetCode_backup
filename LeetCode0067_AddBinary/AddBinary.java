package LeetCode0067_AddBinary;

public class AddBinary {
	 public String addBinary(String a, String b) {
	        StringBuilder sb = new StringBuilder();
	        int i = a.length() - 1;
	        int j = b.length() - 1;
	        int carry = 0;
	        
	        //System.out.println("i: " + i + ", j: " + j);

	        while(i >= 0 && j >= 0){
	            //int sum = Character.getNumericValue(a.charAt(i)) +  Character.getNumericValue(b.charAt(j)) + carry;
	            int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
	            if( sum == 2){
	                //System.out.println("a.charAt(i): " + a.charAt(i) + ", b.charAt(j): " + b.charAt(j));
	                sb.insert(0, 0);
	                carry = 1;
	            }else if(sum == 3){
	                sb.insert(0, 1);
	                carry = 1;
	            }else if(sum < 2){
	                sb.insert(0, sum);
	                carry = 0;
	            }
	            i--;
	            j--;
	        }
	        
	        if(i > j){
	            while(i >= 0){
	                //int sum = Character.getNumericValue(a.charAt(i)) + carry;
	                int sum = a.charAt(i) - '0' + carry;
	                if(sum == 2){
	                    sb.insert(0, 0);
	                    carry = 1;
	                }
	                else{
	                    sb.insert(0, sum);
	                    carry = 0;
	                }
	                i--;
	            }
	        }
	        
	        if(j > i){
	            while(j >= 0){
	                //int sum = Character.getNumericValue(b.charAt(j)) + carry;
	                int sum = b.charAt(j) - '0' + carry;
	                if(sum == 2){
	                    sb.insert(0, 0);
	                    carry = 1;
	                }
	                else{
	                    sb.insert(0, sum);
	                    carry = 0;
	                }
	                j--;
	            }
	        }
	        
	        if(carry == 1 ){
	            //System.out.println("sb.length(): " + sb.length() );
	            sb.insert(0, 1);
	        }
	        
	        return sb.toString();
	    }
}