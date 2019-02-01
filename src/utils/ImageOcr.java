package utils;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

public class ImageOcr {
    //设置APPID/AK/SK
    public static final String APP_ID = "14874874";
    public static final String API_KEY = "cU3MEXg9YLXXchGYQ6DVXX6i";
    public static final String SECRET_KEY = "a7cdgaNvkaRUwBrkt58cpbX851K84gbx";

    public static void main(String[] args) throws Exception {
    	
    	String user = "orcl";
    	String password = "orcl";
//    	String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
    	String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn = DriverManager.getConnection(url, user, password);
    	String insertSql = "insert into o7080_pinduoduo_ocr(shop_id,corp_name,content) values(?,?,?)";
    	PreparedStatement pst = conn.prepareStatement(insertSql);
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
        File dir = new File("E:\\pinduoduoimage\\cer");
        File[] images = dir.listFiles();
        int i = 0;
        for(File image : images){
        	
        	String shop_id = "";
        	String content = "";
            String corp_name = "";
            String path = "";
            
        	shop_id = image.getName().replace(".jpg", "");
        	path = image.getAbsolutePath();
        	
            JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
            
            content = res.toString(2);
            Pattern p = Pattern.compile("\"企业名称:(.*?)\"");
            Matcher m = p.matcher(content);
            
            if(m.find()){
            	corp_name = m.group(1);
            }
            pst.setString(1, shop_id);
            pst.setString(2, corp_name);
            pst.setString(3, content);
            pst.execute();
            System.out.println("================="+shop_id+"   "+corp_name+"===============");
            System.out.println(content);
            
        }
        // 调用接口
/*        String path = "e:\\拼多多.jpg";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));*/
        
    }
}