package android.stakbrowser.amitrai.parsingdemo;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by amitrai on 7/1/16.
 */
public class Solar {

    public static void generateNoteOnSD(String sFileName, String sBody, Context context) {
        try {
            File root = new File(Environment.getExternalStorageDirectory(), ".Notes");
            if (!root.exists()) {
                root.mkdirs();
            }else if(root.exists()){
                try
                {
                    File myFile = new File(root, sFileName);
                    FileOutputStream fOut = new FileOutputStream(myFile);
                    OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                    myOutWriter.append("hello how are you");
                    myOutWriter.close();
                    fOut.close();
                } catch(Exception e)
                {

                }
            }else {

                File gpxfile = new File(root, sFileName);
                FileOutputStream fOut = new FileOutputStream(gpxfile);
                OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                myOutWriter.append("hello how are you");
                myOutWriter.close();
                fOut.close();
                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readNoteOnSD(Context context) {
        try {
            File sdcard = new File(Environment.getExternalStorageDirectory(), ".Notes");
            File file = new File(sdcard, "text.txt");
            if(!file.exists())
                return;

            StringBuilder text = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}