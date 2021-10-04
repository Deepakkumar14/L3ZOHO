package MailSystem;

import java.util.ArrayList;

public class Group {
    private String groupName;
    private String GroupMail;
    private String password;
    private String description;
    private ArrayList<String> members;


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupMail() {
        return GroupMail;
    }

    public void setGroupMail(String groupMail) {
        GroupMail = groupMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }
}
