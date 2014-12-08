/*****************************************************************************
 * 安徽食品药品监督管理局追溯系统
 *****************************************************************************
 * SendEmail.java
 *----------------------------------------------------------------------------
 * (C) 沈阳八维时空科技发展
 *     SHENYANG EIGHTSPACE TECHNOLOGY DEVELOPMENT CO.,LTD.  2014
 *----------------------------------------------------------------------------
 * Version    Date       By            Comment
 * 1.0        2014-12-5    Poppy       新建
 *****************************************************************************/
package sendEmail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * 发送邮件
 * 
 * @author Poppy
 * @date 2014-12-5
 * @since 1.0
 */
public class SendEmail {
    public static void main(String[] args) {
        try {
            SimpleEmail email = new SimpleEmail();
            // 邮件服务器验证：邮箱，密码
            email.setAuthentication("XXX@qq.com", "XXX");
            // 发送邮箱的服务器，qq的就是smtp.qq.com，google的就是smtp.google.com
            email.setHostName("smtp.qq.com");
            // 必须放在前面，否则乱码
            email.setCharset("UTF-8");
            // 邮件发送者
            email.setFrom("XXX@qq.com", "发件人名称");
            // 邮件接收者
            email.addTo("wang_z@neunn.com");
            // 邮件主题
            email.setSubject("测试邮件");
            // 邮件内容
            email.setMsg("这是一封测试邮件");
            // 发送邮件
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
