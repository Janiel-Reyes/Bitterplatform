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

public class User implements Serializable{
    private String name;
    private String email;
    public User(String name, String email){
        this.name = name;
        this.email = email;
    }
/**
 * Gets the name of user
 * @return name
 */
    public String getName() {
        return name;
    }
    /**
     * Gets the email of user
     * @return 
     */
    public String getEmail(){
        return email;
    }
/**
 * Sets the user's name 
 * @param name 
 */
    public void setName(String name) {
        this.name = name;
    }
    
}
