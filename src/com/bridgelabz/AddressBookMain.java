package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//contact class is created for storing information of person
class Contacts {
    // declearing each varible with respective datatype
    String first_name  ;
    String last_name;
    String address;
    String city;
    String state;
    int zip;
    String phone_number;
    String email;

    // initialising value with constructor a
    public Contacts(String first_name, String last_name, String address, String city, String state, int zip,
                    String phone_number, String email) {
//this is a key word which is used to refer current object
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone_number = phone_number;
        this.email = email;

    }
  //gettr for city
    public String getCity() {
        return city;
    }
// getter for fist name
    public String getFirst_name() {
        return first_name;
    }
  // override toString for printing
    @Override
    public String toString() {

        return "\n name: " + first_name + " " + last_name + " \n address: " + address + " \n city: " + city
                + "\n state: " + state + "\n zip: " + zip + " \n phone nunber:" + phone_number + " \nemail: " + email;
    }
}

//address book class to manage contacts
class AddressBook
{
    static Scanner sc = new Scanner(System.in);
     ArrayList<Contacts> con = new ArrayList<Contacts>();


    // creating objects and giving inputs from constructor
      String addressbookname;
      boolean k=true;
    public AddressBook( String addressbookname)
    {
        this.addressbookname=addressbookname;



        choice();
    }
    public void choice( ) {
        // decleared arraylist for multiple objects to be created

        // creating objects and giving inputs from constructor

        do {
            System.out.println(
                    "enter your choice\n press 1: add contact \n press 2: edit contact detail \n press 3: remove contact  \n press 4: print all contacts \n press 5: to exit\n");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:

                    add_contact();
                    break;
                case 2:
                    edit_contact();
                    break;
                case 3:
                    remove_contact();
                    break;
                case 4:
                    print_contact();
                    break;
                case 5:
                    k=  false;
                    break;

                default:
                    System.out.println("wrong choice please enter valid input");
                    break;
            }

        } while (k);

    }


    public  boolean add_contact() {
        sc.nextLine();// to avoid /n issue in after taking integer as input
        System.out.println("enter first name ");

        String first_name = sc.nextLine();
        // this code is specially check to whether the first name is already present in string
        // or not by using java api strema methods
        boolean isNamePresent = con.stream().anyMatch(i->i.first_name.equals(first_name));
        if(isNamePresent)
        {
            System.out.println("name is already exist  ");
            return false;
        }
        System.out.println("enter last name ");
        String last_name = sc.nextLine();
        System.out.println("enter address ");
        String address = sc.nextLine();
        System.out.println("enter  city");
        String city = sc.nextLine();
        System.out.println("enter  state");
        String state = sc.nextLine();
        System.out.println("enter zip-code");
        int zip = sc.nextInt();
        sc.nextLine();
        System.out.println("enter phone number");
        String phone_number = sc.nextLine();
        System.out.println("enter email");
        String email = sc.nextLine();
        Contacts cont = new Contacts(first_name, last_name, address, city, state, zip, phone_number, email);
        con.add(cont);
        return true;
    }

    public  boolean print_contact() {
        if (con.size() == 0) {
            System.out.println("nothing to print you need to add contact first");
            return  false;
        } else {
            for (int i = 0; i < con.size(); i++) {
                System.out.println("***********************************");
                System.out.println(con.get(i));

            }
        }
        return true;
    }

    public  boolean edit_contact() {
        int count = check();//calling check methods

        if (count == -1) {
            System.out.println(" invalid name \nplease enter valid name");
            return  false;

        }
        // flag=1 means name is found and index is store in count varible so we can
        // update details by index of that contact
        else {

            System.out.println("enter new address");
            con.get(count).address = sc.nextLine();
            System.out.println("enter new city");
            con.get(count).city = sc.nextLine();
            System.out.println("enter new state");
            con.get(count).state = sc.nextLine();
            System.out.println("enter new zip");
            con.get(count).zip = sc.nextInt();
            sc.nextLine();// after taking interger as input /n create ussue for that we are using this
            // method
            System.out.println("enter new phone number");
            con.get(count).phone_number = sc.nextLine();
            System.out.println("enter new email address");
            con.get(count).email = sc.nextLine();
            System.out.println("updation done successfully");
        }
        return true;
    }

    public  void remove_contact() {
        int count = check();//calling check method
        if (count == -1) {
            System.out.println(" invalid name \nplease enter valid name");

        } else {
            con.remove(count);
            System.out.println("contact removed successfully!!!");
        }
    }

    public  int check() {
        sc.nextLine();// to avoid /n issue in after taking integer as input
        int count = 0;
        // flag variable is to check user input name found or not
        if (con.size() == 0) {
            System.out.println(" No contact information to edit  ");
        } else {
            // int flag = 0;
            System.out.println("enter name of person to edit details");
            // reading name from console
            String cname = sc.nextLine();
            // iteration until length of arraylist
            while (count < con.size()) {
                // checking name of user input is matches with any name of stored contact
                if (con.get(count).first_name.equals(cname)) {
                    System.out.println("name fount successfully");

                    return count;
                    // as name has been found so no need to iterate break used to go out of loop
                    // after condition true
                }
                count++;
            }

            // if flag=0 means name is not found and so we are priting message and and stop
            // execution
        }
        return -1;
    }
}

