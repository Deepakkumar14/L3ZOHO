package MailSystem;

import java.util.ArrayList;
import java.util.HashMap;

public enum CacheMemory {
    INSTANCE;

    private HashMap<String,User> userMap=new HashMap<>();
    private HashMap<String,String> mailId=new HashMap<>();
    private HashMap<String,Group> groupMap=new HashMap<>();
    private HashMap<String,String> groupId=new HashMap<>();


    public boolean getUserMapBoolean(String name) {
        return userMap.containsKey(name);
    }

    public boolean getMailBoolean(String mail) {
        return mailId.containsKey(mail);
    }

    public void createUser(User user) {
        userMap.put(user.getUserName(),user);
        mailId.put(user.getMailId(),user.getUserName());
    }

    public boolean getGroupMapBoolean(String name) {
        return groupMap.containsKey(name);
    }

    public boolean getGroupMailBoolean(String mail) {
        return groupId.containsKey(mail);
    }

    public void createGroup(Group group) {
        groupMap.put(group.getGroupName(),group);
        groupId.put(group.getGroupMail(),group.getGroupName());
    }


    public HashMap<String, Group> getGroupMap() {
        return groupMap;
    }

    public HashMap<String, User> getUserMap() {
        return userMap;
    }

    public String getUserName(String mailId1){
        return mailId.get(mailId1);
    }

    public String getGroupName(String mailId1){
        return groupId.get(mailId1);
    }

}
