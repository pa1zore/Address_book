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
    public static void main(String[] args) {
        System.out.println("welcome to address book program");
        // decleared arraylist for multiple objects to be created
        ArrayList<Contacts> con= new ArrayList<Contacts>();
        //creating objects and giving inputs from constructor
        Contacts c1= new Contacts("david","warner","n9/m2,tvcentre,cidco","london","england",433332,"9766943450","abcd@gmail.com");
        Contacts c2= new Contacts("michel","hustey","citymall,tvcentre,cidco","mumbai","maharashtra",442332,"9766998450","addfsd@gmail.com");
        Contacts c3= new Contacts("collin","munro","bridge road,tvcentre,cidco","delhi","uttar pradesh",476532,"9723943450","nnsdfgcd@gmail.com");
        //to add objects of contact class in arraylist
        con.add(c1);
        con.add(c2);
        con.add(c3);
//to print all person's contact information
        for(int i=0;i<con.size();i++)
        {
            System.out.println("--------------------------------------------------------");
            System.out.println(con.get(i).toString());
            System.out.println("--------------------------------------------------------");
        }
        //scanner class is used to take input from keyboard file etc
        Scanner sc= new Scanner(System.in);
        int count=0;
        int flag=0;
        System.out.println("enter name of person to edit details");
        //reading name from console
        String cname=sc.next();
        //iteration until length of arraylist
       while(count<con.size())
       {
           if(con.get(count).first_name.equals(cname))
           {
               System.out.println("name fount successfully");
               flag=1;
               break;
           }
           count++;
       }


        if(flag==0)
        {
            System.out.println(" invalid name \nplease enter valid name");
            System.exit(0);
        }
        else if(flag==1)
        {     sc.nextLine();
            System.out.println("enter new address");
            con.get(count).address=sc.nextLine();
            System.out.println("enter new city");
            con.get(count).city=sc.nextLine();
            System.out.println("enter new state");
            con.get(count).state=sc.nextLine();
            System.out.println("enter new zip");
            con.get(count).zip=sc.nextInt();
            sc.nextLine();
            System.out.println("enter new phone number");
            con.get(count).phone_number=sc.nextLine();
            System.out.println("enter new email address");
            con.get(count).email=sc.nextLine();
            System.out.println("updation done successfully");
        }
        for(int i=0;i<con.size();i++)
        {
            System.out.println("--------------------------------------------------------");
            System.out.println(con.get(i).toString());
            System.out.println("--------------------------------------------------------");
        }
    }

}
