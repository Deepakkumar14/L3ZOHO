package MailSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicalHandling {

    public String nameValidator(String name) {
        if(name==null){
            return "Enter valid name";
        }else{
            if(CacheMemory.INSTANCE.getUserMapBoolean(name)){
                return "User name already exists";
            }
            else
                return "true";
        }
    }

    public String mailValidator(String mail) {
        if(mail==null){
            return "Enter valid mailId";
        }else{
            if(CacheMemory.INSTANCE.getMailBoolean(mail) || CacheMemory.INSTANCE.getGroupMailBoolean(mail)){
                return "MailId already exists";
            }
            else
                return "true";
        }
    }

    public String createUser(User user) {
        if(user!=null) {
            CacheMemory.INSTANCE.createUser(user);
            return "Account created Successfully";
        }else
            return "Account not created successfully ...check the entered details";
    }

    public String groupNameValidator(String name) {
        if(name==null){
            return "Enter valid group name";
        }else{
            if(CacheMemory.INSTANCE.getGroupMapBoolean(name)){
                return "Group name already exists";
            }
            else
                return "true";
        }
    }

    public String groupMailValidator(String mail) {
        if(mail==null){
            return "Enter valid mailId";
        }else{
            if(CacheMemory.INSTANCE.getGroupMailBoolean(mail) || CacheMemory.INSTANCE.getMailBoolean(mail)){
                return "Group MailId already exists";
            }
            else
                return "true";
        }
    }

    public String createGroup(Group group) {
        if(group!=null){
            CacheMemory.INSTANCE.createGroup(group);
            return "Group created Successfully";
        }
        else
            return "Group account not created successfully...Check the entered details";
    }

    public String addMemberToGroup(String groupName, String userName) {
        if(groupName!=null && userName!=null){
            HashMap<String,Group> groupMap=CacheMemory.INSTANCE.getGroupMap();
            Group group=groupMap.getOrDefault(groupName,new Group());
           ArrayList<String> members= group.getMembers();
           if(members==null)
               members=new ArrayList<>();

           if(members.contains(userName)) {
               return "Member already exists in this group";
           }else {
               members.add(userName);
               group.setMembers(members);
               groupMap.put(groupName, group);
               return "Member added successfully";
           }
        }
        else
            return "Member not added check the input details";
    }

    public String mailIdRegex(String mail){
        String regex="^[A-Za-z0-9+_.]+@[a-z](.+)$";
        Pattern pattern=Pattern.compile(regex);
        Matcher match=pattern.matcher(mail);
        if(match.matches())
            return "true";
        else
            return "Mail id should be abc123_.@gmail.com";
    }

    public String groupNameChecker(String name) {
        if(name==null){
            return "Enter valid name";
        }else{
            if(CacheMemory.INSTANCE.getGroupMapBoolean(name)){
                return "true";
            }
            else {
                return "false";
            }
        }
    }

    public String userNameChecker(String name) {
        if(name==null){
            return "Enter valid name";
        }else{
            if(CacheMemory.INSTANCE.getUserMapBoolean(name)){
                return "true";
            }
            else
                return "false";
        }
    }

    public String groupMailChecker(String name) {
        if(name==null){
            return "Enter valid name";
        }else{
            if(CacheMemory.INSTANCE.getGroupMailBoolean(name)){
                return "true";
            }
            else {
                return "false";
            }
        }
    }

    public String userMailChecker(String name) {
        if(name==null){
            return "Enter valid name";
        }else{
            if(CacheMemory.INSTANCE.getMailBoolean(name)){
                return "true";
            }
            else
                return "Enter valid mail";
        }
    }

    public String removeMemberFromGroup(String groupName, String userName) {
        if(groupName!=null && userName!=null){
            HashMap<String,Group> groupMap=CacheMemory.INSTANCE.getGroupMap();
            Group group=groupMap.getOrDefault(groupName,new Group());
            ArrayList<String> members= group.getMembers();
            if(members==null)
                members=new ArrayList<>();

            if(members.contains(userName)) {
                members.remove(userName);
                group.setMembers(members);
                groupMap.put(groupName, group);
                return "Member removed successfully";
            }else
                return "Member not present in this group";
        }
        else
            return "Member not removed check the input details";
    }

    public String sendMail(Mail mail,int choice) {
        if(mail!=null) {
            HashMap<String, User> userMap = CacheMemory.INSTANCE.getUserMap();
            String fromName = CacheMemory.INSTANCE.getUserName(mail.getFrom());
            User user = userMap.get(fromName);
            ArrayList<Mail> sent = user.getSent();
            int number=0;
            if (sent == null) {
                sent = new ArrayList<>();
            }
            if(sent.size()>=1){
               number= sent.get(sent.size()-1).getSerialNo();
            }
            mail.setSerialNo(++number);
            sent.add(mail);
            user.setSent(sent);

            if (choice == 1) {
                String toName = CacheMemory.INSTANCE.getUserName(mail.getTo());
                User toUser = userMap.get(toName);
                ArrayList<Mail> inbox = toUser.getInbox();
                if (inbox == null) {
                    inbox = new ArrayList<>();
                }
                int number1=0;
                if(inbox.size()>=1){
                    number1= inbox.get(sent.size()-1).getSerialNo();
                }
                mail.setSerialNo(++number1);
                inbox.add(mail);
                toUser.setInbox(inbox);
                return "Mail sent successfully";

            }
            else if(choice==2){
                HashMap<String,Group> groupMap=CacheMemory.INSTANCE.getGroupMap();
                String toName = CacheMemory.INSTANCE.getGroupName(mail.getTo());
                Group group=groupMap.get(toName);
                ArrayList<String> members=group.getMembers();
                for(int i=0;i<members.size();i++){
                    User toUser = userMap.get(members.get(i));
                    ArrayList<Mail> inbox = toUser.getInbox();
                    if (inbox == null) {
                        inbox = new ArrayList<>();
                    }
                    int number1=0;
                    if(inbox.size()>=1){
                        number1= inbox.get(inbox.size()-1).getSerialNo();
                    }
                    mail.setTo((userMap.get(members.get(i)).getMailId()));
                    mail.setSerialNo(++number1);
                    inbox.add(mail);
                    toUser.setInbox(inbox);
                }
                return "Mail sent successfully";
            }else
                return "mail not sent successfully";

        }else
            return "Mail not sent successfully";
    }


    public ArrayList<Mail> getSent(String user) {
        if (user != null) {
            HashMap<String, User> userMap = CacheMemory.INSTANCE.getUserMap();
            User user1 = userMap.get(user);
            ArrayList<Mail> sent = user1.getSent();
                return sent;
        }
        return new ArrayList<>();
    }

    public ArrayList<Mail> getInbox(String user) {
        if (user != null) {
            HashMap<String, User> userMap = CacheMemory.INSTANCE.getUserMap();
            User user1 = userMap.get(user);
            ArrayList<Mail> inbox = user1.getInbox();
            return inbox;
        }
        return new ArrayList<>();
    }

    public ArrayList<Mail> deleteInbox(String user,int number) {
        if (user != null) {
            HashMap<String, User> userMap = CacheMemory.INSTANCE.getUserMap();
            User user1 = userMap.get(user);
            ArrayList<Mail> inbox = user1.getInbox();
            inbox.remove(number-1);
            return inbox;
        }
        return new ArrayList<>();
    }

    public ArrayList<Mail> deleteSent(String user,int number) {
        if (user != null) {
            HashMap<String, User> userMap = CacheMemory.INSTANCE.getUserMap();
            User user1 = userMap.get(user);
            ArrayList<Mail> sent = user1.getSent();
            sent.remove(number-1);
            return sent;
        }
        return new ArrayList<>();
    }


}
