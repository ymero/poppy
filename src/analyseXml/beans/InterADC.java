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
public class InterADC {
    /**
     * �ļ���ˮ��
     */
    private String fileSeq;
    
    /**
     * ������ϵ��¼
     */
    private List<OrdData> ordDataList = new ArrayList<OrdData>();

    public String getFileSeq() {
        return fileSeq;
    }

    public void setFileSeq(String fileSeq) {
        this.fileSeq = fileSeq;
    }

    public List<OrdData> getOrdDataList() {
        return ordDataList;
    }

    public void setOrdDataList(List<OrdData> ordDataList) {
        this.ordDataList = ordDataList;
    }
    
    

}
