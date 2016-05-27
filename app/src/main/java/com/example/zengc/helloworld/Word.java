package com.example.zengc.helloworld;

/**
 * Created by dell on 2016/5/18.
 */
public class Word {
    public String word = null,chinese=null,english1=null,translate1=null;

    public Word(){
        word = "";
        chinese = "";
        english1 = "";
        translate1 = "";

    }

    public Word(String word, String chinese, String english1, String translate1)
    {
        this.word += word;
        this.chinese += chinese;
        this.english1 += english1;
        this.translate1 += translate1;
    }
}
