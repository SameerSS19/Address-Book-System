package com.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdddressBookTest {
    ArrayList<Contact> contact = new ArrayList<>();

    @Test
    public void whenPersonContactDetails_IsAdded_ShouldReturn_True()
    {
        Contact contact1 = new Contact
                (
                        "Sameer",
                        "Kassar" ,
                        "Kailla Bhatta",
                        "Ghaziabad" ,
                        "Uttar Pradesh",
                        "sk30900@gmail.com",
                        99383838,
                        1144
                );

        Contact contact2 = new Contact
                (
                        "Shakiv",
                        "Ali" ,
                        "Milak",
                        "Rampur" ,
                        "Up",
                        "sha@gmail.com",
                        99383838,
                        11444
                );

        Contact contact3 = new Contact
                (
                        "Afsar",
                        "Saifi" ,
                        "Sambhal",
                        "Amroha" ,
                        "Bihar",
                        "afsr@gmail.com",
                        993993993,
                        3333
                );

        Contact contact4 = new Contact
                (
                        "Chandrddep",
                        "Kumar" ,
                        "Puna",
                        "Puna" ,
                        "Delhi",
                        "chan@gmail.com",
                        81492433,
                        1144
                );

        Contact contact5 = new Contact
                (
                        "Naeem",
                        "Ahmad",
                        "Raj Nagar",
                        "Muradabad",
                        "Bihar",
                        "naeem@gmail.com",
                        9939939,
                        698574
                );
        AdddressBookIO addressBook = new AdddressBookIO();
        contact.add(contact1);
        contact.add(contact2);
        contact.add(contact3);
        contact.add(contact4);
        contact.add(contact5);
        boolean isAdded = addressBook.addContact(contact);
        Assertions.assertTrue(isAdded);
    }


    @Test
    public void whenPersonContactsAddedToFile_ISRead_ShouldReturn_True() {
        Contact contact1 = new Contact
                (

                        "Sameer",
                        "Kassar" ,
                        "Kailla Bhatta",
                        "Ghaziabad" ,
                        "Uttar Pradesh",
                        "sk30900@gmail.com",
                        99383838,
                        1144
                );


        Contact contact2 = new Contact
                (
                        "Shakiv",
                        "Ali" ,
                        "Milak",
                        "Rampur" ,
                        "Up",
                        "sha@gmail.com",
                        99383838,
                        11444
                );

        Contact contact3 = new Contact
                (
                        "Afsar",
                        "Saifi" ,
                        "Sambhal",
                        "Amroha" ,
                        "Bihar",
                        "afsr@gmail.com",
                        993993993,
                        3333
                );

        Contact contact4 = new Contact
                (
                        "Chandrddep",
                        "Kumar" ,
                        "Puna",
                        "Puna" ,
                        "Delhi",
                        "chan@gmail.com",
                        81492433,
                        1144
                );

        Contact contact5 = new Contact
                (
                        "Naeem",
                        "Ahmad",
                        "Raj Nagar",
                        "Muradabad",
                        "Bihar",
                        "naeem@gmail.com",
                        9939939,
                        698574
                );

        AdddressBookIO addressBook = new AdddressBookIO();
        contact.add(contact1);
        contact.add(contact2);
        contact.add(contact3);
        contact.add(contact4);
        contact.add(contact5);
        boolean isRead = addressBook.addContact(contact);
        Assertions.assertTrue(isRead);

    }

    @Test
    public void givenCSVFile_WhenRead_ShouldReturn_True() throws IOException
    {
        OpenCSVFile openCSVReader = new OpenCSVFile();
        Boolean result = openCSVReader.readCSV();
        Assertions.assertTrue(result);
    }


    @Test
    public void givenCSVFile_WhenWritten_ShouldReturn_True() throws IOException
    {
        String ADDRESS_BOOK_CSV_FILE_PATH = ".src/test/resources/AddressBook.csv";
        List<String[]> contacts = new ArrayList<>();
        String[] contact1 =
                {
                        "Sameer",
                        "Kassar",
                        "Kailla Bhatta",
                        "Ghaziabad",
                        "Uttar Pradesh",
                        "sk30900@gmail.com",
                        "99838838",
                        "698574"
                };

        String[] contact2 = {
                "Shakiv",
                "Ali" ,
                "Milak",
                "Rampur" ,
                "Up",
                "sha@gmail.com",
                "9383838",
                "1444"
        };
        String[] contact3 = {
                "Chandrddep",
                "Kumar" ,
                "Puna",
                "Puna" ,
                "Delhi",
                "chan@gmail.com",
                "149240733",
                "698577"
        };
        String[] contact4 = {

                "Afsar",
                "Saifi" ,
                "Sambhal",
                "Amroha" ,
                "Bihar",
                "afsr@gmail.com",
                "993993993",
                "3333"
        };

        String[] contact5 = {

                "Naeem",
                "Ahmad",
                "Raj Nagar",
                "Muradabad",
                "Bihar",
                "naeem@gmail.com",
                "9939939",
                "698574"
        };

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);
        contacts.add(contact5);
        OpenCSVFile  openCSVReader = new OpenCSVFile();
        Boolean result = openCSVReader.writeCSV(contacts);
        Assertions.assertTrue(result);
    }


    @Test
    public void givenObject_WhenStoredInTheJson_ShouldReturn_TRUE()
    {
        Contact contactinfo = new Contact
                (
                        "Sameer",
                        "Kassar" ,
                        "Kailla Bhatta",
                        "Ghaziabad" ,
                        "Uttar Pradesh",
                        "sk30900@gmail.com",
                        99383838,
                        1144
                );

        JsonFile jsonfile = new JsonFile();
        boolean isAdded = jsonfile.jsonWriteData(contactinfo);
        Assertions.assertTrue(isAdded);
    }

    @Test
    public void givenJsonFile_WhenReadData_ShouldReturn_TRUE()
    {
        JsonFile jsonfile = new JsonFile();
        boolean isRead = jsonfile.jsonReadData();
        Assertions.assertTrue(isRead);
    }


}
