## java的IO操作
### 1、基本IO操作
从键盘接收字节流
写入到当前目录下的src.txt文件中
将src.txt文件内容复制到当前目录下dest.txt文件中
将dest.txt文件内容显示到屏幕上
```
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
```
### 2、获取系统的文件树
获取某个目录下的目录信息，目录从控制台输入。
目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
目录的信息写出到文件中。注意，文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序。
```
public static void main(String[] args) throws IOException {
		String Path = "D:\\java\\项目\\IO\\src\\IOfile";
		File directoryinfo = new File("D:\\java\\项目\\IO\\src\\IOfile\\directoryinfo.txt");
		if (directoryinfo.exists()) {
			directoryinfo.createNewFile();
		}
		Writer info = new FileWriter(directoryinfo);
		File afile = new File(Path);
		String[] list;
		list = afile.list();
		String[] temps = new String[list.length];
		int j = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].lastIndexOf('.') == -1) {
				File file = new File(Path + "\\" + list[i]);
				Long lastModified = file.lastModified();
				Date date = new Date(lastModified);
				info.write("directoryname:" + list[i] + "  lastchangedate:" + date + "\r\n");
			} else {
				temps[j++] = list[i];
			}
		}
		for (int k = 0; k < j; k++) {
			File file = new File(Path + "\\" + temps[k]);
			Long lastModified = file.lastModified();
			Date date = new Date(lastModified);
			info.write("file:" + temps[k] + "  lastchangedate:" + date + "  filesize:" + file.length() + "\r\n");
		}
		info.close();
	}
```
### 3、带缓冲器的IO
用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。
```
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
			File inFile = new File("D:\\java\\项目\\IO\\src\\IOfile\\src.txt");
			File outFile = new File("D:\\java\\项目\\IO\\src\\IOfile\\dest.txt ");
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
			File inFile = new File("D:\\java\\项目\\IO\\src\\IOfile\\src.txt");
			File outFile = new File("D:\\java\\项目\\IO\\src\\IOfile\\dest.txt ");
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
 ```
 ### 4、对象序列化
 Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性别)，使用序列化技术定义Student。学生信息从文件list.txt读入，并按照学号升序排列。注意，这里姓名和性别可以组织成String类型，而学号可以是String也可以是Long。
使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。
使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中。
```
/*定义学生类*/
public class student {
	private static final long serialVersionUID = 1234L;
	private String studentID;
	private String name;
	private String sex;
	
	public String getStudentID() {
		return studentID;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", sex="
				+ sex + "]";
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
```

```
/*定义一个比较类:根据学生学号，进行比较，排序*/
public  class studentCompare  implements Comparator<student> {
	public int compare(student o1, student o2) {
		// TODO Auto-generated method stub
		return (o1.getStudentID().compareTo(o2.getStudentID()));
	}
}
```

```
/*test类*/
public class test04 {
	static public ArrayList<student> studentQueue = new ArrayList<student>();

	public static void main(String[] args) {
		// inflattenStudent(Student.studentQueue);
		readStudent();
		SerializableStudent();
		inSerializableStudent();

	}
    /*内容通过读取studen.bin输出*/
	private static void inSerializableStudent() {
		// TODO Auto-generated method stub
		File inFile = new File("src\\IOtest4\\Student.bin");
		FileInputStream finS = null;
		ObjectInputStream oin = null;
		try {
			finS = new FileInputStream(inFile);
			oin = new ObjectInputStream(finS);
			int cout = 0;
			student get = null;
			while ((get = (student) oin.readObject()) != null) {
				System.out.print(++cout + ":  ");
				System.out.println(get);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("输出结束");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
   /*读取表格内容，存入学生类队列*/ 
	private static void readStudent() {
		// TODO Auto-generated method stub
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("D:\\java\\项目\\IO\\src\\IOfile\\list.txt");
			br = new BufferedReader(fr);
			String line = "";
			String[] infos = null;
			while ((line = br.readLine()) != null) {
				student temp = new student();
				infos = line.split(" ");
				temp.setStudentID(infos[0]);
				temp.setName(infos[1]);
				temp.setSex(infos[2]);
				studentQueue.add(temp);			
			}
			br.close();
			fr.close();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			Collections.sort(studentQueue, new studentCompare());

		}

	}
   /*将数据写入student.bin文件*/
	private static void SerializableStudent() {
		// TODO Auto-generated method stub  D:\\java\\项目\\IO\\src\\IOfile\\Student.bin
		File outFile = new File("src\\IOtest4\\Student.bin");
		FileOutputStream foutS = null;
		ObjectOutputStream oout = null;
		try {
			foutS = new FileOutputStream(outFile);
			oout = new ObjectOutputStream(foutS);
			for (student temp : studentQueue) {
				oout.writeObject(temp);
				oout.flush();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("2");
		}
	}
}
```
### 5、总结
通过这次实验基本掌握了输入输出的操作。在序列化遇到了一个困难，在数据读取还有比较卡住了，后来问同学，用comparator接口解决了问题。





