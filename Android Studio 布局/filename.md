## Android布局
####  Android有四大布局，分别为线性布局（LinearLayout）、相对布局（RelativeLayout）、帧布局（FrameLayout）、表格布局(TableLayout)。
### 1.线性布局
```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.dell.demo1.Linear">
<LinearLayout
    android:layout_width="290dp"
    android:layout_height="90dp"
    android:background="#000"
    android:orientation="vertical"
>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
      >

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="One,One "
            android:textColor="#fff" />

        <TextView
            android:layout_width="92dp"
            android:gravity="center"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="One,Two"
            android:textColor="#fff" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="One,Three"
            android:textColor="#fff" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="One,Four "
            android:textColor="#fff" />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        >

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="Two,One"
            android:textColor="#fff" />

        <TextView
            android:layout_width="93dp"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="Two,Two"
            android:textColor="#fff" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="Two,Three"
            android:textColor="#fff" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="Two,Four"
            android:textColor="#fff" />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        >

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="Three,One"
            android:textColor="#fff" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="Three,Two"
            android:textColor="#fff" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="Three,Three"
            android:textColor="#fff" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="Three,Four"
            android:textColor="#fff" />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        >

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="Four,One"
            android:textColor="#fff" />

        <TextView
            android:layout_width="90dp"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="Four,Two"
            android:textColor="#fff" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="Four,Three"
            android:textColor="#fff" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:background="@drawable/border"
            android:text="Four,Four"
            android:textColor="#fff" />
    </LinearLayout>
</LinearLayout>
</android.support.constraint.ConstraintLayout>
```
采用线性布局，先采用垂直分布定义出四个垂直分块，对于每个分块采用水平分布定义出四个分块。

### 2.相对布局
```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.dell.demo1.Linear">

    <RelativeLayout
        android:layout_width="0dp"
        android:layout_height="160dp"
        android:layout_marginBottom="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:background="#000"
        >

        <TextView
            android:id="@+id/red"
            android:layout_width="40dp"
            android:layout_height="40dp"
            android:background="#FFFC0303"
            android:gravity="center"
            android:text="red" />

        <TextView
            android:id="@+id/orange"
            android:layout_width="50dp"
            android:layout_height="40dp"
            android:layout_marginLeft="110dp"
            android:layout_marginRight="110dp"
            android:layout_toLeftOf="@+id/yellow"
            android:layout_toRightOf="@+id/red"
            android:background="#FCB103"
            android:gravity="center"
            android:text="orange" />

        <TextView
            android:id="@+id/yellow"
            android:layout_width="45dp"
            android:layout_height="40dp"
            android:layout_alignParentRight="true"
            android:layout_toLeftOf="@+id/red"
            android:background="#FCF403"
            android:gravity="center"
            android:text="yellow" />

        <TextView
            android:id="@+id/black"
            android:layout_width="90dp"
            android:layout_height="40dp"
            android:layout_below="@+id/red"
            android:background="#000"
            android:gravity="center"
            />

        <TextView
            android:id="@+id/green"
            android:layout_width="60dp"
            android:layout_height="40dp"
            android:layout_below="@+id/red"
            android:layout_toRightOf="@+id/black"
            android:layout_marginTop="20dp"
            android:background="#6FF814"
            android:gravity="center"
            android:text="green" />

        <TextView
            android:id="@+id/blue"
            android:layout_width="60dp"
            android:layout_height="40dp"
            android:layout_below="@+id/red"
            android:layout_toRightOf="@+id/green"
            android:layout_marginTop="20dp"
            android:layout_marginLeft="12dp"
            android:background="#1473F8"
            android:gravity="center"
            android:text="blue" />

        <TextView
            android:id="@+id/indigo"
            android:layout_width="80dp"
            android:layout_height="40dp"
            android:layout_below="@+id/red"
            android:layout_toRightOf="@+id/blue"
            android:layout_marginTop="20dp"
            android:layout_marginLeft="11dp"
            android:background="#563794"
            android:gravity="center"
            android:text="indigo" />
        <TextView
            android:id="@+id/violet"
            android:layout_width="match_parent"
            android:layout_height="40dp"
            android:layout_alignParentBottom="true"
            android:background="#F562C4"
            android:text="violet"
            android:gravity="center"
            />
    </RelativeLayout>
</android.support.constraint.ConstraintLayout>
```
相对布局可以根据已经固定的控件来确定其他新加控件的位置。例如：蓝色空间，相对于绿色是在右边，相对于紫色是在右边，然后相对于是黄色的下边。

