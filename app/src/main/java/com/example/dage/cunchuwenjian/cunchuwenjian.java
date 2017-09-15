package com.example.dage.cunchuwenjian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class cunchuwenjian extends AppCompatActivity {
    String filename="file";
    String string1= "";
    String string2="";
    String str="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cunchuwenjian);
        Button bt1=(Button)findViewById(R.id.bt1);
        Button bt2=(Button)findViewById(R.id.bt2);
        File dateDir=getFilesDir().getParentFile();
        File mydir=new File(dateDir,"file");
        mydir.mkdir();
        final File file=new File(mydir,filename);

        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String reslut="";
                BufferedWriter bw=null;
                OutputStream out=null;
                EditText editText1 =(EditText)findViewById(R.id.editText1);
                string1= editText1.getText().toString();
                EditText editText2=(EditText)findViewById(R.id.editText2);
                string2=editText2.getText().toString();
                reslut="姓名"+string1+"学号"+string2;
                try{
                    file.createNewFile();
                    bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false),"UTF-8"));
                    bw.write(reslut);
                    bw.flush();
                    bw.close();
                } catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BufferedReader br=null;
                EditText editText1 =(EditText)findViewById(R.id.editText2);
                str= editText1.getText().toString();
                try {
                    br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
                    str=br.readLine();
                    TextView textView=(TextView)findViewById(R.id.textView1);
                    textView.setText(str);
                    br.close();
                    //   }
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
