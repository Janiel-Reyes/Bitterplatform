package hw6;
/**
* Janiel Reyes
* 111307845
* HW # 6 
* Section 12
* Charles Chen
* Tim Zhang
*/
import java.util.ArrayList;
import java.io.Serializable;
        
public class Account implements Serializable{
    private ArrayList<User> followers = new ArrayList<User>();
    private ArrayList<User> following = new ArrayList<User>();
    private String name;
    private Password password;
   /**
    * Initializes the account to the name and passwords
    * @param name
    * @param password 
    */
    public Account(String name, String password){
        this.name=name;
        this.password = new Password(password);
    }
    /**
     * Returns the arraylist of followers
     * @return 
     */
    public ArrayList<User> getFollowers() {
        return followers;
    }
    /**
     * Returns the arraylist of following
     * @return 
     */
    public ArrayList<User> getFollowing() {
        return following;
    }
    /**
     * Gets the account's name
     * @return 
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the type password which should contain the password string
     * @return 
     */
    public Password getPassword() {
        return password;
    }
    /**
     * Adds follower to accounts follower arraylist
     * @param follower 
     */
    public void addFollower(User follower){
        followers.add(follower);   
    }
    /**
     * Adds user to following array list
     * @param following 
     */
    public void addFollowing(User following){
        this.following.add(following);
    }
    /**
     * Removes unfollowing from arraylist
     * @param unFollowing 
     */
    public void removeFollower(User unFollowing){
       for(int i = 0; i< followers.size();i++){
           if(followers.get(i).getName().equals(unFollowing.getName()))
           {
               followers.remove(i);
               System.out.println(unFollowing.getName()+" has been removed from follows"); 
               return;
           }
       }
       System.out.println("Person does not exist");
    }
   /**
    * Removes unfollower from arraylist
    * @param unFollower 
    */
    public void removeFollowing(User unFollower ){
         for(int i = 0; i< following.size();i++){
           if(following.get(i).getName().equals(unFollower.getName()))
           {
               following.remove(i);
               System.out.println(unFollower.getName()+" has been removed from follows"); 
               return;
           }
       }
       System.out.println("Person does not exist");

    }
    /**
     * Prints out who the users followers are
     */
    public void printFollowers(){
        System.out.println("Your followers:\nEmail                         Name\n");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for(int i = 0; i<followers.size();i++){
            System.out.println(followers.get(i).getEmail()+"        "+ followers.get(i).getName());
        }
    }
    /**
     * Prints out who the user is following
     */
    public void printFollowing(){
        System.out.println("You follow:\nEmail                         Name\n");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for(int i = 0; i<following.size();i++){
            System.out.println(following.get(i).getEmail()+"        "+ following.get(i).getName());
        }
    }
}
