package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;
public class AddressBookMain 
{
	public ArrayList<Contact> contactbook = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    public void addContact()
    {
    	
        System.out.println("Enter First Name"); 
        String first = scan.nextLine();      //scanning a firstname

        System.out.println("Enter Last Name");
        String last = scan.nextLine();       //scanning a last name

        System.out.println("Enter Address");
        String address = scan.nextLine();   //Scanning a Address detail

        System.out.println("Enter City");
        String city = scan.nextLine();  	//Scanning a city Detail

        System.out.println("Enter State");
        String state = scan.nextLine();	 	//Scanning a State detail

        System.out.println("Enter Zip Code");  //Scanning a zid code or pin code
        int zip = scan.nextInt();

        System.out.println("Enter Phone Number");
        long mobileNo = scan.nextLong();		 //Scanning a Phone number

        System.out.println("Enter E-mail");
        String email = scan.next();				 //Scanning a 

        Contact contact = new Contact(first, last, address, city, state,  email,mobileNo, zip); //Add Deatils od contact
        contactbook.add(contact);
        System.out.println(" Add Contact Successfully"); 
        System.out.println("\n You can add multiple person Detail");  // Print Multiple contact 
    }
    public void displayPerson()		//Method to calling a person detail
    {
        System.out.println("\nEntered Person Details is:");
        for (Contact person : contactbook)
        {
            System.out.println(person.toString());
        }
    }

    public void editPerson() //when we editing in detail in contact like:Name,Mobile etc
    {

        System.out.println("\n enter First name to edit details:");

        String name = scan.next();

        for (Contact person : contactbook) {
            System.out.println(person.toString());

            if (name.equals(person.firstName)) {

                System.out.println("\"Select the option to edit: \n"
                        + "1) Mobile no\n"
                        + "2) Email-Id\n"
                        + "3) Address\n"
                        + "4) Quit");
                int numb = scan.nextInt();
                
                //Using switch case you are option to where is editing a detail .
                switch (numb) {
                    case 1 : {
                        System.out.println("enter new Mobile number:");
                        long mobileNo = scan.nextLong();

                        person.setMobileNo(mobileNo);
                        System.out.println("mobile no. is updated\n");
                        break;
                    }
                    case 2 : {
                        System.out.println("enter new Email-id:");
                        String email = scan.nextLine();

                        person.setEmail(email);
                        System.out.println("Email-id is updated\n");
                        break;
                    }
                    case 3 : {
                        System.out.println("enter your city");
                        String city = scan.nextLine();

                        System.out.println("enter your state");
                        String state = scan.nextLine();

                        System.out.println("enter your zip code");
                        int zip = scan.nextInt();

                        person.setCity(city);
                        person.setState(state);
                        person.setZip(zip);
                        System.out.println("Address is updated\n");
                        break;
                    }
                    default : System.out.println("please enter right choice");
                }
            }
            else
                System.out.println("Person is not registered");
        }
    }

    //deleting a person detail
    public void deletePerson()
    {
        System.out.println("enter First name to delete details:");
        String name = scan.nextLine();

        for (int i=0; i < contactbook.size(); i++)
        {
            String personName = contactbook.get(i).firstName;

            if (name.equals(personName))
            {
                contactbook.remove(i);
                System.out.println("this person details is deleted");
                break;
            }
            else
                System.out.println("please enter valid name");
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Welcome To Address Book Problem");
        AddressBookMain address = new AddressBookMain();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Add Contact");
        System.out.println("2.Edit Contact");
        System.out.println("3.Display Contact");
        System.out.println("4.Delete Contact");
        System.out.println("5.Exit");
        int k=0;			// when we are choice the the cases is present 
        while(k==0)
        {
            System.out.println("Enter the choice:");
            int choice = sc.nextInt();
            //Using a switch case
            switch (choice) {
                case 1:
                    address.addContact();
                    break;
                case 2:
                    address.displayPerson();
                    break;
                case 3:
                    address.editPerson();
                    break;

                case 4:
                    address.deletePerson();
                    break;
                case 5:
                    System.out.println("Exit");
                    k = 1;
                    break;
            }
        }
    }
}