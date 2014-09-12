/**
 * 
 */
package chineseToPinyin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * simple introduction
 * 
 * @author wangz
 * @date 2014-6-20
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) throws Exception {
        goodsDicName();
    }



    public static void goodsDicName() throws Exception {
        List<String> list = new ArrayList<String>();
        Class.forName("org.postgresql.Driver").newInstance();
        String url = "jdbc:postgresql://192.168.1.9:5444/round_server";
        // myDB为数据库名
        String user = "round_server";
        String password = "round_server123";
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement st = conn.createStatement();
        Statement st1 = conn.createStatement();
        String sql = "select * from goods_dic ";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String name = rs.getString(2);
            // String result = getPYString(name);
            String result = PinYinUtil.getChineseSpell(name);
            String addSql = " update goods_dic set goodcode = '" + result + "' where goodname = '" + name + "'; ";
            System.out.println(addSql);
            st1.execute(addSql);
        }
    }



    /**
     * 汉字转拼音缩写
     * 
     * @param str
     *            要转换的汉字字符串
     * @return String 拼音缩写
     */
    public static String getPYString(String str) {
        String tempStr = "";
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            Matcher matcher = pattern.matcher(String.valueOf(c));
            if (matcher.matches()) {
                tempStr += getPYChar(String.valueOf(c));
            }
        }

        // if (c >= 33 && c <= 126) {// 字母和符号原样保留
        // // tempStr += String.valueOf(c);
        // } else {// 累加拼音声母
        // tempStr += getPYChar(String.valueOf(c));
        // }
        return tempStr;
    }



    /**
     * 取单个字符的拼音声母
     * 
     * @param c
     *            //要转换的单个汉字
     * @return String 拼音声母
     */
    public static String getPYChar(String c) {
        byte[] array = new byte[2];
        array = String.valueOf(c).getBytes();
        int i = ( short ) (array[0] - '\0' + 256) * 256 + (( short ) (array[1] - '\0' + 256));
        if (i < 0xB0A1)
            return "*";
        if (i < 0xB0C5)
            return "a";
        if (i < 0xB2C1)
            return "b";
        if (i < 0xB4EE)
            return "c";
        if (i < 0xB6EA)
            return "d";
        if (i < 0xB7A2)
            return "e";
        if (i < 0xB8C1)
            return "f";
        if (i < 0xB9FE)
            return "g";
        if (i < 0xBBF7)
            return "h";
        if (i < 0xBFA6)
            return "j";
        if (i < 0xC0AC)
            return "k";
        if (i < 0xC2E8)
            return "l";
        if (i < 0xC4C3)
            return "m";
        if (i < 0xC5B6)
            return "n";
        if (i < 0xC5BE)
            return "o";
        if (i < 0xC6DA)
            return "p";
        if (i < 0xC8BB)
            return "q";
        if (i < 0xC8F6)
            return "r";
        if (i < 0xCBFA)
            return "s";
        if (i < 0xCDDA)
            return "t";
        if (i < 0xCEF4)
            return "w";
        if (i < 0xD1B9)
            return "x";
        if (i < 0xD4D1)
            return "y";
        if (i < 0xD7FA)
            return "z";
        return "*";
    }
}
