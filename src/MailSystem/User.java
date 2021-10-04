package MailSystem;

import java.util.ArrayList;
import java.util.HashMap;


public class User {
    private String userName;
    private String mailId;
    private String password;
    private ArrayList<Mail> inbox;
    private ArrayList<Mail> sent;
    private ArrayList<HashMap<String,ArrayList<Mail>>> sharedInbox;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Mail> getInbox() {
        return inbox;
    }

    public void setInbox(ArrayList<Mail> inbox) {
        this.inbox = inbox;
    }

    public ArrayList<Mail> getSent() {
        return sent;
    }

    public void setSent(ArrayList<Mail> sent) {
        this.sent = sent;
    }

    public ArrayList<HashMap<String, ArrayList<Mail>>> getSharedInbox() {
        return sharedInbox;
    }

    public void setSharedInbox(ArrayList<HashMap<String, ArrayList<Mail>>> sharedInbox) {
        this.sharedInbox = sharedInbox;
    }



}
