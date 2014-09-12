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
public class ECInfo {
    /**
     * ҵ�����
     */
    private String prodId;
    
    /**
     * ҵ����Ϣ
     */
    private List<ChildECInfo> childECInfoList = new ArrayList<ChildECInfo>();

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public List<ChildECInfo> getChildECInfoList() {
        return childECInfoList;
    }

    public void setChildECInfoList(List<ChildECInfo> childECInfoList) {
        this.childECInfoList = childECInfoList;
    }
    
  
    
}
