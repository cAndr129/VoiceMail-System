import java.util.Scanner;

public class Telephone {
    private static Scanner input=new Scanner(System.in);


    public String dialNumber(){
        String numEntered="";
        boolean valid=true;
        while(valid) {
            numEntered=input.nextLine();
            if(numEntered.endsWith("#")){
                numEntered=(numEntered.substring(0,numEntered.length()-1));
                valid=false;
            }
        }
        return numEntered;
    }

    public String getMessageSpoken(){
        StringBuilder sB=new StringBuilder();
        return getMessageSpoken(sB);
    }

    public String getMessageSpoken(StringBuilder sB){
        boolean valid=true;
        while(valid) {
            String messageEntered=input.nextLine();
            if(messageEntered.equals("H")) {
                System.out.println("You have hung up.");
                valid = false;
            }
            else {
                sB.append(messageEntered);
            }
        }
        return sB.toString();
    }

    }
