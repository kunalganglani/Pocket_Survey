package kunalganglani.com.suveyji;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by I325566 on 5/18/2016.
 */
public class UserLocalStore {
    public static final String SP_NAME="userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase=context.getSharedPreferences(SP_NAME,0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor= userLocalDatabase.edit();
        spEditor.putString("name",user.name);
        spEditor.putString("username",user.username);
        spEditor.putString("password",user.password);
        spEditor.putLong("contactnumber",user.contactnumber);
        spEditor.commit();
    }

    public User getLoggedInUser(){
        String name=userLocalDatabase.getString("name","");
        String username=userLocalDatabase.getString("username","");
        String password=userLocalDatabase.getString("password","");
        long contactnumber=userLocalDatabase.getLong("contactnumber",-1);

        User storedUser= new User(name,username,password,contactnumber);

        return storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor= userLocalDatabase.edit();
        spEditor.putBoolean("LoggedIn",loggedIn);
        spEditor.commit();

    }
    public boolean getUserLoggedIn(){
        if(userLocalDatabase.getBoolean("LoggedIn",false)==true){
            return true;
        }
        else
            return false;
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor= userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
