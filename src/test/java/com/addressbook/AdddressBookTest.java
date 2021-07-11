package com.addressbook;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdddressBookTest {
    ArrayList<Contact> contact = new ArrayList<>();

    @Test
    public void whenPersonContactDetails_IsAdded_ShouldReturn_True() {
        Contact contact1 = new Contact
                (
                        "Sameer",
                        "Kassar" ,
                        "Kailla Bhatta",
                        "Ghaziabad" ,
                        "Uttar Pradesh",
                        "sk30900@gmail.com",
                       "99383838",
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
                       "99383838",
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
                        "93993993",
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
                        "1492433",
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
                        "939939",
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
                        "9383838",
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
                        "9383838",
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
                        "93993993",
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
                        "1492433",
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
                        "939939",
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
    public void givenCSVFile_WhenRead_ShouldReturn_True() throws IOException {
        OpenCSVFile openCSVReader = new OpenCSVFile();
        Boolean result = openCSVReader.readCSV();
        Assertions.assertTrue(result);
    }


    @Test
    public void givenCSVFile_WhenWritten_ShouldReturn_True() throws IOException {
        String ADDRESS_BOOK_CSV_FILE_PATH = ".src/test/resources/AddressBook.csv";
        List<String[]> contacts = new ArrayList<>();
        String[] contact1 =
                { "Sameer",
                        "Kassar" ,
                        "Kailla Bhatta",
                        "Ghaziabad" ,
                        "Uttar Pradesh",
                        "sk30900@gmail.com",
                        "9383838",
                        "144"
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
        OpenCSVFile openCSVReader = new OpenCSVFile();
        Boolean result = openCSVReader.writeCSV(contacts);
        Assertions.assertTrue(result);
    }


    @Test
    public void givenObject_WhenStoredInTheJson_ShouldReturn_TRUE() {
        Contact contactinfo = new Contact
                (
                        "Sameer",
                        "Kassar" ,
                        "Kailla Bhatta",
                        "Ghaziabad" ,
                        "Uttar Pradesh",
                        "sk30900@gmail.com",
                        "9383838",
                        1144

                );

        JsonFile jsonfile = new JsonFile();
        boolean isAdded = jsonfile.jsonWriteData(contactinfo);
        Assertions.assertTrue(isAdded);
    }

    @Test
    public void givenJsonFile_WhenReadData_ShouldReturn_TRUE() {
        JsonFile jsonfile = new JsonFile();
        boolean isRead = jsonfile.jsonReadData();
        Assertions.assertTrue(isRead);
    }

    @Test
    public void givenAddressBookContactsInDB_WhenRetrieved_ShouldMatchContactsCount() {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        List<Contact> addressBookContactList = addressBookSystem.readAddressBookData(AddressBookSystem.IOService.DB_IO);
        Assertions.assertEquals(8, addressBookContactList.size());
    }

    @Test
    public void givenNewMobileNumberForEmployee_WhenUpdated_ShouldSyncWithDB() {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        List<Contact> personList = addressBookSystem.readAddressBookData(AddressBookSystem.IOService.DB_IO);
        addressBookSystem.updateMobileNumber("Sameer","9383838");
        boolean result = addressBookSystem.checkAddressBookInSyncWithDB("Sameer");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenState_WhenRetrieved_ShouldMatchEntryCount() {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        List<Contact> addressBookDataList =
                addressBookSystem.countPeopleFromGivenCity(AddressBookSystem.IOService.DB_IO, "Ghaziabad");
        Assertions.assertEquals(2, addressBookDataList.size());
    }

    @Test
    public void givenState_WhenRetrieved_ShouldMatchEntryCountBYState() {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        List<Contact> addressBookDataList =
                addressBookSystem.countPeopleFromGivenState(AddressBookSystem.IOService.DB_IO, "Uttar Pradesh");
        Assertions.assertEquals(2, addressBookDataList.size());
    }

    @Test
    public void givenDateRangeWhenRetrieved_ShouldMatchEntryCount()
    {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        LocalDate startDate = LocalDate.of(2020, 12, 01);
        LocalDate endDate = LocalDate.now();
        List<Contact> addressBookDataList = addressBookSystem.readAddressBookForDateRange(AddressBookSystem
                .IOService.DB_IO, startDate, endDate);
        Assertions.assertEquals(2, addressBookDataList.size());
    }

    @Test
    public void given4Entries_WhenAdded_ShouldGetAdded()
    {
        Contact[] arrayOfContactOne = {
                new Contact(7,"raj", "Gupta",
                        "Sadar Bazar", "Satara", "Maharashtra", 445522, "1234567890","rajgupta@gmail.com", LocalDate.now()),
                new Contact(8,"vishva", "wadhai",
                        "Sadar Bazar", "Satara", "Gujrat", 440034  , "7777456321","vishwawadhai@gmail.com", LocalDate.now()),
                new Contact(9,"puja", "lapkale",
                        "Sadar Bazar", "Satara", "Odisha",133211, "5566223311","pujalapkale@gmail.com",  LocalDate.now()),
                new Contact(10,"shilpa", "Thakre",
                        "Sadar Bazar", "Satara", "Karnataka", 332266, "7777777777", "shilpa14thakre@gmail.com", LocalDate.now()),

        };
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        addressBookSystem.readAddressBookData(AddressBookSystem.IOService.DB_IO);
        Instant start = Instant.now();
        addressBookSystem.addMultipleRecordsToAddressBook(Arrays.asList(arrayOfContactOne));
        Instant end = Instant.now();
        System.out.println("Duration without Thread: " + Duration.between(start, end));
        boolean status = addressBookSystem.checkNameInDatabase(10);
        Assertions.assertTrue(status);
    }


    @Test
    public void given4Entries_WhenAdded_ShouldGetAddedUsingThread()
    {
        new Contact(7, "Sameer","Kassar","Kailla Bhatta","Ghaziabad" ,"Uttar Pradesh",  1144,"9383838",sk30900@gmail.com",LocalDate.now()),
        new Contact(8,"Shakiv","Ali",
                "MIlak","Rampur","UP",33229,"99240844", "sha@gmail.com",LocalDate.now()),
                new Contact(9,"Chanddeep", "Kumar",
                        "Puna","Puna", "Delhi",415001, "8149240855","chan@gmail.com", LocalDate.now()),
                new Contact(10,"Afsar", "Saifi",
                        "Sambhal","Amroha", "Bihar",415001,"8149240866", "afsar@gmail.com",LocalDate.now()),
    };
        Contact[] arrayOfPersonsTwo =
                {
                        new Contact(11,"Sameer","Kassar",
                                "Ashtyavinayak colony","Ghazibad","Uttar Pradesh",33344,"918830833", "sk30900@gmail.com",LocalDate.now()),
                        new Contact(12,"Shakiv", "Ali",
                                "Milak","Rampur", "UP", 415001,"8149240844", "sha@gmail.com",LocalDate.now()),
                };
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        addressBookSystem.readAddressBookData(AddressBookSystem.IOService.DB_IO);

        Instant start = Instant.now();
        addressBookSystem.addMultipleRecordsToAddressBook(Arrays.asList(arrayOfPersonsOne));
        Instant end = Instant.now();
        System.out.println("Duration without Thread: " + Duration.between(start,end));
        System.out.println();

        Instant startForThread = Instant.now();
        addressBookSystem.addMultipleRecordsUsingThreadToAddressBook(Arrays.asList(arrayOfPersonsTwo));
        Instant endForThread = Instant.now();
        System.out.println("Duration with Thread: " + Duration.between(startForThread,endForThread));
        boolean status = addressBookSystem.checkNameInDatabase(10);
        Assertions.assertTrue(status);
    }

    @BeforeAll
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
    }

    public Contact[] getPersonList()
    {
        setup();
        Response response = RestAssured.get("/address_book_service");
        System.out.println("PERSON DATA IN JSON Server :\n" + response.asString());
        Contact[] arrayOfPersons = new Gson().fromJson(response.asString(), Contact[].class);
        return arrayOfPersons;
    }

    @Test
    public void givenPersonDataInJSONServerWhenRetrivedShouldMatchTheCount()
    {
        Contact[] arrayOfPersons = getPersonList();
        AddressBookSystem addressBookSystem;
        addressBookSystem = new AddressBookSystem(Arrays.asList(arrayOfPersons));
        long entries = addressBookSystem.countEntries(AddressBookSystem.IOService.REST_IO);
        Assertions.assertEquals(2, entries);
    }

    private Response addPersonToJsonServer(Contact person)
    {
        String personJson = new Gson().toJson(person);
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(personJson);
        return requestSpecification.post("/address_book_service");
    }

    @Test
    public void givenListOfNewPersonsWhenAddedShouldMatchResponse201AndCount()
    {
        List<Contact> list = new ArrayList<>();
        Contact[] arrayOfPersons = getPersonList();
        System.out.println(arrayOfPersons);
        AddressBookSystem addressBookSystem;
        addressBookSystem = new AddressBookSystem(Arrays.asList(arrayOfPersons));
        Contact[] arrayOfPersonData = {
                new Contact(3, "Monali", "Kadu", "Vishrambaug", "Sangli", "Maharashtra", 414414, "7083261167", "monalikadu12@gmail.com", LocalDate.now()),
                new Contact(4, "Roshan", "Valvi", "Mangrul", "Nandurbar", "Maharashtra", 414415, "7083261548", "roshanvalvi@gmail.com", LocalDate.now())
        };
        for(Contact person : arrayOfPersonData)
        {
            Response response = addPersonToJsonServer(person);
            int statusCode = response.getStatusCode();
            Assertions.assertEquals(201, statusCode);
            person = new Gson().fromJson(response.asString(), Contact.class);
            System.out.println(person.toString());
            addressBookSystem.addEmployeeToAddressBook(person, AddressBookSystem.IOService.REST_IO);
        }
        long entries = addressBookSystem.countEntries(AddressBookSystem.IOService.REST_IO);

        Assertions. assertEquals(4, entries);
    }

    @Test
    public void givenNewContactNumberForPersonWhenUpdatedShouldMatch200Response()
    {
        Contact[] arrayOfPersons = getPersonList();
        AddressBookSystem addressBookSystem;
        addressBookSystem = new AddressBookSystem(Arrays.asList(arrayOfPersons));

        addressBookSystem.updateMobileNumber("Sameer", "9503836038", AddressBookSystem.IOService.REST_IO);
        Contact person = addressBookSystem.getAddressBookData("Sameer");

        String personJson = new Gson().toJson(person);
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(personJson);
        Response response = requestSpecification.put("/address_book_service/" +person.id);
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(200, statusCode);
    }
}