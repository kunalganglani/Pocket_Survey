package kunalganglani.com.suveyji;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by I325566 on 5/18/2016.
 */
public class ServerRequests{
        ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT= 1000*15;
    public static final String SERVER_ADDRESS= "http://mysticads.com/";
    public ServerRequests(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing...");
        progressDialog.setMessage("Please wait....");

    }

    public void storeUserDataInBackground(User user , GetUserCallBack userCallBack){
        progressDialog.show();
        new StoreUserDataAsyncTask(user,userCallBack).execute();

    }
    public void fetchUserDataInBackground(User user , GetUserCallBack callBack){
        progressDialog.show();
    }

    public class StoreUserDataAsyncTask extends AsyncTask<Void,Void,Void>{
        User user;
        GetUserCallBack userCallBack;

        public StoreUserDataAsyncTask(User user , GetUserCallBack callBack){
        this.user = user;
            this.userCallBack=callBack;

        }


        @Override
        protected Void doInBackground(Void... params) {
            try {

                URL url                = new URL(SERVER_ADDRESS + "Register.php");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");

                Uri.Builder builder = new Uri.Builder().appendQueryParameter("name", user.name)
                        .appendQueryParameter("age", user.age + "")
                        .appendQueryParameter("username", user.username)
                        .appendQueryParameter("password", user.password);

                String query          = builder.build().getEncodedQuery();
                OutputStream os       = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();

                conn.connect();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;

        }


        @Override
        protected void onPostExecute(Void aVoid) {
            progressDialog.dismiss();
            userCallBack.done(null);
            super.onPostExecute(aVoid);
        }
    }


}
