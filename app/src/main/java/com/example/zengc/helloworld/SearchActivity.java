package com.example.zengc.helloworld;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.SAXParserFactory;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{

    private Button search = null;
    private String word = "world";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search = (Button)findViewById(R.id.search);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /*new Thread(){
            public  void run(){
                EditText content = (EditText)findViewById(R.id.seachcontent);
                word = content.getText().toString();
                word.trim();
                if(word==null||word==""){
                    return;
                }

                Word seword = null;
                InputStream input = null;

                if(word.charAt(0)<0){
                    word = "_"+word;
                }

                String wordUrl = GetWordFromNet.prefix+word+GetWordFromNet.suffix;
                input = GetWordFromNet.getInputStreamByUrl(wordUrl);

                if(input!=null)
                {
                    try {
                        InputStreamReader reader = new InputStreamReader(input, "utf-8");
                        newword = parseXMLWithSAX(reader);
                        refresh();

                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        }.start();*/
        ProgressBarAsyncTask asyncTask = new ProgressBarAsyncTask();
        asyncTask.execute("1000");






    }

    class ProgressBarAsyncTask extends AsyncTask<String,String, String> {

        private Word newword = null;
        private String searchname = null;
        protected void onPostExecute(String result) {
            if(newword!=null)
            {

                TextView text = (TextView)findViewById(R.id.wordname);
                text.setText(newword.word);
                text = (TextView)findViewById(R.id.chinese);
                text.setText(newword.chinese);
                text = (TextView)findViewById(R.id.english1);
                text.setText(newword.english1);
                text = (TextView)findViewById(R.id.translate1);
                text.setText(newword.translate1);
            }
            else{
                TextView text = (TextView)findViewById(R.id.wordname);
                text.setText(searchname);
                text = (TextView)findViewById(R.id.chinese);
                text.setText("");
                text = (TextView)findViewById(R.id.english1);
                text.setText("The content is not found");
                text = (TextView)findViewById(R.id.translate1);
                text.setText("内容未找到");
            }
        }

        protected String doInBackground(String... params){

            if(searchname==null||searchname==""){
                return params[0]+"";
            }

            Word seword = null;
            InputStream input = null;

            if(searchname.charAt(0)<0){
                searchname = "_"+searchname;
            }

            String wordUrl = GetWordFromNet.prefix+searchname+GetWordFromNet.suffix;
            input = GetWordFromNet.getInputStreamByUrl(wordUrl);

            if(input!=null)
            {
                try {
                    InputStreamReader reader = new InputStreamReader(input, "utf-8");
                    newword = parseXMLWithSAX(reader);

                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }

            return  params[0]+"";
        }

        protected void onPreExecute() {
            EditText content = (EditText)findViewById(R.id.seachcontent);
            searchname = content.getText().toString();
            searchname.trim();
        }


    }
    private Word parseXMLWithSAX(InputStreamReader xmlData)
    {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            ContentHandler handler = new ContentHandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new InputSource((xmlData)));
            return handler.word;

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }




}
