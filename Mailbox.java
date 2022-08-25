public class Mailbox {
    private String mailboxNum;
    private String passcode;
    private String greeting;
    private String messageReceived;
    MailboxQueue currentMessages= new MailboxQueue();
    MailboxQueue savedMessages=new MailboxQueue();

    public Mailbox(){
        passcode="1111";
        mailboxNum="12345";
        greeting="Thanks for calling, please leave a message.";
    }

    public String getMailboxNum(){
        return mailboxNum;
    }

    public boolean checkMailboxNum(String i){
        return i.equals(getMailboxNum());
    }

    private String getGreeting(){
        return greeting;
    }

    public void setGreeting(String s){
        greeting=s;
    }

    private String getPasscode(){
        return passcode;
    }

    public void setPasscode(String i){
        passcode=i;
    }

    public boolean verifyPasscode(String i){
        return i.equals(getPasscode());
    }

    public void playGreeting(){
        System.out.println(getGreeting());
    }

    public void addNewMessage(String s){
        currentMessages.enqueue(s);
    }

    public String getCurrentMessage(){
        if (currentMessages.peek()==null) {
            if (savedMessages.peek()==null)
                return "Your mailbox is empty.";
            else{
                System.out.println("No new messages, playing from Saved messages");
                return savedMessages.peek();
            }
        }
        return currentMessages.peek();  //add ability to play from saved messages
    }

    public void deleteCurrentMessage(){
        if(currentMessages.peek()==null){
            if(savedMessages.peek()==null) {
                System.out.println("Your mailbox is empty, no messages to delete.");
                return;
            }
            else {
                System.out.println("No recent messages, deleting current saved message.");
                savedMessages.dequeue();
            }
        }
        else {
            currentMessages.dequeue();
        }
    }

    public void saveCurrentMessage(){
        if(currentMessages.peek()==null) {
            System.out.println("No new messages to save.");
        }
        else{
            String messageSaved = currentMessages.peek();
            savedMessages.enqueue(messageSaved);
            deleteCurrentMessage();
        }
    }
}
