/**
 * 
 */
package zhouweiTest;

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
 * @date 2014-6-19
 * @since 1.0
 */
public class Version {

    public static void main(String args[]) {

        HttpURLConnection conn = null;
        try {
            URL url = new URL("http://192.168.2.11:8080/round_server/setting/version.do");
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
            bean.put("appVersion", "1.1");
            bean.put("appName", "Round_Phone_B");
            bean.put("os", "android");

            req.put("cid", 3141);
            req.put("identifier", "");
            req.put("request", JSON.toJSONString(bean));
            System.out.println(JSON.toJSONString(req));
            os.write(JSON.toJSONString(req).getBytes());
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
