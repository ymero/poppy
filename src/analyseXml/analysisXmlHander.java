package analyseXml;

/**
 * 
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import analyseXml.beans.ChildECInfo;
import analyseXml.beans.ECInfo;
import analyseXml.beans.InterADC;
import analyseXml.beans.OrdData;

/**
 * simple introduction
 * 
 * <p>
 * detailed comment
 * 
 * @author dell 2013-11-21
 * @see
 * @since 1.0
 */
public class analysisXmlHander {

    public static void ftpDownload() {
        FTPClient ftpClient = new FTPClient();
        ByteArrayOutputStream fos = null;
        try {
            ftpClient.connect("192.168.1.3");
            ftpClient.login("dingcp", "dingcp123");
            String remoteFileName = "/home/dingcp/ec_info.xml";
            fos = new ByteArrayOutputStream();
            ftpClient.setBufferSize(1024);
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.retrieveFile(remoteFileName, fos);
            ByteArrayInputStream bais = new ByteArrayInputStream(fos.toByteArray());
            try {
                InterADC interADC = analysisXml(bais);
                //System.out.println(interADC.getOrdDataList().get(0).getEcId());
                System.out.println(interADC.getOrdDataList().get(0).getEcInfoList().size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @SuppressWarnings("unchecked")
    public static InterADC analysisXml(InputStream in) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read(in);
        InterADC interADC = new InterADC();
        Element root = doc.getRootElement();
        interADC.setFileSeq(root.element("FileSeq").getText());
        List<OrdData> ordDataList = new ArrayList<OrdData>();
        List<Element> ordDataElementList = root.elements("OrdData");
        for (Element e1 : ordDataElementList) {
            OrdData ordData = new OrdData();
            ordData.setEcId(e1.element("ECID").getText());
            ordData.setOrdTime(e1.element("OrdTime").getText());
            List<ECInfo> ecInfoList = new ArrayList<ECInfo>();
            List<Element> ecInfoElementList = e1.elements("ECInfo");
            for (Element e2 : ecInfoElementList) {
                ECInfo ecInfo = new ECInfo();
                ecInfo.setProdId(e2.element("ProdID").getText());
                List<ChildECInfo> childECInfoList = new ArrayList<ChildECInfo>();
                List<Element> childECInfoElementList = e2.elements("ChildECInfo");
                for (Element e3 : childECInfoElementList) {
                    ChildECInfo childECInfo = new ChildECInfo();
                    childECInfo.setChildECID(e3.element("ChildECID").getText());
                    childECInfo.setFeeTime(e3.element("FeeTime").getText());
                    childECInfo.setOprCode(e3.element("OprCode").getText());
                    childECInfo.setPrice(e3.element("Price").getText());
                    childECInfoList.add(childECInfo);
                }
                ecInfo.setChildECInfoList(childECInfoList);
                ecInfoList.add(ecInfo);
            }
            ordData.setEcInfoList(ecInfoList);
            ordDataList.add(ordData);
        }
        interADC.setOrdDataList(ordDataList);

        return interADC;
    }



    public static void main(String[] args) {
        ftpDownload();
    }

}
