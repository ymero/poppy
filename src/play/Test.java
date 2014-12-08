/**
 * 
 */
package play;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * simple introduction
 * 
 * @author wangz
 * @date 2014-6-24
 * @since 1.0
 */
public class Test {

    public static void main(String args[]) {

        HttpURLConnection conn = null;
        try {
            URL url = new URL("http://192.168.2.11:9000/play_anti/area/getAreaList");
            conn = ( HttpURLConnection ) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            OutputStream os = conn.getOutputStream();

            Map<String, Object> req = new HashMap<String, Object>();
            Map<String, Object> bean = new HashMap<String, Object>();
            bean.put("areaType", "wangz@8space.com");
            bean.put("areaName", "111111");
            bean.put("limit", 1);
            bean.put("start", 1);
            bean.put("sort", "yt");

            req.put("request", JSON.toJSONString(bean));
            System.out.println(JSON.toJSONString(req));
            os.write(JSON.toJSONString(bean).getBytes());
            os.flush();
            os.close();
            conn.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.disconnect();
        }
    }

}
