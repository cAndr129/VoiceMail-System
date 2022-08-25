public class Connection {

    Telephone thePhone=new Telephone();
    Mailbox mail1=new Mailbox();

    public void reachExtension(){
        System.out.println("Hello, welcome to the Voicemail System. Please dial your mailbox extension now.");

        boolean validEntry=true;
        while(validEntry) {
            String numEntered = thePhone.dialNumber();
            if (verifyMailboxNum(numEntered)) {
                validEntry = false;
                mainMenu();
            }
            else {
                System.out.println("Invalid Mailbox number. Please redial.");
            }
        }
    }

    public boolean verifyMailboxNum(String num){
        return mail1.checkMailboxNum(num);
    }

    public void mainMenu(){
        System.out.println("You have reached the mailbox "+mail1.getMailboxNum());
        System.out.println("Press 1 to leave a message. Press 2 to log into your voicemail box");
        String choice= thePhone.dialNumber();

        switch(choice){
            case "1":
                takeMessage();
                reachExtension();
                break;
            case "2":
                logIn();
                break;
            default:
                System.out.println("Not a valid selection,please dial again.");
                mainMenu();

        }
    }

    public void takeMessage(){
        mail1.playGreeting();
        String message= thePhone.getMessageSpoken();
        mail1.addNewMessage(message);
        System.out.println("Message received. You may hang up now.");
    }

    public void logIn(){
        System.out.println("Please dial the Mailbox passcode");
        String passEntered=thePhone.dialNumber();
        if(checkPasscode(passEntered)){
            System.out.println("Password is correct.");
            mailboxMenu();
        }
        else{
            System.out.println("Incorrect passcode, Please try again.");
            logIn();
        }
    }

    public boolean checkPasscode(String pass){
       return mail1.verifyPasscode(pass);
    }

    public void mailboxMenu(){
        System.out.println("Welcome to your private mailbox.");
        System.out.println("Press 1 to retrieve your messages,2 to change your passcode,3 to change your greeting, or 4 to return to Main Menu");
        String choice=thePhone.dialNumber();

        switch(choice){
            case "1":
                messageMenu();
                break;
            case "2":
                changePasscode();
                break;
            case "3":
                changeGreeting();
                break;
            case "4":
                mainMenu();
            default:
                System.out.println("Not a valid selection, please try again.");
                mailboxMenu();
        }

    }

    public void messageMenu(){
        boolean valid=true;
        while(valid){
            System.out.println("Press 1 to play current message,2 to delete current message," +
                "3 to save current message, or 4 to return to previous menu");
            String choice=thePhone.dialNumber();

            switch (choice) {
                case "1":
                    System.out.println("PLaying most recent message: ");
                    System.out.println(mail1.getCurrentMessage());
                    break;
                case "2":
                    System.out.println("Deleting most recent message...");
                    mail1.deleteCurrentMessage();
                    break;
                case "3":
                    System.out.println("Saving most recent message to Saved Messages...");
                    mail1.saveCurrentMessage();
                    break;
                case "4":
                    mailboxMenu();
                    break;
                default:
                    System.out.println("Not a valid selection, please try again.");
                    messageMenu();
            }
        }
    }

    public void changePasscode(){
        System.out.println("Please dial new passcode: ");
        String newPass=thePhone.dialNumber();
        mail1.setPasscode(newPass);
        System.out.println("Passcode has been updated.");
        mailboxMenu();
    }

    public void changeGreeting(){
        System.out.println("Please speak new greeting: ");
        String newGreeting=thePhone.getMessageSpoken();
        mail1.setGreeting(newGreeting);
        System.out.println("Greeting has been updated.");
        mailboxMenu();
    }
}
