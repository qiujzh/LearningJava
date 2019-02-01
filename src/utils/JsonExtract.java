package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class JsonExtract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getCategory();
	}
	public static void getCategory(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDeiver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521", "orcl", "orcl");
			PreparedStatement pst = conn.prepareStatement("insert into moojing_cate values(?,?)");
			String content = getFileContent("e:/moojing.json");
			System.out.println(content);
			JSONObject json = JSONObject.fromObject(content);
			JSONArray jsonArray = json.getJSONArray("result");
			int size = jsonArray.size();
			if(size>0){
				for(int i = 0; i < size; i++ ){
					JSONObject jo = jsonArray.getJSONObject(i);
					String cid = "";
					String cname = "";
					if(jo.containsKey("cid")){
						cid = (String) jo.get("cid");
					}
					if(jo.containsKey("name")){
						cname = (String) jo.get("name");
					}
					pst.setString(1, cid);
					pst.setString(1, cname);
					pst.addBatch();
				}
				pst.execute();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getFileContent(String filePath){
		String content = "";
		try {
			File file = new File(filePath);
			BufferedReader  br = new BufferedReader(new FileReader(file));
			String tempString = null;
			while((tempString = br.readLine())!=null){
				content = content + tempString;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}
}
