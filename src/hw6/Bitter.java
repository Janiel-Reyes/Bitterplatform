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
import java.io.*;

public class Bitter implements Serializable {
    private UserDatabase users;
    private AccountDatabase accounts;
    /**
     * Initializes Bitter with user data base and account database
     */
    public Bitter(){
       
        
        users = new UserDatabase();
        accounts = new AccountDatabase();
    }
    /**
     *Preconditions:
     * email does not already exist in the table.
     * user != null && account != null
     * Postconditions:
     * The user and account have been inserted into their respective databases with the indicated key.
     * @param email
     * @param user
     * @param account 
     */
    public void addUser(String email,User user, Account account){
        if(email ==null || users.containsKey(email) || accounts.containsKey(email))
            throw new IllegalArgumentException("User with that email has been already been made");
        else {
        users.addUser(email, user);
        accounts.addAccount(email, account);
        }
    }
    /**
     * Removes user from Social Network
     * @param email 
     */
    public void removeUser(String email){
        if(email == null || !users.containsKey(email))
            throw new IllegalArgumentException("No user with that email");
        else {
            System.out.println(" User has been removed");
            for(int i = 0; i < accounts.getAccountInformation(email).getFollowers().size();i++){
                System.out.println(accounts.getAccountInformation(email).getName()+" "+accounts.getAccountInformation(email).getFollowers().get(i).getName() );
                unFollow(accounts.getAccountInformation(email),accounts.getAccountInformation(email).getFollowers().get(i),accounts.getAccountInformation(email).getFollowers().get(i).getEmail() );
            }
            users.removeUser(email);
            accounts.removeUser(email);
        }
    }
    /**
     * Gets the account in the account database
     * @param email
     * @return
     * @throws IllegalArgumentException 
     */
    public Account getAccount(String email)throws IllegalArgumentException{
         if(email == null || !users.containsKey(email))
            throw new IllegalArgumentException("No account with that email");
         else{
             return accounts.getAccountInformation(email);
         }
    }
    /**
     * Gets User in UserDatabase
     * @param email
     * @return users.getUser(email)
     * @throws IllegalArgumentException 
     */
    public User getUser(String email) throws IllegalArgumentException{
        if(email == null || !users.containsKey(email))
            throw new IllegalArgumentException("No user with that email");
         else{
             return users.getUser(email);
         }
    }
    /**
     * Adds the current user and account to the others followers list while adding the other to the current users following list
     * @param beingAddedToFollowing
     * @param beingAddedToFollowers
     * @param emailOf 
     */
    public void addFollower(Account beingAddedToFollowing, User beingAddedToFollowers,String emailOf){
        //The user that is the desired person to follow        
        User tempUser = getUser(emailOf);
        Account tempAccount = getAccount(emailOf);
        //Adding thec current user to the desired users following list
        tempAccount.addFollower(beingAddedToFollowers);
        // Adds to the following list of current person
        beingAddedToFollowing.addFollowing(tempUser);
        
        System.out.println(tempAccount.getName()+" has been added.");
    }
    /**
     * Removes the current user from the others followers list and removes from current users following list
     * @param wantingToUnfollow
     * @param wantingToUnfollow2
     * @param emailOf 
     */
    public void unFollow(Account wantingToUnfollow, User wantingToUnfollow2, String emailOf){
        Account tempAccount = getAccount(emailOf);
        wantingToUnfollow.removeFollowing(getUser(emailOf));
        tempAccount.removeFollower(wantingToUnfollow2);
        
    }
    /**
     * Just returns the string of the hashmap using that method
     */
    public void toStringUserDataBase(){
        System.out.println(String.format("%-21s",users.toString()));
    }
    public AccountDatabase getAccountDatabase(){
        return accounts;
    }

}
