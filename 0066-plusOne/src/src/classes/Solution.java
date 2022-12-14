package src.classes;

import java.util.Arrays;

public class Solution {
	public int[] plusOne(int[] digits) {		
		if(digits.length==1) {
			if(digits[0]==9) {
				digits = new int[] {1,0};
			}
			else {
				digits[0] += 1;
			}
			return digits;
		}
		
		//starting reading from right to left
        for(int i=digits.length-1;i>0;i--){
            int current = digits[i];
            if(current!=9) { //simple increment
                current++;
                digits[i] = current;
                return digits;
            }else { //case in which the current digit become 9 --> 0
                // i need to change the next (i-1) incrementing its value of 1
                // if the value i-1 is again 9, then move to i-2 and so on
                current = 0; //9+1
                digits[i] = current;

                //changed the first 9, now i need to check all the possible others
                do {
                    //check if digits i-1 is 9
                    if (digits[i - 1] == 9) { // 9 --> 0
                        digits[i - 1] = 0;
                        i--;            // to the next element, cycling
                        
                        //if it is the first number
                        if(i==0) { // increasing the array size
                        	int[] digitsAux = Arrays.copyOf(digits,digits.length+1);
                        	digitsAux[0]= 1;
                        	
                            digits=digitsAux;
                        }
                    } else { //we are done
                        digits[i - 1] += 1;
                        return digits;
                    }

                } while (i>0); //skipping the first digit
            }
        }

        return digits;
    }
}
