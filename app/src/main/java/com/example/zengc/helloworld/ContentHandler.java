package com.example.zengc.helloworld;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by dell on 2016/5/18.
 */
public class ContentHandler extends DefaultHandler {
    private  String NodeName;
    public ArrayList<String> english;
    public ArrayList<String>translate;
    public String wordname;
    public String chinese;
    public Word word = null;

    public void startDocument(){
        english = new ArrayList<String>();
        translate = new ArrayList<String>();
        wordname = new String();
        chinese = new String();
        word = new Word();
    }

    public void startElement(String uri, String localName, String qName,Attributes attributes)throws SAXException
    {
        super.startElement(uri, localName, qName, attributes);
        NodeName=localName;
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // TODO Auto-generated method stub
        super.characters(ch, start, length);
        if(length<=0)
            return;
        for(int i=start; i<start+length; i++){
            if(ch[i]=='\n')
                return;
        }

        //去除莫名其妙的换行！

        String str=new String(ch,start,length);
        if(NodeName=="key"){
            word.word = str;
        }else if(NodeName=="acceptation"){
            chinese+=("\n"+str);
        }
        else if(NodeName=="orig")
            english.add(str);
        else if(NodeName=="trans")
            translate.add(str);

    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // TODO Auto-generated method stub
        super.endElement(uri, localName, qName);
        NodeName=null;
    }
    public void endDocument()throws SAXException{
        super.endDocument();
        word.chinese = chinese;
        if(english.size()>0&&translate.size()>0) {
            word.english1 = english.get(0);
            word.translate1 = translate.get(0);
        }
        else
            word = null;
    }


}