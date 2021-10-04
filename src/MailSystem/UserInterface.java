package MailSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner input=new Scanner(System.in);
    private  LogicalHandling logic=new LogicalHandling();
    public static void main(String[] args) {
                new UserInterface().mail();
    }
    public void mail(){

        int i=0;
        while(i==0) {
            int choice = 0;
            String output="";
            System.out.println("1.Create user\n2.Create Group\n3.Group assignment\n4.Compose mail\n5.Sent mail\n6.Inbox\n7.Delete");
            choice=input.nextInt();
            input.nextLine();
            switch (choice){
                case 1:{
                    System.out.println("Enter username");
                    String name=input.nextLine();
                    while (!(output.equals("true"))){
                        output=logic.nameValidator(name);
                        if(output.equals("true")) {
                                break;
                        }else {
                            System.out.println(output);
                            name = input.nextLine();
                        }
                    }
                    System.out.println("Enter mailId");
                    String mail=input.nextLine();
                    String output2="";
                    while(!(output2.equals("true"))){
                        output2=logic.mailIdRegex(mail);
                        if(output2.equals("true")) {
                            break;
                        }else {
                            System.out.println(output2);
                            mail = input.nextLine();
                        }
                    }
                    String output1="";
                    while (!(output1.equals("true"))){
                        output1=logic.mailValidator(mail);
                        if(output1.equals("true")) {
                            break;
                        }else {
                            System.out.println(output1);
                            mail = input.nextLine();
                        }
                    }
                    System.out.println("Enter password");
                    String password=input.nextLine();
                    User user=new User();
                    user.setMailId(mail);
                    user.setUserName(name);
                    user.setPassword(password);
                    output=logic.createUser(user);
                    System.out.println(output);
                    break;
                }
                case 2:{
                    System.out.println("Enter group name");
                    String name=input.nextLine();
                    while (!(output.equals("true"))){
                        output=logic.groupNameValidator(name);
                        if(output.equals("true")){
                            break;
                        }
                        else {
                            System.out.println(output);
                            name = input.nextLine();
                        }
                    }
                    System.out.println("Enter mailId");
                    String mail=input.nextLine();
                    String output2="";
                    while(!(output2.equals("true"))){
                        output2=logic.mailIdRegex(mail);
                        if(output2.equals("true")) {
                            break;
                        }else {
                            System.out.println(output2);
                            mail = input.nextLine();
                        }
                    }
                    String output1="";
                    while (!(output1.equals("true"))){
                        output1=logic.groupMailValidator(mail);
                        if(output1.equals("true")) {
                            break;
                        }else {
                            System.out.println(output1);
                            mail = input.nextLine();
                        }
                    }
                    System.out.println("Enter password");
                    String password=input.nextLine();
                    System.out.println("Enter group description ");
                    String description=input.nextLine();
                    Group group=new Group();
                    group.setGroupMail(mail);
                    group.setDescription(description);
                    group.setGroupName(name);
                    group.setPassword(password);
                    output=logic.createGroup(group);
                    System.out.println(output);
                    break;
                }
                case 3:{
                    System.out.println("Enter Group name");
                    String name=input.nextLine();
                    String out="";
                    while (!(out.equals("true"))) {
                        out=logic.groupNameChecker(name);
                        if(out.equals("true"))
                            break;
                        else {
                            System.out.println("No group under this name...Enter valid group name");
                            name = input.nextLine();
                        }
                    }
                    System.out.println("Enter the user name");
                    String user=input.nextLine();
                    String out1="";
                    while (!(out1.equals("true"))) {
                        out1= logic.userNameChecker(user);
                        if(out1.equals("true"))
                            break;
                        else {
                            System.out.println("No user under this name...Enter valid user name");
                            user = input.nextLine();
                        }
                    }
                    System.out.println("1.Add member\n2.Remove member");
                    int option=input.nextInt();
                    input.nextLine();
                    switch (option){
                        case 1:{
                           output= logic.addMemberToGroup(name,user);
                            System.out.println(output);
                            break;
                        }
                        case 2:{
                            output=logic.removeMemberFromGroup(name,user);
                            System.out.println(output);
                            break;
                        }
                        default: {
                            System.out.println("enter correct input");
                            break;
                        }
                    }
                    break;
                }
                case 4:{
                    System.out.println("Enter the From mail id");
                    String mail=input.nextLine();
                    String out="";
                    Mail sendMail=new Mail();
                    while (!(out.equals("true"))) {
                        out=logic.userMailChecker(mail);
                        if(out.equals("true"))
                            break;
                        else {
                            System.out.println("Enter valid mail id");
                            mail = input.nextLine();
                        }
                    }
                    System.out.println("1.Individual\n2.Group");
                    choice=input.nextInt();
                    input.nextLine();
                    String toMail="";
                    switch (choice) {
                        case 1: {
                            System.out.println("Enter to mail id");
                             toMail = input.nextLine();
                            String out1 = "";
                            while (!(out1.equals("true"))) {
                                out1 = logic.userMailChecker(toMail);
                                if (out1.equals("true"))
                                    break;
                                else {
                                    System.out.println("Enter valid mail id");
                                    toMail = input.nextLine();
                                }
                            }
                            break;
                        }
                        case 2:{
                            System.out.println("Enter to mail id");
                            toMail = input.nextLine();
                            String out1 = "";
                            while (!(out1.equals("true"))) {
                                out1 = logic.groupMailChecker(toMail);
                                if (out1.equals("true"))
                                    break;
                                else {
                                    System.out.println("Enter valid mail id");
                                    toMail = input.nextLine();
                                }
                            }
                            break;
                        }
                    }
                    System.out.println("Enter the subject ");
                    String sub=input.nextLine();
                    System.out.println("Enter the content");
                    String content=input.nextLine();
                    sendMail.setContent(content);
                    sendMail.setFrom(mail);
                    sendMail.setSubject(sub);
                    sendMail.setTo(toMail);
                    output=logic.sendMail(sendMail,choice);
                    System.out.println(output);
                    break;
                }
                case 5:{
                    System.out.println("Enter username");
                    String user=input.nextLine();
                    //input.nextLine();
                    String out1="";
                    while (!(out1.equals("true"))) {
                        out1= logic.userNameChecker(user);
                        if(out1.equals("true")) {
                            break;
                        }
                        else {
                            System.out.println("No user under this name...Enter valid user name");
                            user = input.nextLine();
                        }
                    }
                   ArrayList<Mail> sent= logic.getSent(user);
                    if(sent!=null){
                    if (sent.size()>=1) {
                        int serialNumber=0;
                        System.out.println("Serial no" + "\t\t\t" + "From" + "\t\t\t" + "To" + "\t\t\t" + "Subject" + "\t\t\t" + "Content");
                        for (int j = sent.size() - 1; j >= 0; j--) {
                            Mail mail = sent.get(j);
                            System.out.println(serialNumber++ + "\t\t" + mail.getFrom() + "\t\t" + mail.getTo() + "\t\t" + mail.getSubject() + "\t\t" + mail.getContent());
                        }
                    }
                    }
                    else
                        System.out.println("sent  is empty");
                    break;
                }
                case 6:{
                    System.out.println("Enter username");
                    String user=input.nextLine();
                    String out1="";
                    while (!(out1.equals("true"))) {
                        out1= logic.userNameChecker(user);
                        if(out1.equals("true")) {
                            break;
                        }
                        else {
                            System.out.println("No user under this name...Enter valid user name");
                            user = input.nextLine();
                        }
                    }
                    ArrayList<Mail> inbox=  logic.getInbox(user);
                    if(inbox!=null){
                    if (inbox.size()>=1) {
                        int serialnumber=0;
                        System.out.println("Serial no" + "\t\t\t" + "From" + "\t\t\t" + "To" + "\t\t\t" + "Subject" + "\t\t\t" + "Content");
                        for (int j = inbox.size() - 1; j >= 0; j--) {
                            Mail mail = inbox.get(j);
                            System.out.println(serialnumber++ + "\t\t" + mail.getFrom() + "\t\t" + mail.getTo() + "\t\t" + mail.getSubject() + "\t\t" + mail.getContent());
                        }
                    }
                    }
                    else
                        System.out.println("Inbox is empty");
                    break;
                }
                case 7: {
                    System.out.println("Enter user name");
                    String user = input.nextLine();
                    String out1 = "";
                    while (!(out1.equals("true"))) {
                        out1 = logic.userNameChecker(user);
                        if (out1.equals("true")) {
                            break;
                        } else {
                            System.out.println("No user under this name...Enter valid user name");
                            user = input.nextLine();
                        }
                    }
                    System.out.println("1.Inbox\n2.Sent");
                    choice= input.nextInt();
                    input.nextLine();
                    if(choice==1) {
                        ArrayList<Mail> inbox = logic.getInbox(user);
                            if (inbox.size() >= 1) {
                                int serialnumber = 0;
                                System.out.println("Serial no" + "\t\t\t" + "From" + "\t\t\t" + "To" + "\t\t\t" + "Subject" + "\t\t\t" + "Content");
                                for (int j = inbox.size() - 1; j >= 0; j--) {
                                    Mail mail = inbox.get(j);
                                    System.out.println(serialnumber++ + "\t\t" + mail.getFrom() + "\t\t" + mail.getTo() + "\t\t" + mail.getSubject() + "\t\t" + mail.getContent());
                                }
                            }
                        System.out.println("Enter serial no");
                        int serialNumber = input.nextInt();
                        input.nextLine();
                        ArrayList<Mail> inbox1= logic.deleteInbox(user,serialNumber);
                            if (inbox1.size() >= 1) {
                                int serialnumber = 0;
                                System.out.println("Serial no" + "\t\t\t" + "From" + "\t\t\t" + "To" + "\t\t\t" + "Subject" + "\t\t\t" + "Content");
                                for (int j = inbox1.size() - 1; j >= 0; j--) {
                                    Mail mail = inbox1.get(j);
                                    System.out.println(serialnumber++ + "\t\t" + mail.getFrom() + "\t\t" + mail.getTo() + "\t\t" + mail.getSubject() + "\t\t" + mail.getContent());
                                }
                        }
                    }
                    else if(choice==2){
                        ArrayList<Mail> sent= logic.getSent(user);
                            if (sent.size()>=1) {
                                System.out.println("Serial no" + "\t\t\t" + "From" + "\t\t\t" + "To" + "\t\t\t" + "Subject" + "\t\t\t" + "Content");
                                int serialNumber=0;
                                for (int j = sent.size() - 1; j >= 0; j--) {
                                    Mail mail = sent.get(j);
                                    System.out.println(serialNumber++ + "\t\t" + mail.getFrom() + "\t\t" + mail.getTo() + "\t\t" + mail.getSubject() + "\t\t" + mail.getContent());
                                }
                          }
                        System.out.println("Enter serial no");
                        int serialNumber = input.nextInt();
                        input.nextLine();
                        ArrayList<Mail> sent1= logic.deleteSent(user,serialNumber);
                        if (sent1.size() >= 1) {
                            int serialnumber = 0;
                            System.out.println("Serial no" + "\t\t\t" + "From" + "\t\t\t" + "To" + "\t\t\t" + "Subject" + "\t\t\t" + "Content");
                            for (int j = sent1.size() - 1; j >= 0; j--) {
                                Mail mail = sent1.get(j);
                                System.out.println(serialnumber++ + "\t\t" + mail.getFrom() + "\t\t" + mail.getTo() + "\t\t" + mail.getSubject() + "\t\t" + mail.getContent());
                            }
                        }
                    }
                    else {
                        System.out.println("Enter correct input");
                    }
                    break;
                }
            }
        }
    }


}
