package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.ImageDownload;

public class PinduoduoCerImage {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String user = "orcl";
		String password = "orcl";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url, user, password);
		
		String sql = "select shop_id,licence_text from o7080_pinduoduo_info t where t.licence_text is not null";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			String shop_id = rs.getString(1);
			String imageUrl = rs.getString(2);
			ImageDownload.imageDownload(imageUrl, "E:\\pinduoduoimage\\cer", shop_id);
			System.out.println(shop_id+" ÒÑÍê³É");
		}
		rs.close();
		pst.close();
		conn.close();
		
	}

}
