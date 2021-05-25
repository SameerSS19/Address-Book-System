package com.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class AddressBook 
{
	/**
	 * create contact is a function in which we add the contact details
	 * @return array list
	 */
	public static ArrayList<String> createContact()
	{
		ArrayList<String> Contact = new ArrayList<String>(1);
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the First name : ");
        String fname = input.nextLine();

        System.out.print("Enter the Last name : ");
        String lname = input.nextLine();

        System.out.print("Enter the Address : ");
        String address = input.nextLine();

        System.out.print("Enter the City : ");
        String city = input.nextLine();

        System.out.print("Enter the state : ");
        String state = input.nextLine();

        System.out.print("Enter the Zip Code : ");
        String zip = input.nextLine();

        System.out.print("Enter the phone number: ");
        String phone = input.nextLine();
        
        System.out.print("Enter the Email: ");
        String email = input.nextLine();
        
        Contact.add(fname);
        Contact.add(lname);
        Contact.add(address);
        Contact.add(city);
        Contact.add(state);
        Contact.add(zip);
        Contact.add(phone);
        Contact.add(email);

        for (String str : Contact)
        {
            System.out.println(str + " "); 
        }
        return Contact;
	}
	/**
	 * created a function to edit the details from the console.
	 * @param personDetail
	 */
	public static void editContact( ArrayList<String> Contact1)
	{
		ListIterator<String> iterator = Contact1.listIterator();
		System.out.println("Enter old value");
		Scanner input = new Scanner(System.in);
		String originalValue = input.nextLine();
		System.out.println("Enter new value");
		String value = input.nextLine();
		while (iterator.hasNext()) {
		     String next = iterator.next();
		     if (next.equals(originalValue)) {
		         //Replace element
		         iterator.set(value);
		     } 
		 }
		 for (String str : Contact1)
	        {
	            System.out.println(str + " "); 
	        }
	}
	/**
	 * all functions are passes in main function to perform .
	 * @param args
	 */
	public static void main(String[] args) 
	{
        System.out.println("Welcome in Address Book");
        ArrayList<String> Contact1= createContact();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the First name : ");
        String fname = input.nextLine();
        System.out.print("What you want to perform ? Press 1 for Add the details , press 2 for edit the details : ");
        int option = input.nextInt();
        switch(option)
        {
        	case 1:
        		createContact();
        	break;
        	case 2:
        		editContact(Contact1);
        	break;
        	default:
        		System.out.print("Please enter the valid number : ");	
        } 
	}
}