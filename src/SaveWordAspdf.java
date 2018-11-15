import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

 public class SaveWordAspdf {


	 public static void main(String[] args) throws Exception {
		 	Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "orcl", "orcl");
			PreparedStatement query = conn.prepareStatement(" select shop_id,authorize_url from o7100_gs_url_201809_new t where t.authorize_url is not null");
	        /*ResultSet rs = query.executeQuery();
	        while(rs.next()){
	        	String shop_id = rs.getString(1);
	        	String image_url = rs.getString(2);
	        	downloadPicture(image_url,shop_id);
	        	System.out.println("e:/pinduoduoimage/"+shop_id+".jpg"+"     "+image_url+"  下载完成");
	        }*/
			PreparedStatement insert = conn.prepareStatement(" insert into o7100_crawl_id_201809_new values(?,?)");
			Map map = readFiles("e:/pinduoduoimage");
			Iterator keyIterator = map.keySet().iterator();
			while(keyIterator.hasNext()){
				String shop_id = (String) keyIterator.next();
				String file_name = (String) map.get(shop_id);
				insert.setString(1, shop_id);
				insert.setString(2, file_name);
				insert.executeUpdate();
				conn.commit();
				System.out.println(file_name);
			}
	    }
	 
	 private static Map readFiles(String name){
		 Map map = new HashMap<String,String>();
		 File fileDir = new File(name);
		 File files[] = fileDir.listFiles();
		 if(files.length>0){
			 for(File file:files){
				 String fileName = file.getAbsolutePath();
				 String shop_id = fileName.replace("e:\\pinduoduoimage\\", "").replace(".jpg", "");
				 map.put(shop_id, fileName);
			 }
		 }
		return map;
	 }
	    //链接url下载图片
	    private static void downloadPicture(String image_url,String shop_id) {
	        URL url = null;
	        int imageNumber = 0;
	        try {
	            url = new URL(image_url);
	            DataInputStream dataInputStream = new DataInputStream(url.openStream());

	            String imageName =  "e:/pinduoduoimage/"+shop_id+".jpg";
	            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
	            ByteArrayOutputStream output = new ByteArrayOutputStream();

	            byte[] buffer = new byte[1024];
	            int length;

	            while ((length = dataInputStream.read(buffer)) > 0) {
	                output.write(buffer, 0, length);
	            }
	            byte[] context=output.toByteArray();
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
