package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    ArrayList<Person> personArrayList = new ArrayList<Person>();
    static Scanner scan = new Scanner(System.in);
    Person person = new Person();

    public void addPersonDetails() {

        System.out.println("Please enter the First Name: ");
        boolean flag = true;
        while(flag) {
            String fName = scan.nextLine();
            String finalFName = fName;
            if (personArrayList.stream().anyMatch(s -> s.getFirstName().equalsIgnoreCase(finalFName))) {
                System.out.println("Name Already exists, Please enter a New Name");
            }else {
                person.setFirstName(fName);
                flag = false;
            }
        }
        System.out.println("Please enter the Last Name: ");
        person.setLastName(scan.nextLine());
        System.out.println("Please enter the Address: ");
        person.setAddress(scan.nextLine());
        System.out.println("Please enter the City: ");
        person.setCity(scan.nextLine());
        System.out.println("Please enter the State: ");
        person.setState(scan.nextLine());
        System.out.println("Please enter the Zip: ");
        person.setZip(scan.nextLine());
        System.out.println("Please enter the Phone Number: ");
        person.setpNo(scan.nextLine());
        System.out.println("Please enter the Email: ");
        person.setEmail(scan.nextLine());
        personArrayList.add(person);
    }

    public void viewPersons(Person person){
        System.out.println("First Name : " + person.getFirstName());
        System.out.println("Last Name : " + person.lastName);
        System.out.println("Address : " + person.address);
        System.out.println("City : " + person.city);
        System.out.println("State : " + person.state);
        System.out.println("Zip : " + person.zip);
        System.out.println("Phone Number : " + person.pNo);
        System.out.println("Email : " + person.email);
    }

    public void editPersonDetails() {
        System.out.println("Enter the First Name of the Person");
        String fName = scan.nextLine();
        personArrayList.stream().filter(s -> s.getFirstName().equals(fName)).peek(s->{
            Person person = s;
        });
        System.out.println(person.getFirstName());
        System.out.println("What do you want to edit?\n" +
                "1) Last Name\n" +
                "2) Address\n" +
                "3) City\n" +
                "4) State\n" +
                "5) Zip\n" +
                "6) Phone Number\n" +
                "7) Email");
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter the New Last Name");
                person.setLastName(scan.nextLine());
                break;
            case 2:
                System.out.println("Enter the New Address");
                person.setAddress(scan.nextLine());
                break;
            case 3:
                System.out.println("Enter the New City");
                person.setCity(scan.nextLine());
                break;
            case 4:
                System.out.println("Enter the New State");
                person.setState(scan.nextLine());
            case 5:
                System.out.println("Enter the New Zip");
                person.setZip(scan.nextLine());
            case 6:
                System.out.println("Enter the New Phone Number");
                person.setpNo(scan.nextLine());
            case 7:
                System.out.println("Enter the New Email");
                person.setEmail(scan.nextLine());
        }
    }

    public void deletePersonDetails() {
        System.out.println("Enter the First Name of the Person whose contact you want to delete.");
        String fName = scan.nextLine();
        personArrayList.stream().filter(s -> s.getFirstName().equals(fName)).peek(s->{
            Person person = s;
        });
        personArrayList.remove(person);
    }

    public void addMultiplePerson() {
        System.out.println("How Many People do you want to add?");
        int numOfPeople = scan.nextInt();
        for(int i = 0; i < numOfPeople; i++){
            addPersonDetails();
        }
    }

}
