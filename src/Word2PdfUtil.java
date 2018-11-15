import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
 
import java.io.InputStreamReader;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
 
public class Word2PdfUtil {
 
	static final int wdDoNotSaveChanges = 0;// 不保存待定的更改。
	static final int wdFormatPDF = 17;// word转PDF 格式
 
	public static void main(String[] args) throws Exception {
		try {
			ActiveXComponent comx=new ActiveXComponent("pdffactory Pdf");

			Dispatch    ConvertEngine    =  (Dispatch)comx.getObject();
			Dispatch.call(ConvertEngine ,"InitAgent",new Variant("SmartPrinter"),new Variant("60"),new Variant("demo"),new Variant("demo")); 

			Dispatch.call((Dispatch)ConvertEngine ,"ConvertDoc",new Variant("e:\\拼多多地址1.docx"),new Variant("e:\\test.pdf")); 
			Dispatch.call((Dispatch)ConvertEngine ,"CleanAgent"); 
			           
			} catch (Exception e) {
			            e.printStackTrace();
			} 
		
//		swf2pdf("e:\\新建文本文档.txt","e:\\test.pdf");
/*//		Runtime.getRuntime().exec("C:\\Users\\qiujzh\\Desktop\\swf2pdf\\swf2pdf.exe");
		Runtime runtime=Runtime.getRuntime();  
		String[]commandArgs={"C:\\Users\\qiujzh\\Desktop\\swf2pdf\\swf2pdf.exe","e:\\test.swf"};  
		runtime.exec(commandArgs);  */
		/*String source1 = "e:\\test.docx";
		String target1 = "e:\\test1.pdf";
		Word2PdfUtil pdf = new Word2PdfUtil();
		pdf.word2pdf(source1, target1);*/
	}
	
	public static void swf2pdf(String source, String target) throws Exception{
		File s_file = new File(source);
		File t_file = new File(target);
		
		InputStreamReader read = new InputStreamReader(new FileInputStream(s_file));
		BufferedReader bufferedReader = new BufferedReader(read);
		
		BufferedWriter bw = null;
		if (!t_file.exists()) {
			t_file.createNewFile();
		}
		FileWriter fw = new FileWriter(t_file.getAbsoluteFile());
		bw = new BufferedWriter(fw);
		
		String lineTxt = null;
		while ((lineTxt = bufferedReader.readLine()) != null) {
			System.out.println(lineTxt);
			bw.write(lineTxt);
		}
		bw.close();
		fw.close();
		bufferedReader.close();
		
	}
	
	public static boolean word2pdf(String source, String target) {
		System.out.println("WORD转PDF开始启动...");
		long start = System.currentTimeMillis();
		ActiveXComponent app = null;
		try {
			app = new ActiveXComponent("Word.Application");
			app.setProperty("Visible", false);
			Dispatch docs = app.getProperty("Documents").toDispatch();
			System.out.println("打开文档：" + source);
			Dispatch doc = Dispatch.call(docs, "Open", source, false, true).toDispatch();
			System.out.println("转换文档到PDF：" + target);
			File tofile = new File(target);
			if (tofile.exists()) {
				tofile.delete();
			}
			Dispatch.call(doc, "SaveAs", target, wdFormatPDF);
			Dispatch.call(doc, "Close", false);
			long end = System.currentTimeMillis();
			System.out.println("转换完成，用时：" + (end - start) + "ms");
			return true;
		} catch (Exception e) {
			System.out.println("Word转PDF出错：" + e.getMessage());
			return false;
		} finally {
			if (app != null) {
				app.invoke("Quit", wdDoNotSaveChanges);
			}
		}
	}
 
}