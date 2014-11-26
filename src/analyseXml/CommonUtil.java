/**
 * 
 */
package analyseXml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 消息工具类
 * 
 * @author wangz
 * @date 2014-5-5
 * @since 1.0
 */
public class CommonUtil {

    /**
     * 将xml请求解析成bean
     * 
     * @author wangz
     * @date 2014-5-5
     * @param request
     * @return
     * @throws Exception
     *             Map<String,String>
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> analysisXml(HttpServletRequest request) throws Exception {
        // 定义返回结果
        Map<String, String> map = new HashMap<String, String>();
        // 从request中取得输入流数据
        InputStream inputStream = request.getInputStream();
        // 将输入流读取成xml形式
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 获取xml根元素
        Element root = document.getRootElement();
        // 获取根元素的所有子节点
        List<Element> elementList = root.elements();
        // 循环所有子节点，将节点名称作为key,内容作为value，放到map中
        for (Element e : elementList)
            map.put(e.getName(), e.getText());
        // 关闭输入流
        inputStream.close();
        // 返回map
        return map;
    }



    /**
     * 将文本消息TextMsgBean转成xml返回
     * 
     * @author wangz
     * @date 2014-5-5
     * @param respTextMsgBean
     * @return String
     */
//    public static String textMessageToXml(RespTextMsgBean respTextMsgBean) {
//        XStream xs = new XStream();
//        xs.alias("xml", RespTextMsgBean.class);
//        return xs.toXML(respTextMsgBean);
//    }



    /**
     * 将图文消息RespNewMsgBean转成xml返回
     * 
     * @author wangz
     * @date 2014-5-5
     * @param respNewMsgBean
     * @return String
     */
//    public static String newsMessageToXml(RespNewMsgBean respNewMsgBean) {
//        XStream xs = new XStream();
//        xs.alias("xml", RespNewMsgBean.class);
//        xs.alias("item", new RespArticleMsgBean().getClass());
//        return xs.toXML(respNewMsgBean);
//    }

    /**
     * 扩展XStream使其支持CDATA块
     * 
     * @author wangz
     * @date 2014-5-5
     * @param textMsgBean
     * @return String
     */
//    @SuppressWarnings("unused")
//    private static XStream xstream = new XStream(new XppDriver() {
//        public HierarchicalStreamWriter createWriter(Writer out) {
//            return new PrettyPrintWriter(out) {
//                // 对所有xml节点的转换都增加CDATA标记
//                boolean cdata = true;
//
//
//
//                @SuppressWarnings("rawtypes")
//                public void startNode(String name, Class clazz) {
//                    super.startNode(name, clazz);
//                }
//
//
//
//                protected void writeText(QuickWriter writer, String text) {
//                    if (cdata) {
//                        writer.write("<![CDATA[");
//                        writer.write(text);
//                        writer.write("]]>");
//                    } else {
//                        writer.write(text);
//                    }
//                }
//            };
//        }
//    });

}
