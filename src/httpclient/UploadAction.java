package httpclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

import com.alibaba.fastjson.JSON;

public class UploadAction {
    public static void main(String[] args) throws FileNotFoundException {
        File targetFile1 = new File("F:\\2.jpg");
        // File targetFile2 = new File("F:\\1.jpg");
        FileInputStream fis1 = new FileInputStream(targetFile1);
        // FileInputStream fis2 = new FileInputStream(targetFile2);
//        String targetURL = "http://static.fangbiandian.com.cn/round_server/upload/uploadFile.do";
        String targetURL = "http://www.fangbiandian.com.cn/round_server/user/updateUserInfo.do";
        HttpPost filePost = new HttpPost(targetURL);
        try {
            // 通过以下方法可以模拟页面参数提交
            HttpClient client = new DefaultHttpClient();
//            FormBodyPart fbp1 = new FormBodyPart("file1", new FileBody(targetFile1));
            // FormBodyPart fbp2 = new FormBodyPart("file2", new
            // FileBody(targetFile2));
            // FormBodyPart fbp3 = new FormBodyPart("file3", new
            // FileBody(targetFile3));
            // List<FormBodyPart> picList = new ArrayList<FormBodyPart>();
            // picList.add(fbp1);
            // picList.add(fbp2);
            // picList.add(fbp3);
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("userId", "65478A5CD8D20C3807EE16CF22AF8A17");
            Map<String, Object> map = new HashMap<String, Object>();
            String jsonStr = JSON.toJSONString(paramMap);
            map.put("cid", 321);
            map.put("request", jsonStr);
            String jsonString = JSON.toJSONString(map);
            MultipartEntity multiEntity = new MultipartEntity();
            Charset charset = Charset.forName("UTF-8");
            multiEntity.addPart("request", new StringBody(jsonString, charset));
            multiEntity.addPart("photo", new InputStreamBody(fis1, "2.jpg"));
            // multiEntity.addPart("licenseUrl", new InputStreamBody(fis2,
            // "1.jpg"));
            filePost.setEntity(multiEntity);
            HttpResponse response = client.execute(filePost);
            int code = response.getStatusLine().getStatusCode();
            System.out.println(code);
            if (HttpStatus.SC_OK == code) {
                System.out.println("上传成功");
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
            } else {
                System.out.println("上传失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            filePost.releaseConnection();
        }
    }
}
