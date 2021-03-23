package br.com.noasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.io.*;
import java.net.*;

public class MainActivity extends AppCompatActivity{
   
   Button button;
   TextView tvText;
   String exempleText = "";
   
   
   @Override
   protected void onCreate( Bundle savedInstanceState ){
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_main );
      
      button = findViewById(R.id.btnGO);
      tvText = findViewById(R.id.tvText);
      
      button.setOnClickListener( new View.OnClickListener( ){
         @Override
         public void onClick( View view ){
            // call your job
            button.setText("Loading...");
            doStuff();
         }
      } );
   }
   
   private void doStuff(){
      new Thread(new Runnable(){
         @Override
         public void run( ){
            //do your work
            exempleText = getSiteString("https://www.learningcontainer.com/wp-content/uploads/2020/04/sample-text-file.txt");

            runOnUiThread( new Runnable( ){
               @Override
               public void run( ){
                  button.setText("Go");
                  tvText.setText(exempleText);
               }
            });
            
         }
      }).start();
   }
   
   private String getSiteString(String site){
      String stream = "";
      try{
         URL url = new URL( site );
         HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
         if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8" ));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine()) != null) {
               stringBuilder.append( line );
               stringBuilder.append( "\n" );
            }
            stream = stringBuilder.toString();
            urlConnection.disconnect();
         }
      
      }catch( Exception e ){
          e.printStackTrace();
      }
      return stream;
   }
   
}