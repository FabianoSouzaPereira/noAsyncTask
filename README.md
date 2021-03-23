# noAsyncTask
![GitHub repo size](https://img.shields.io/github/repo-size/FabianoSouzaPereira/noAsyncTask)
![GitHub language count](https://img.shields.io/github/languages/count/FabianoSouzaPereira/noAsyncTask)
![GitHub top language](https://img.shields.io/github/languages/top/FabianoSouzaPereira/noAsyncTask)</br>
### Async Task deprecated
This class was deprecated in API level 30. Google suggest to use the standard java.util.concurrent or Kotlin concurrency utilities instead. Utility classes commonly useful in concurrent programming. This package includes a few small standardized extensible frameworks, as well as some classes that provide useful functionality and are otherwise tedious or difficult to implement. Here are brief descriptions of the main components.

### Using Thread to do background task

I decided use Thread inheriet java.lang.Object, a thread is a thread of execution in a program. The Java Virtual Machine allows an application to have multiple threads of execution running concurrently. Sure, I'll need migrate to java.util.concurrent and Kotlin concurrency utilities soon. But for now, I beleave that simple stufs this way is propert and can save a day.

>public class Thread
extends Object implements Runnable

>java.lang.Object
   ↳	java.lang.Thread
Known direct subclasses
ForkJoinWorkerThread, HandlerThread 

| subclasses  | |
| ------ | ------ |
| ForkJoinWorkerThread  | A thread managed by a ForkJoinPool, which executes ForkJoinTasks.  |
| HandlerThread  | A Thread that has a Looper. |

An simple example how we can use Thread to solve problem deprecated Asynctask May be noted below.

```sh
import java.io.*;
import java.net.*;

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
   
```

*Code by Tihomir RAdeff
Available at this link [Depricated AsyncTask Replacement in Android Studio](https://www.youtube.com/watch?v=0r6KSK8NSyE&t=560s)


