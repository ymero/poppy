/*****************************************************************************
 * 周围
 *****************************************************************************
 * ActiveDetailBean.java
 *----------------------------------------------------------------------------
 * (C) 沈阳八维时空科技发展
 *     SHENYANG EIGHTSPACE TECHNOLOGY DEVELOPMENT CO.,LTD.  2012
 *----------------------------------------------------------------------------
 * Version    Date       By            Comment
 * 1.0        2014-3-10    wangz       新建
 *****************************************************************************/
package com.shdy.httpclient.study;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

/**
 * 活动详情Bean
 * 
 * @author wangz
 * @date 2014-3-10
 * @since 1.0
 */
public class ActiveDetailBean implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = -306084774843982242L;

    /**
     * 活动类型汉语名称
     */
    private String activeTypeName;

    /**
     * 活动具体表现行为
     */
    private String action;



    /**
     * @return the activeTypeName
     */
    public String getActiveTypeName() {
        return activeTypeName;
    }



    /**
     * @param activeTypeName
     *            the activeTypeName to set
     */
    public void setActiveTypeName(String activeTypeName) {
        this.activeTypeName = activeTypeName;
    }



    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }



    /**
     * @param action
     *            the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }



    public static void main(String[] args) {
        try {
            File targetFile2 = new File("F:\\hou.JPG");
            FileInputStream fis2 = new FileInputStream(targetFile2);
            File targetFile3 = new File("F:\\3.JPG");
            FileInputStream fis3 = new FileInputStream(targetFile3);
            System.out.println(fis2.getClass().getName());
            System.out.println(fis3.getClass().getName());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
