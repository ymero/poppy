package analyseXml;
import java.math.BigDecimal;

/**
 * 
 */

/**
 * 字符串替换
 * 
 * @author wangz
 * @date 2014-7-3
 * @since 1.0
 */
public class ReplaceStrInXml {
    public static void main(String[] args) {
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "lalala";
        String sss = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        String ss = s.replace(sss, "");
        System.out.println(ss);

        BigDecimal b = new BigDecimal((1.01) * Math.pow(10, 20));
        System.out.println(b.toString());
        System.out.println(b.toPlainString());
    }
}
