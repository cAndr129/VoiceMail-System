import java.util.LinkedList;

public class MailboxQueue {
    LinkedList<String> mailQueue= new LinkedList<String>();

    public void enqueue(String s){
        if (mailQueue.peek()==null)
            mailQueue.add(s);
        else{
            mailQueue.addLast(s);
        }
    }
    public void dequeue(){
        mailQueue.remove();
    }

    public String peek(){
        return mailQueue.peek();
    }

}