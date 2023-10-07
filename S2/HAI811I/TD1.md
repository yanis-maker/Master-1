**Excercice 1:
		Diagramme de déploiment
**Exercice 2:

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
<string name="app_name">AndroidToastExample</string>
<string name="menu_settings">Settings</string>
<string name="button_label">Show message</string>
<string name="image_content">image</string>
<string name="text_label">Ma première application android</string>
</resources>
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
			  android:layout_width="fill_parent"
			  android:layout_height="fill_parent"
			  android:orientation="vertical" >
<Button
		android:id="@+id/mainbutton"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:text="@string/button_label" />
<TextView 
		  android:id="@+id/maintext"
		  android:layout_width="wrap_content"
		  android:layout_height="wrap_content"
		  android:text="@string/text_label"/>
<EditText 
		  android:id="@+id/mainedit"
		  android:layout_width="wrap_content"
		  android:layout_height="wrap_content"
		  android:inputType="text"/>
</LinearLayout>
```


```java
package com.android.helloandroid;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
public class HelloAndroid extends Activity {
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.layout_file_name);
}
}
```

Exercice 3:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="fill_parent"
android:layout_height="fill_parent"
android:orientation="horizontal" >
<Button
android:id="@+id/button1"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Button 1" />
<Button
android:id="@+id/button2"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Button 2" />
<Button
android:id="@+id/button3"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Button 3"
android:layout_weight="1"/>
</LinearLayout>
```



```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="fill_parent"
android:layout_height="fill_parent" >
<Button
android:id="@+id/button1"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Button 1"/>
<TextView
android:id="@+id/textView"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_below="@+id/button3"
android:layout_marginTop="65dp"
android:text="Username :"
android:textAppearance="?android:attr/textAppearanceLarge" />
<EditText
android:id="@+id/editText"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_alignParentRight="true"
android:layout_alignTop="@+id/textView"
android:layout_toRightOf="@+id/button2"
android:inputType="text" />
<Button
android:id="@+id/button0"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_alignParentRight="true"
android:layout_below="@+id/editText"
android:text="Submit" />
<Button
android:id="@+id/button3"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_alignParentLeft="true"
android:layout_below="@+id/button1"
android:text="Button 3" />
<Button
android:id="@+id/button2"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_below="@+id/button1"
android:layout_toRightOf="@+id/button1"
android:text="Button 2" />
</RelativeLayout>
```


```xml
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:id="@+id/tableLayout"
android:layout_width="fill_parent"
android:layout_height="fill_parent"
android:shrinkColumns="*"
android:stretchColumns="*" >
<!-- 2 columns -->
<TableRow
android:id="@+id/tableRow1"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:padding="5dip" >
<TextView
android:id="@+id/textView1"
android:text="Col 1"
android:textAppearance="?android:attr/textAppearanceLarge" />
<Button
android:id="@+id/button1"
android:text="Col 2" />
</TableRow>
<TableRow
android:id="@+id/tableRow2"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:padding="5dip" >
<EditText
android:id="@+id/editText1"
android:layout_span="2"
android:text="Col 1 & 2" />
</TableRow>
<!-- red line -->
<View
android:layout_height="4dip"
android:background="#FF00" />
<!-- 4 columns -->
<TableRow
android:id="@+id/tableRow3"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:padding="5dip" >
<TextView
android:id="@+id/textView2"
android:text="Col 1" />
<Button
android:id="@+id/button2"
android:text="Col 2" />
<Button
android:id="@+id/button3" 6
android:text="Col 3" />
<Button
android:id="@+id/button5"
android:text="Col 4" />
</TableRow>
<TableRow
android:id="@+id/tableRow4"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:padding="5dip" >
<Button
android:id="@+id/button4"
android:layout_column="2"
android:text="Col 3" />
</TableRow>
<TableRow
		android:id="@+id/tableRow5"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:padding="5dip" >
<Button
		android:id="@+id/button6"
		android:layout_column="1"
		android:text="Col 2" />
</TableRow>
</TableLayout>
```

Excercice 4:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
			android:layout_width="fill_parent"
			android:layout_height="fill_parent"
			android:orientation="vertical">
<Button
		android:id="@+id/mainbutton"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:text="@string/mainbutton" />
</LinearLayout>
```

```java
import android.app.Activity;
import android.os.Bundle; 
import android.view.View; 
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity { 

private Button button; 
public void onCreate(Bundle savedInstanceState) {

	super.onCreate(savedInstanceState); 
	setContentView(R.layout.main); 
	button = (Button) findViewById(R.id.mainbutton);
	
	button.setOnClickListener(new OnClickListener() {
		@Override public void onClick(View arg0) { 
		Toast.makeText(getApplicationContext(),
		"Message Bouton 1",Toast.LENGTH_LONG).show();
		} 
	}); 
} 
}
```