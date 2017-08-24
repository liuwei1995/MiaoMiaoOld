package com.zhaoyao.miaomiao.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.view.KuGouLayout;

public class KuGouLayoutActivity extends Activity {
	 @Override  
	    protected void onCreate(Bundle bundle){  
	        super.onCreate(bundle);  
	        setContentView(R.layout.ku_gou_layout_activity);  
	  
	        Button button = (Button) findViewById(R.id.m_testButton);  
	        button.setOnClickListener(new View.OnClickListener() {  
	            @Override  
	            public void onClick(View v) {  
	                Toast.makeText(KuGouLayoutActivity.this,"test",Toast.LENGTH_SHORT).show();  
	            }  
	        });  
	  
	        KuGouLayout layout = (KuGouLayout) button.getParent();  
	        layout.setOnCloseListener(new KuGouLayout.OnCloseListener() {  
	            @Override  
	            public void onCloseListener() {  
	            	KuGouLayoutActivity.this.finish();  
	            }  
	        });  
	    }  
	  
	    static public Intent getIntent(Context context){  
	  
	        return new Intent(context,KuGouLayoutActivity.class);  
	    }  
}
