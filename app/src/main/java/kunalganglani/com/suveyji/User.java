package kunalganglani.com.suveyji;

/**
 * Created by I325566 on 5/18/2016.
 */
public class User {
    String name, username, password;
    long contactnumber;

    public User(String name, String username, String password, long contactnumber){
        this.name=name;
        this.username=username;
        this.password=password;
        this.contactnumber=contactnumber;
    }

    public User(String username,String password){
        this.username=username;
        this.password=password;
        this.name="";
        this.contactnumber=-1;
    }

}
