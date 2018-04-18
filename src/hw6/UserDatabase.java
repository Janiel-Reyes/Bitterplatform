
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
import java.util.HashMap;

/**
 *
 * @author Kyle
 */
public class UserDatabase extends HashMap<String, User> implements Serializable{
    // Hashmap for the class
    /**
     * Adds a user to the hashmap
     * @param email is the key
     * @param user is the value put in
     */
    public void addUser(String email, User user){
          put(email,user);
    }
    /**
     * Gets the user by using the email as the key
     * @param email
     * @return user
     */
    public User getUser(String email){
        return get(email);
    }
    /**
     * If email is not null and database has key remove it from hashmap
     * @param email
     * @throws IllegalArgumentException 
     */
    public void removeUser(String email) throws IllegalArgumentException{
        if(email ==null || !containsKey(email))
            throw new IllegalArgumentException("No user with that email");
        else{
            remove(email);
        }
    }
    public String toString(){
        return super.toString();
    }
}
