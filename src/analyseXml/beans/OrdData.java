package analyseXml.beans;
/**
 * 
 */


import java.util.ArrayList;
import java.util.List;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author dell 2013-11-21
 * @see
 * @since 1.0
 */
public class OrdData {
    /**
     * ���ſͻ�ID
     */
    private String ecId;
    
    /**
     * ���ſͻ�����ʱ��
     */
    private String ordTime;
    
    /**
     * �û���Ϣ
     */
    private List<ECInfo> ecInfoList = new ArrayList<ECInfo>();

    public String getEcId() {
        return ecId;
    }

    public void setEcId(String ecId) {
        this.ecId = ecId;
    }

    public String getOrdTime() {
        return ordTime;
    }

    public void setOrdTime(String ordTime) {
        this.ordTime = ordTime;
    }

    public List<ECInfo> getEcInfoList() {
        return ecInfoList;
    }

    public void setEcInfoList(List<ECInfo> ecInfoList) {
        this.ecInfoList = ecInfoList;
    }
    
    

}
