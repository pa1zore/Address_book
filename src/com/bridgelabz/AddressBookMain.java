package com.bridgelabz;

import java.util.ArrayList;

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

        return "\n name: "+first_name+" "+last_name+" \n address: "+address+" \n city: "+city+"\n state: "+state+" zip: "+zip+" \n phone nunber:"+phone_number+" \nemail: "+email;
    }
}
public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("welcome to address book program");
        ArrayList<Contacts> con= new ArrayList<Contacts>();
        Contacts c1= new Contacts("david","warner","n9/m2,tvcentre,cidco","london","england",433332,"9766943450","abcd@gmail.com");
        Contacts c2= new Contacts("michel","hustey","citymall,tvcentre,cidco","mumbai","maharashtra",442332,"9766998450","addfsd@gmail.com");
        Contacts c3= new Contacts("collin","munro","bridge road,tvcentre,cidco","delhi","uttar pradesh",476532,"9723943450","nnsdfgcd@gmail.com");
        con.add(c1);
        con.add(c2);
        con.add(c3);
        for(int i=0;i<con.size();i++)
        {
            System.out.println("--------------------------------------------------------");
            System.out.println(con.get(i).toString());
            System.out.println("--------------------------------------------------------");
        }
    }

}
