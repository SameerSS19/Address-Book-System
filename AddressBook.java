package com.addressbook;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook 
{
	public static void main(String[] args) {
		List<String>contact = new ArrayList<String>();
		Scanner input  = new Scanner(System.in);
		System.out.println("Welcome to the Address Book");
		System.out.println("Enter the First Name");
		String fname = input.nextLine();
		System.out.println("Enter the Last Name");
		String lname = input.nextLine();
		System.out.println("Enter the Email Id");
		String email = input.nextLine();
		System.out.println("Enter the Mobile Number");
		String mobile = input.nextLine();
		System.out.println("Enter the City Name");
		String city = input.nextLine();
		System.out.println("Enter the State Name");
		String state = input.nextLine();
		System.out.println("Enter the Full Address");
		String full = input.nextLine();
		System.out.println("Enter the Pin code");
		String pin = input.nextLine();
		
		contact.add(fname);
		contact.add(lname);
		contact.add(email);
		contact.add(mobile);
		contact.add(city);
		contact.add(state);
		contact.add(full);
		contact.add(pin);
		
		for (String str : contact) 
		{
			System.out.println(str);
		}
	 }
}
