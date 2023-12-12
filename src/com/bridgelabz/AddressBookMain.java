package com.bridgelabz;
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
    long phone_number;
    String email;
    //initialising value with constructor	a
    public Contacts(String first_name,String last_name,String address,String city,String state,int    zip,long phone_number,String email) {
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
        Contacts c= new Contacts("david","warner","n9/m2,tvcentre,cidco","london","maharashtra",433332,976694345,"abcd@gmail.com");
        System.out.println(c.toString());
    }

}
