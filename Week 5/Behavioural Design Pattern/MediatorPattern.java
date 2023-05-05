import java.util.ArrayList;
import java.util.List;

interface ChatMediator{
    public void sendMessage(String msg, User user);
    void addUser(User user);
}

abstract class User{
    protected ChatMediator chatMediator;
    protected String name;

    public User(ChatMediator chatMediator, String name){
        this.chatMediator = chatMediator;
        this.name = name;
    }
    
    public abstract void send(String msg);
    public abstract void receive(String msg);
}

class ChatMediatorImpl implements ChatMediator{
    private List<User> users;

    public ChatMediatorImpl(){
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user){
        users.add(user);
    }   

    @Override
    public void sendMessage(String msg, User user) {
        for(User currentUser : users){
            if(currentUser != user ){
                currentUser.receive(msg);
            }
        }
    }
}

class UserImpl extends User{
    public UserImpl(ChatMediator chatMediator, String name){
        super(chatMediator,name);
    }

    @Override
    public void send(String msg) {
        System.out.println(this.name +" is sending message: "+ msg);
        chatMediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name+" is receiving message: "+ msg);
    }
}

public class MediatorPattern{
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediatorImpl();
        User abhishek = new UserImpl(chatMediator, "Abhishek");
        User ankit = new UserImpl(chatMediator, "Ankit");
        User prakash = new UserImpl(chatMediator, "Prakash");
        User ravi = new UserImpl(chatMediator, "Ravi");
        User avinash = new UserImpl(chatMediator, "Avinash");
        User arnab = new UserImpl(chatMediator, "Arnab");

        chatMediator.addUser(ravi);
        chatMediator.addUser(prakash);
        chatMediator.addUser(abhishek);
        chatMediator.addUser(ankit);
        chatMediator.addUser(avinash);
        chatMediator.addUser(arnab);

        abhishek.send("Heyy how r you doing ?");
    }
}