public class AddressBookMain {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, AddressBook> mapbook = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book program");
        boolean bb = true;

        while (bb) {
            System.out.println("Enter your choice:");
            System.out.println("Add new address book:                   1");
            System.out.println("Search person in target city:           2");
            System.out.println("View persons by city:                   3");
            System.out.println("Exit:                                   4");

            int choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    add_Addressbook();
                    break;
                case 2:
                    toSearchPersonByTargetCity();
                    break;
                case 3:
                    toViewPersonAccordingToCity();
                    break;
                case 4:
                    bb = false;
                    break;
                default:
                    System.out.println("Wrong choice, please enter a valid one");
                    break;
            }
        }
    }

    static boolean add_Addressbook() {
        System.out.println("Enter the name of the new address book");
        String addressbook_name = sc.nextLine();

        if (mapbook.containsKey(addressbook_name)) {
            System.out.println("Address book is already present");
            return false;
        } else {
            mapbook.put(addressbook_name, new AddressBook(addressbook_name));
            return true;
        }
    }

    static boolean toSearchPersonByTargetCity() {
        // Ability to search for a person in a city across multiple address books
        if (mapbook.isEmpty()) {
            System.out.println("Nothing to print");
            return false;
        }

        System.out.println("Enter the name of the city");
        String targetcity = sc.nextLine();
        List<String> nameInTargetCity = mapbook.values().stream()
                .flatMap(mapboo -> mapboo.con.stream())
                .filter(contacts -> contacts.city.equals(targetcity))
                .map(contacts -> contacts.first_name + " " + contacts.last_name)
                .collect(Collectors.toList());

        System.out.println(nameInTargetCity);
        return true;
    }

    static boolean toViewPersonAccordingToCity() {
        if (mapbook.isEmpty()) {
            System.out.println("Nothing to print");
            return false;
        }

        // Get all unique cities
        Set<String> cityList = mapbook.values().stream()
                .flatMap(AddressBook -> AddressBook.con.stream())
                .map(Contacts::getCity)
                .collect(Collectors.toSet());

        // Print names stored in contacts according to different city names
        for (String city : cityList) {
            System.out.println("City: " + city);
            mapbook.values().stream()
                    .flatMap(addressBook -> addressBook.con.stream())
                    .filter(contacts -> contacts.getCity().equals(city))
                    .map(Contacts::getFirst_name)
                    .forEach(System.out::println);
            System.out.println();
        }
        return true;
    }
}
