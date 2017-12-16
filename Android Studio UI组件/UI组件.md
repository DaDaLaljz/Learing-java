## Android  UI组件
### 1.Android ListView的用法
利用SimpleAdapter实现如下界面效果：
（1）注意列表项的布局
（2）图片使用QQ群附件资源
（3）使用Toast显示选中的列表项信息
代码如下：
布局xml文件
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="vertical"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        >
        <!-- 定义一个List -->
        <ListView android:id="@+id/mylist"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            />
        <LinearLayout android:orientation="horizontal"
            android:layout_width="fill_parent"
            android:layout_height="fill_parent">
        <!-- 定义一个ImageView，用于作为列表项的一部分。 -->
        <!-- 定义一个TextView，用于作为列表项的一部分。 -->
        <TextView android:id="@+id/name"
            android:layout_width="80dp"
            android:layout_height="50dp"
            android:textSize="16dp"
            android:layout_alignParentLeft="true"
            android:gravity="center_vertical"
            android:paddingLeft="10dp"
            />
            <ImageView android:id="@+id/imag"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_alignParentRight="true"
            android:paddingLeft="10dp"
            android:layout_marginLeft="250dp"
            />
            </LinearLayout>
    </LinearLayout>
```
mainactivity.java
```
public class MainActivity extends Activity
{
    private String[] names = new String[]
            { "Lion", "Tiger","Monkey","Dog","Cat","Elephant" };
    private int[] imageIds = new int[]
            { R.drawable.lion , R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建一个List集合，List集合的元素是Map
        final List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIds[i]);
            listItem.put("name", names[i]);
            listItems.add(listItem);
        }
        //创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this
                , listItems
                , R.layout.activity_main
                , new String[]{ "image", "name" }
                , new int[]{R.id.imag , R.id.name});
        final ListView list = (ListView)findViewById(R.id.mylist);
        final TextView text = (TextView)findViewById(R.id.name);
        //为ListView设置Adapter
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //创建点击事件，点击Item，生成Toast提醒.
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,Object> map = (HashMap<String,Object> )list.getItemAtPosition(position);
                String Name = (String) map.get("name");
 Toast.makeText(getApplicationContext(),Name,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
```
### 2.创建如图所示的自定义对话框
调用 AlertDialog.Builder 对象上的 setView() 将布局添加到 AlertDialog。
代码如下：
布局activity_main.xml文件
```
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="vertical"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:gravity="center_horizontal"
        >
    <Button
        android:id="@+id/bn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="显示登录对话框"
        />
    </LinearLayout>
```
login.xml文件生成登录dialog框
```
<LinearLayout
        android:id="@+id/Liner"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.0">

        <EditText
            android:id="@+id/name"
            android:layout_width="match_parent"
            android:layout_height="40dp"
            android:hint="Usrname"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent"></EditText>

        <EditText
            android:id="@+id/pw"
            android:layout_width="match_parent"
            android:layout_height="40dp"
            android:hint="Password"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent"></EditText>
```
activity_main.java
```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button bn = (Button)findViewById(R.id.bn);
        //生成AlertDialog.Builder 对象
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        bn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LinearLayout linerout = (LinearLayout)getLayoutInflater().inflate(R.layout.login,null);
                //调用setview函数
                builder.setView(linerout);
                //生成两个按钮
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

    }
}
```
### 3.使用XML定义菜单
字体大小（有小，中，大这3个选项；分别对应10号字，16号字和20号字）；点击之后设置测试文本的字体
普通菜单项，点击之后弹出Toast提示
字体颜色（有红色和黑色这2个选项），点击之后设置测试文本的字体
代码如下：
布局xml文件
```
//用来当测试
 <EditText
            android:id="@+id/et"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:text="用于测试的内容"
            android:editable="false"
            />

```
mainactivity.java
```
//定义变量
private TextView mTextMessage;
    final int Font_10 = 1;
    final int Font_16 = 2;
    final int Font_20 = 3;
    final int Plain_Item = 4;
    final int Font_red = 5;
    final int Font_black =6;
    private EditText edit;
    //创建选择菜单
     public boolean onCreateOptionsMenu(Menu menu){
        SubMenu fontMenu = menu.addSubMenu("字体大小");
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0,Font_10,0,"10号字体");
        fontMenu.add(0,Font_16,0,"16号字体");
        fontMenu.add(0,Font_20,0,"20号字体");
        menu.add(0,Plain_Item,0,"普通菜单选项");
        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        colorMenu.setHeaderTitle("选择字体颜色");
        colorMenu.add(0,Font_red,0,"红色");
        colorMenu.add(0,Font_black,0,"黑色");
        return super.onCreateOptionsMenu(menu);
    }
    //创建事件
    public boolean onOptionsItemSelected(MenuItem mi){
        switch (mi.getItemId()){
            case Font_10:
                edit.setTextSize(10*2);
                break;
            case Font_16:
                edit.setTextSize(16*2);
                break;
            case Font_20:
                edit.setTextSize(20*2);
                break;
            case Plain_Item:
                Toast toast=Toast.makeText(MainActivity.this,"点击普通菜单选项",Toast.LENGTH_SHORT);
                toast.show();
                break;
            case Font_red:
                edit.setTextColor(Color.RED);
                break;
            case Font_black:
                edit.setTextColor(Color.BLACK);
                break;
        }
        return
                true;
    }
```
### 4.总结
这次实验大体上都可以根据例题做出来。只是在toast上面浪费了一些时间，不知道怎么获取名字，后来通过再创建一个maplist来取出，解决toast的获取。然后第二个是有点无厘头，onCreateOptionsMenu()这个函数，拼成onCreateOptionMenu()，少了一个s，结果那个选择菜单一直出不来，还以为是模拟器的问题，最后发现这个低级错误，解决问题...


