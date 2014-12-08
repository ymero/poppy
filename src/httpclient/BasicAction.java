package httpclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * httpclient基本用法
 * 
 * @author Frank
 * @date 2014-3-4
 * @since 1.0
 */
public class BasicAction {

    public static void main(String[] args) {
        // sample1();
        sample2();
    }



    public static void sample1() {
        String url = "http://api.map.baidu.com/place/v2/search?&q=%E9%A5%AD%E5%BA%97&region=%E5%8C%97%E4%BA%AC&output=json&ak=6A8VR8pzeGMI1EwGDVQUkvHU";
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                try {
                    // do something useful
                    BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
                    String str = null;
                    while ((str = reader.readLine()) != null) {
                        System.out.println(str);
                    }
                } finally {
                    instream.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void sample2() {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            String url = "http://api.map.baidu.com/place/v2/search?&q=%E9%A5%AD%E5%BA%97&region=%E5%8C%97%E4%BA%AC&output=json&ak=6A8VR8pzeGMI1EwGDVQUkvHU";
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String str = new String(EntityUtils.toByteArray(entity));
                System.out.println(str);
            }
            // if (entity != null) {
            // long len = entity.getContentLength();
            // System.out.println(len);
            // if (len != -1) {
            // System.out.println(EntityUtils.toString(entity));
            // } else {
            // InputStream instream = entity.getContent();
            // try {
            // // do something useful
            // BufferedReader reader = new BufferedReader(new
            // InputStreamReader(instream));
            // String str = null;
            // while ((str = reader.readLine()) != null) {
            // System.out.println(str);
            // }
            // } finally {
            // instream.close();
            // }
            // }
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
