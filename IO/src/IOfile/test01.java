package IOfile;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.*;

public class test01 {

	public static void main(String[] args)throws IOException {
		// TODO 自动生成的方法存根

		File srcFile = new File("D:\\java\\项目\\IO\\src\\IOfile\\src.txt");
		File destFile = new File("D:\\java\\项目\\IO\\src\\IOfile\\dest.txt");
		if (srcFile.exists()) {
			srcFile.createNewFile();
		}
		if (destFile.exists()) {
			destFile.createNewFile();
		}
		Writer srcw = new FileWriter(srcFile);
		int ch;
		System.out.println("input the content:");
		//回车+ crtl+z
		while ((ch = System.in.read()) != -1) {
			srcw.write((char) ch);
		}
		srcw.close();
		Reader srcr = new FileReader(srcFile);
		Writer destw = new FileWriter(destFile);
		int b;
		while ((b = srcr.read()) != -1) {
			destw.write(b);
		}
		srcr.close();
		destw.close();
		
	}

}
