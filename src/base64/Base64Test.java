/*****************************************************************************
 * 安徽食品药品监督管理局追溯系统
 *****************************************************************************
 * Base64Test.java
 *----------------------------------------------------------------------------
 * (C) 沈阳八维时空科技发展
 *     SHENYANG EIGHTSPACE TECHNOLOGY DEVELOPMENT CO.,LTD.  2014
 *----------------------------------------------------------------------------
 * Version    Date       By            Comment
 * 1.0        2014-12-18    Poppy       新建
 *****************************************************************************/
package base64;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * base64编码解码测试类
 * 
 * @author Poppy
 * @date 2014-12-18
 * @since 1.0
 */
public class Base64Test {

    /**
     * base64给字符串编码解码示例
     * 
     * @author Poppy
     * @date 2014-12-18
     * @since 1.0
     */
    public static void test1() {
        String s = "没错，我就是泼皮少女！";
        String decodeResultStr = "";
        String encodeResultStr = "";
        try {
            // 编码
            decodeResultStr = URLEncoder.encode(s, "UTF-8");
            System.out.println("编码后结果为：" + decodeResultStr);
            // 解码
            encodeResultStr = URLDecoder.decode(decodeResultStr, "UTF-8");
            System.out.println("解码后结果为：" + encodeResultStr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        test1();
    }

}
