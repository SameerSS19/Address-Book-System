package com.addressbook;
import java.util.ArrayList;
import java.util.HashMap; // import the HashMap class
import java.util.List;
import java.util.Scanner;
public class AddressBookMain {


    public static List<HashMap<String, String>> usersList = new ArrayList<HashMap<String, String>>();
    public static List<ArrayList<HashMap<String, String>>> state = new ArrayList<ArrayList<HashMap<String, String>>>();
    // Create a Scanner object
    public static Scanner sc = new Scanner(System.in);
    //Instant Variable
    public static String fName, lName;
    public static String Address, city;
    private static String isState;
    public static String zip, phone;
    public static String email;

    //Take Input And Add To Contacts
    public static String getUserInput() {

        System.out.println("Enter first and last name:");
        fName = sc.next();
        lName = sc.next();
        System.out.println("Enter Address:");
        Address = sc.next();
        System.out.println("Enter City:");
        city = sc.next();
        System.out.println("Enter state:");
        isState = sc.next();
        System.out.println("Enter zip:");
        zip = sc.next();
        System.out.println("Enter phone:");
        phone = sc.next();
        System.out.println("Enter email:");
        email = sc.next();
        // Add keys and values(like first name,last name etc)
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("First Name", fName);
        userInfo.put("Last Name", lName);
        userInfo.put("Address", Address);
        userInfo.put("city", city);
        userInfo.put("State", isState);
        userInfo.put("Zip", zip);
        userInfo.put("contact", phone);
        userInfo.put("email_Id", email);

        boolean userExist = false;
        // Print keys
        for (HashMap<String, String> user : usersList) {
            String emailId = user.get("email_Id");
            if (emailId.equalsIgnoreCase(email)) {
                userExist = true;
            }
        }
        //if user is used adding userinfo
        if (userExist) {
        } else {
            usersList.add(userInfo);

        }

        System.out.println("Do you want to add contact in address book (Y/N)");
        return sc.next();
    }

    //Main method
    public static void main(String args[]) {
        //Statement Asking a user if u want to add Contact and scan
        System.out.println("Do you want to add contact in address book (Y/N)");
        String userDecision = sc.next();
        //while is using user decision Yes
        while (userDecision.equalsIgnoreCase("Y")) {
            userDecision = getUserInput();
        }
        //Statement Record
        System.out.println("Number of record by city:");
        // Output user input
        System.out.println("Number of contacts in address book - " + usersList.size());
        System.out.println("Enter first name you want to search:");
        String isCheck = sc.next();
        // Set Initial Values
        int countDelhi = 0;
        int countGhaziabad = 0;
        //Print keys
        for( HashMap<String,String> user: usersList )
        {
            if(isCheck.equals(user.get("First Name")) && "Delhi".equals(user.get("city")))
            {
                //Cont
                countDelhi ++;
                //Output User Input
                System.out.println("Display the number of person will be present in Delhi "+countDelhi);
            }

            if ( isCheck.equals(user.get("First Name")) && "Ghaziabad".equals(user.get("city")))
            {
                //Count
                countGhaziabad ++;
                //Output User Input
                System.out.println("Display the number of person will be present in Ghaziabad"+countGhaziabad);
            }
        }
        //Displaying the Number of Count Present in City Or State
        System.out.println("Displaying count based on number of city or state:");
    }
}