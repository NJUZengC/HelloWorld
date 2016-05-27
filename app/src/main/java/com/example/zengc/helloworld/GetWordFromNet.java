package com.example.zengc.helloworld;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dell on 2016/5/18.
 */
public class GetWordFromNet {
    public final static String prefix = "http://dict-co.iciba.com/api/dictionary.php?w=";
    public final static String suffix = "&key=23218F6FEC8C348190F3010FF45BE82D";

    public static InputStream getInputStreamByUrl(String urlStr){
        InputStream input = null;
        URL url = null;
        HttpURLConnection connection = null;

        try{
            url = new URL(urlStr);
            connection = (HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(10000);
            input = connection.getInputStream();
        }catch (Exception e){

            e.printStackTrace();
        }
        return input;

    }
}
