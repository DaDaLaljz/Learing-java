package IOfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class test03 {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
			long sysDateStart = System.currentTimeMillis();
			System.out.println(sysDateStart);
			IOchar();
			long sysDateEnd = System.currentTimeMillis();
			System.out.println(sysDateEnd);
			System.out.println(sysDateEnd-sysDateStart);
			long sysDateStart1 = System.currentTimeMillis();
			System.out.println(sysDateStart1);
			IOBufferedChar();
			long sysDateEnd1 = System.currentTimeMillis();
			System.out.println(sysDateEnd1);
			System.out.println(sysDateEnd1-sysDateStart1);
		}
		public static void IOchar() throws IOException{
			File inFile = new File("D:\\java\\项目\\IO\\src\\IOfile\\test3-1.txt");
			File outFile = new File("D:\\java\\项目\\IO\\src\\IOfile\\test3-2.txt ");
			Reader finS = new FileReader(inFile);
			Writer foutS = new FileWriter(outFile);
			int ch;
			while((ch = finS.read())!=-1) {
				foutS.write(ch);
			}
			foutS.close();
			finS.close();
		}
		public static void IOBufferedChar() throws IOException{
			File inFile = new File("D:\\java\\项目\\IO\\src\\IOfile\\test3-1.txt");
			File outFile = new File("D:\\java\\项目\\IO\\src\\IOfile\\test3-2.txt ");
			Reader finS = new FileReader(inFile);
			Writer foutS = new FileWriter(outFile);
			BufferedReader bfinS = new BufferedReader(finS);
			BufferedWriter bfoutS = new BufferedWriter(foutS);
			int ch;
			while((ch = bfinS.read())!=-1) {
				bfoutS.write(ch);
			}
			bfoutS.close();
			bfinS.close();
			foutS.close();
			finS.close();
		} 

	}

