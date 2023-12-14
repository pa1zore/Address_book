package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

//contact class is created for storing information of person
class Contacts
{
    //declearing each varible with respective datatype
    String first_name;
    String last_name;
    String address;
    String city;
    String state;
    int    zip;
    String phone_number;
    String email;
    //initialising value with constructor	a
    public Contacts(String first_name,String last_name,String address,String city,String state,int    zip,String phone_number,String email) {
//this is a key word which is used to refer current object
        this.first_name=first_name;
        this.last_name=last_name;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phone_number=phone_number;
        this.email=email;

    }

    @Override
    public String toString()
    {

        return "\n name: "+first_name+" "+last_name+" \n address: "+address+" \n city: "+city+"\n state: "+state+"\n zip: "+zip+" \n phone nunber:"+phone_number+" \nemail: "+email;
    }
}
public class AddressBookMain {
    // scanner class is used to take input from keyboard file etc
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contacts> con = new ArrayList<Contacts>();
    // creating objects and giving inputs from constructor

    public static void main(String[] args) {
        System.out.println("welcome to address book program");
        // decleared arraylist for multiple objects to be created
        ArrayList<Contacts> con = new ArrayList<Contacts>();
        // creating objects and giving inputs from constructor

        do {
            System.out.println(
                    "enter your choice\n press 1: add contact \n press 2: print all contacts \n press 3: to exit\n");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:

                    add_contact();
                    break;

                case 2:
                    print_contact();
                    break;
                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("wrong choice please enter valid input");
                    break;
            }

        } while (true);

    }
    public static void add_contact() {
        sc.nextLine();// to avoid /n issue in after taking integer as input
        System.out.println("enter first name ");
        String first_name = sc.nextLine();
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
    }

    public static void print_contact() {
        if (con.size() == 0) {
            System.out.println("nothing to print you need to add contact first");
        } else {
            for (int i = 0; i < con.size(); i++) {
                System.out.println("***********************************");
                System.out.println(con.get(i));
            }
        }
    }

}
