package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class UrlFileCrawler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		crawler("e:/moojing.json");
	}
	public static void crawler(String rootFilePath){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(rootFilePath)));
			String rootUrl = "";
			while((rootUrl = br.readLine())!=null){
				for(int i = 1; i <= 5; i++){
					String pageUrl = rootUrl.replace("page=1", "page="+i);
					HtmlPage page = getClient().getPage(pageUrl);
					String pageContent = page.asText();
					String filePath = rootUrl.replace("https://console.moojing.com/api/shops/search?q=&order_by=sales&desc=true&page=1&page_size=10&cid=", "")+"_"+i;
					downLoadFile(filePath,pageContent);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void downLoadFile(String filePath,String content){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath)));
			bw.write(content);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static WebClient getClient(){
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setTimeout(50000);
        return webClient;
	}
}
