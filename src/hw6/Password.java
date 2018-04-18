package hw6;
/**
* Janiel Reyes
* 111307845
* HW # 6 
* Section 12
* Charles Chen
* Tim Zhang
*/
import java.io.Serializable;
public class Password implements Serializable{
    private String password;
    public Password(String initPassword) throws IllegalArgumentException{
        boolean checkSpecial= false; 
        boolean checkNumber= false;
        boolean checkUpper= false;
        boolean checkLower = false;
        for(int i =0; i< initPassword.length(); i++){
        //checks Special characters
        if((initPassword.charAt(i)> 33 && initPassword.charAt(i)<48)|| (initPassword.charAt(i) >=63 && initPassword.charAt(i) <=64)) checkSpecial = true;
        //Check if there is a number
        if(initPassword.charAt(i) >= 48 && initPassword.charAt(i) <= 57) checkNumber = true;
        //Check if there is an upper case
        if(initPassword.charAt(i) >=65 && initPassword.charAt(i) <=90) checkUpper = true;
        //Check if there is an lower case
        if(initPassword.charAt(i) >=97 && initPassword.charAt(i) <=122)checkLower = true;
        }
        if( checkSpecial && checkNumber && checkUpper && checkLower ){
            password = initPassword;
        }
        else{
            throw new IllegalArgumentException("1) At least 1 upper-case letter.\n" +
                    "2)At least 1 number.\n" +
                    "3)At least 1 special character (!@#$%^&* )\n" +
                    "4)At least 1 lower-case letter.");
           
        }
    }
    /**
     * Returns the password
     * @return 
     */
    public String getPassword(){
        return password;
    }
}
