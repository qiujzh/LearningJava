package utils;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageDownload {
    public static void imageDownload(String imageUrl,String path,String name) {
        URL url = null;
        try {
            url = new URL(imageUrl);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
 
            FileOutputStream fileOutputStream = new FileOutputStream(new File(path+"\\"+name+".jpg"));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
 
            byte[] buffer = new byte[1024];
            int length;
 
            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
