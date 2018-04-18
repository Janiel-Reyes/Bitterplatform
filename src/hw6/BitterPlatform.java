package hw6;

/**
 * Janiel Reyes 111307845 HW # 6 Section 12 Charles Chen Tim Zhang
 */
import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BitterPlatform {

    private static Bitter bitter;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean run = true;
        boolean loggedIn = false;
        Scanner sc = new Scanner(System.in);
        //Reading the file and Writing the file variables
        bitter = new Bitter();
        Bitter storage = null;
        FileOutputStream file = null;
        ObjectOutputStream outStream;
        FileInputStream saved;
        ObjectInputStream inStream;
        try {
            saved = new FileInputStream("bitter.obj");
            inStream = new ObjectInputStream(saved);
            storage = (Bitter) inStream.readObject();
            inStream.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (storage != null) {
            bitter = storage;
        }

        //Temporary variables to sign up for the account 
        String tempEmail = "";
        String tempName;
        String tempPassword;
        Account tempAccount = null;
        User tempUser = null;
        String input;
        while (run) {

            System.out.println("Login Menu:\n"
                    + "L)Login\n"
                    + "S)Sign Up\n"
                    + "Q) Quit.\n");
            input = sc.nextLine();

            if (input.equalsIgnoreCase("L")) {
                System.out.println("Enter Email");
                tempEmail = sc.nextLine();

                try {

                    tempAccount = bitter.getAccount(tempEmail);
                    System.out.println("Enter your password");
                    input = sc.nextLine();
                    System.out.println();

                    if (tempAccount.getPassword().getPassword().equals(input)) {
                        System.out.println("Logged In");
                        loggedIn = true;
                        tempUser = bitter.getUser(tempEmail);
                    } else {
                        System.out.println("Wrong Password try again");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (input.equalsIgnoreCase("S")) {

                System.out.println("Enter your email");
                tempEmail = sc.nextLine();
                System.out.println("Enter your name");
                tempName = sc.nextLine();
                System.out.println("Enter your password");

                try {
                    tempPassword = sc.nextLine();
                    tempUser = new User(tempName, tempEmail);
                    tempAccount = new Account(tempName, tempPassword);
                    bitter.addUser(tempEmail, tempUser, tempAccount);
                    loggedIn = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }

            } else if (input.equalsIgnoreCase("Q")) {
                System.out.println("Goodbye");

                //Writing the File
                try {
                    file = new FileOutputStream("bitter.obj");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(BitterPlatform.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    outStream = new ObjectOutputStream(file);
                    // the following line will save the object in the file
                    outStream.writeObject(bitter);
                    outStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(BitterPlatform.class.getName()).log(Level.SEVERE, null, ex);
                }

                run = false;
                System.exit(0);
            } else {
                System.out.println("Enter a Valid letter");
            }
            while (loggedIn) {
                String tempEmail2;
                System.out.println("User Menu:\n"
                        + "F) Follow someone\n"
                        + "U) Unfollow someone\n"
                        + "V) View Followers\n"
                        + "S) See who you follown\n"
                        + "A) List all users.\n"
                        + "L) Logout.\n"
                        + "C) Close your account.");

                input = sc.nextLine();

                if (input.equalsIgnoreCase("F")) {

                    System.out.println("Enter email");
                    tempEmail2 = sc.nextLine();
                    bitter.addFollower(tempAccount, tempUser, tempEmail2);

                } else if (input.equalsIgnoreCase("U")) {
                    System.out.println("Enter email");
                    tempEmail2 = sc.nextLine();
                    bitter.unFollow(tempAccount, tempUser, tempEmail2);
                } else if (input.equalsIgnoreCase("V")) {
                    tempAccount.printFollowers();

                } else if (input.equalsIgnoreCase("S")) {
                    tempAccount.printFollowing();
                } else if (input.equalsIgnoreCase("A")) {
                    System.out.println("All Users \n Email              Name \n------------------------------------------------");
                    for (String key : bitter.getAccountDatabase().keySet()) {
                        System.out.println(key + "         " + bitter.getAccountDatabase().get(key).getName());
                    }
                } else if (input.equalsIgnoreCase("L")) {
                    loggedIn = false;
                } else if (input.equalsIgnoreCase("C")) {
                    try {
                        bitter.removeUser(tempEmail);
                        loggedIn = false;
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                } else {
                    System.out.println("Enter Valid letter");
                }
            }

        }
    }
}