### 3.表格布局
```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.dell.demo1.Linear">
<LinearLayout
    android:layout_width="0dp"
    android:layout_height="0dp"
    android:background="#000"
    android:orientation="vertical"
    tools:layout_constraintTop_creator="1"
    tools:layout_constraintRight_creator="1"
    tools:layout_constraintBottom_creator="1"
    android:layout_marginStart="8dp"
    app:layout_constraintBottom_toBottomOf="parent"
    android:layout_marginEnd="8dp"
    app:layout_constraintRight_toRightOf="parent"
    android:layout_marginTop="8dp"
    tools:layout_constraintLeft_creator="1"
    android:layout_marginBottom="8dp"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    android:layout_marginLeft="8dp"
    android:layout_marginRight="8dp">

    <TableLayout
        android:layout_width="match_parent"
        android:layout_height="130dp"
        android:stretchColumns="1">

        <TableRow>

            <TextView
                android:padding="8dp"
                android:text="  Open.."
                android:textSize="20dp"
                android:textColor="#8F8686"/>

            <TextView
                android:gravity="right"
                android:padding="3dp"
                android:text="Crtl-O"
                android:textSize="20dp"
                android:textColor="#8F8686"/>
        </TableRow>

        <TableRow
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <TextView
                android:padding="8dp"
                android:text="  Save..."
                android:textSize="20dp"
                android:textColor="#8F8686"/>

            <TextView
                android:gravity="right"
                android:padding="3dp"
                android:text="Crtl-S"
                android:textSize="20dp"
                android:textColor="#8F8686"/>
        </TableRow>

        <TableRow
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <TextView
                android:padding="8dp"
                android:text="  Save as..."
                android:textSize="20dp"
                android:textColor="#8F8686"/>

            <TextView
                android:gravity="right"
                android:padding="3dp"
                android:text="Crtl-Shift-S"
                android:textSize="20dp"
                android:textColor="#8F8686">

            </TextView>
        </TableRow>
        <TableRow>
        <TextView
            android:layout_width="match_parent"
            android:layout_height="2dp"
            android:background="#8F8686"
            />
            <TextView
                android:layout_width="match_parent"
                android:layout_height="2dp"
                android:background="#8F8686"
                />
        </TableRow>
    </TableLayout>

      <TableLayout
          android:layout_width="match_parent"
          android:layout_height="80dp"
          android:stretchColumns="1"
          tools:layout_editor_absoluteY="0dp"
          tools:layout_editor_absoluteX="8dp">
          <TableRow
              android:layout_width="match_parent"
              android:layout_height="match_parent">
          <TextView
              android:padding="8dp"
              android:text="X Import..."
              android:textSize="20dp"
              android:textColor="#8F8686"/>
          </TableRow>

          <TableRow
              android:layout_width="match_parent"
              android:layout_height="match_parent">

          <TextView
              android:padding="8dp"
              android:text="X Export..."
              android:textSize="20dp"
              android:textColor="#8F8686"/>

          <TextView
              android:gravity="right"
              android:padding="3dp"
              android:text="Crtl-E"
              android:textSize="20dp"
              android:textColor="#8F8686"/>
          </TableRow>
          </TableLayout>

      <TableLayout
          android:layout_width="match_parent"
          android:layout_height="80dp"
          android:stretchColumns="1"
          tools:layout_editor_absoluteY="0dp"
          tools:layout_editor_absoluteX="8dp">
          <TableRow>
              <TextView
            android:layout_width="match_parent"
            android:layout_height="2dp"
            android:background="#8F8686"
            />
            <TextView
                android:layout_width="match_parent"
                android:layout_height="2dp"
                android:background="#8F8686"
                />
          </TableRow>
      <TableRow
          android:layout_width="match_parent"
          android:layout_height="match_parent">
          <TextView
              android:padding="8dp"
              android:text="  Quit"
              android:textSize="20dp"
              android:textColor="#8F8686"/>
      </TableRow>
      </TableLayout>

</LinearLayout>
```
表格布局是通过tablerow来定义每一行。表格布局没有边框的，它是由多个TableRow对象组成，每个TableRow可以 有0个或多个单元格，每个单元格就是一个View。

### 4.总结
布局对于界面是非常重要的，已经能够基本掌握常用的布局。
