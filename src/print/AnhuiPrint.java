/*****************************************************************************
 * 安徽食品药品监督管理局追溯系统
 *****************************************************************************
 * Print.java
 *----------------------------------------------------------------------------
 * (C) 沈阳八维时空科技发展
 *     SHENYANG EIGHTSPACE TECHNOLOGY DEVELOPMENT CO.,LTD.  2014
 *----------------------------------------------------------------------------
 * Version    Date       By            Comment
 * 1.0        2014-11-17    Poppy       新建
 *****************************************************************************/
package print;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * 打印销售单方法
 * 
 * @author Poppy
 * @date 2014-11-17
 * @since 1.0
 */
public class AnhuiPrint implements Printable {

    /**
     * 发货单号
     */
    private String salesCode;

    /**
     * 发送单位
     */
    private String sendBy;

    /**
     * 收货单位
     */
    private String receiver;

    /**
     * 单据摘要
     */
    public String remarks;

    /**
     * 销售名称title
     */
    private String title;

    /**
     * 销售单号
     */
    private String number;

    /**
     * 总页数
     */
    private Integer totalPage;



    /*
     * (non-Javadoc)
     * 
     * @see java.awt.print.Printable#print(java.awt.Graphics,
     * java.awt.print.PageFormat, int)
     */
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        System.out.println(pageIndex);
        Graphics2D g2 = ( Graphics2D ) graphics;
        g2.setColor(Color.black);
        // 72
        double x = pageFormat.getImageableX();
        // 72
        double y = pageFormat.getImageableY();
        String str1 = title + "        " + number;
        String str2 = "发货单号：  " + salesCode;
        String str3 = "开单单位：  " + sendBy + "        收货单位：  " + receiver;
        String str4 = "单位摘要：  " + remarks;
        String str5 = " 商品名称";
        String str6 = " 规格";
        String str7 = " 条形码";
        String str8 = " 生产批号";
        String str9 = " 单位";
        String str10 = " 数量";
        String str11 = "第" + (pageIndex + 1) + "页/共" + totalPage + "页";
        Font font = new Font("新宋体", Font.PLAIN, 10);
        g2.setFont(font);
        BasicStroke bs_3 = new BasicStroke(0.5f);
        float[] dash1 = { 2.0f };
        g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));
        g2.setStroke(bs_3);
        // 这个距离是10
        float heigth = font.getSize2D();
        // 定义表格距离，共690
        int width1 = 250;
        int width2 = width1 + 60;
        int width3 = width2 + 130;
        int width4 = width3 + 130;
        int width5 = width4 + 60;
        int width6 = width5 + 60;
        // 行与行间隔
        int height1 = 20;
        // 行与字间隔
        int height2 = 15;
        if (pageIndex >= 0) {
            // 定义起始位置
            int startX = ( int ) x;
            int startY = ( int ) (y + 1 * heigth + 140);
            // 画销售单据头信息
            g2.drawString(str1, ( float ) x, ( float ) y + 1 * heigth);
            g2.drawLine(( int ) x, ( int ) (y + 1 * heigth + 10), ( int ) x + 280, ( int ) (y + 1 * heigth + 10));
            g2.drawString(str11, ( float ) x + 630, ( float ) y + 1 * heigth);
            g2.drawLine(( int ) x + 630, ( int ) (y + 1 * heigth + 10), ( int ) x + 690, ( int ) (y + 1 * heigth + 10));
            g2.drawString(str2, ( float ) x, ( float ) y + 1 * heigth + 30);
            g2.drawString(str3, ( float ) x, ( float ) y + 1 * heigth + 60);
            g2.drawString(str4, ( float ) x, ( float ) y + 1 * heigth + 90);
            // 开始画表头
            g2.drawLine(( int ) x, ( int ) (y + 1 * heigth + 120), ( int ) x + width6, ( int ) (y + 1 * heigth + 120));
            g2.drawLine(( int ) x, ( int ) (y + 1 * heigth + 120), ( int ) x, ( int ) (y + 1 * heigth + 140));
            g2.drawString(str5, ( float ) x, ( float ) y + 1 * heigth + 135);
            g2.drawLine(( int ) x + width1, ( int ) (y + 1 * heigth + 120), ( int ) x + width1,
                ( int ) (y + 1 * heigth + 140));
            g2.drawString(str6, ( float ) x + width1, ( float ) y + 1 * heigth + 135);
            g2.drawLine(( int ) x + width2, ( int ) (y + 1 * heigth + 120), ( int ) x + width2,
                ( int ) (y + 1 * heigth + 140));
            g2.drawString(str7, ( float ) x + width2, ( float ) y + 1 * heigth + 135);
            g2.drawLine(( int ) x + width3, ( int ) (y + 1 * heigth + 120), ( int ) x + width3,
                ( int ) (y + 1 * heigth + 140));
            g2.drawString(str8, ( float ) x + width3, ( float ) y + 1 * heigth + 135);
            g2.drawLine(( int ) x + width4, ( int ) (y + 1 * heigth + 120), ( int ) x + width4,
                ( int ) (y + 1 * heigth + 140));
            g2.drawString(str9, ( float ) x + width4, ( float ) y + 1 * heigth + 135);
            g2.drawLine(( int ) x + width5, ( int ) (y + 1 * heigth + 120), ( int ) x + width5,
                ( int ) (y + 1 * heigth + 140));
            g2.drawString(str10, ( float ) x + width5, ( float ) y + 1 * heigth + 135);
            g2.drawLine(( int ) x + width6, ( int ) (y + 1 * heigth + 120), ( int ) x + width6,
                ( int ) (y + 1 * heigth + 140));
            g2.drawLine(( int ) x, ( int ) (y + 1 * heigth + 140), ( int ) x + width6, ( int ) (y + 1 * heigth + 140));
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }



    /**
     * 打印销售单方法
     * 
     * @author Poppy
     * @throws PrinterException
     * @date 2014-11-17
     * @since 1.0
     */
    public static void print() throws PrinterException {
        Book book = new Book();
        PageFormat pf = new PageFormat();
        pf.setOrientation(PageFormat.REVERSE_LANDSCAPE);
        Paper p = new Paper();
        p.setSize(590, 840);
        p.setImageableArea(-72, 72, 590, 840);
        pf.setPaper(p);
        // 传参
        AnhuiPrint anhuiPrint = new AnhuiPrint();
        anhuiPrint.title = "XXXXtitle";
        anhuiPrint.salesCode = "XXXX";
        anhuiPrint.number = "XXXX";
        anhuiPrint.sendBy = "XXXXsendBy";
        anhuiPrint.receiver = "XXXXreceiver";
        anhuiPrint.remarks = "XXXX";
        anhuiPrint.totalPage = 1;
        book.append(anhuiPrint, pf, 1);
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPageable(book);
        boolean a = job.printDialog();
        if (a) {
            job.print();
        }
    }

}
