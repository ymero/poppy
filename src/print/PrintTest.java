/*****************************************************************************
 * 安徽食品药品监督管理局追溯系统
 *****************************************************************************
 * PrintTest.java
 *----------------------------------------------------------------------------
 * (C) 沈阳八维时空科技发展
 *     SHENYANG EIGHTSPACE TECHNOLOGY DEVELOPMENT CO.,LTD.  2014
 *----------------------------------------------------------------------------
 * Version    Date       By            Comment
 * 1.0        2014-11-14    Poppy       新建
 *****************************************************************************/
package print;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * java将数据导成pdf，自己再打印
 * 
 * @author Poppy
 * @date 2014-11-14
 * @since 1.0
 */
public class PrintTest implements Printable {

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.print.Printable#print(java.awt.Graphics,
     * java.awt.print.PageFormat, int)
     */
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        System.out.println("pageIndex=" + pageIndex);
        Component c = null;
        // print string
        String str1 = "XXXXX销售单        No.123456789012";
        String str2 = "发货单号：  2014112171809";
        String str3 = "开单单位：  安徽古井贡酒股份有限公司        收货单位：  安徽省芜湖市巴拉巴拉有限公司";
        String str4 = "单位摘要：  起来不愿做奴隶的人们，把我们的血肉组成我们新的长城~";
        String str5 = "商品名称";
        String str6 = "规格";
        String str7 = "条形码";
        String str8 = "生产批号";
        String str9 = "单位";
        String str10 = "数量";
        // 转换成Graphics2D
        Graphics2D g2 = ( Graphics2D ) graphics;
        // 设置打印颜色为黑色
        g2.setColor(Color.black);
        // 打印起点坐标
        double x = pageFormat.getImageableX();
        double y = pageFormat.getImageableY();
        switch (pageIndex) {
            case 0:
                // 设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
                // Java平台所定义的五种字体系列：Serif、SansSerif、Monospaced、Dialog 和
                // 第三个参数10指的是字的大小
                Font font = new Font("新宋体", Font.PLAIN, 10);
                g2.setFont(font);// 设置字体
                BasicStroke bs_3 = new BasicStroke(0.5f);
                float[] dash1 = { 2.0f };
                // 设置打印线的属性。
                // 1.线宽 2、3、不知道，4、空白的宽度，5、虚线的宽度，6、偏移量
                g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));
                // 设置线宽
                g2.setStroke(bs_3);
                // 字体高度
                float heigth = font.getSize2D();
                System.out.println("x=" + x);
                // -1- 用Graphics2D直接输出
                // 首字符的基线(右下部)位于用户空间中的 (x, y) 位置处
                // g2.drawLine(10, 10, 200, 300);
                // 打印图片，括号里写上本地图片的路径
                Image src = Toolkit.getDefaultToolkit().getImage("");
                g2.drawImage(src, ( int ) x, ( int ) y, c);
                int img_Height = src.getHeight(c);
                int img_width = src.getWidth(c);
                System.out.println("img_Height=" + img_Height + "img_width=" + img_width);
                g2.drawString(str1, ( float ) x, ( float ) y + 1 * heigth + img_Height);
                g2.drawString(str2, ( float ) x, ( float ) y + 1 * heigth + img_Height + 30);
                g2.drawString(str3, ( float ) x, ( float ) y + 1 * heigth + img_Height + 60);
                g2.drawString(str4, ( float ) x, ( float ) y + 1 * heigth + img_Height + 90);
                g2.drawLine(( int ) x, ( int ) (y + 1 * heigth + img_Height + 10), ( int ) x + 200, ( int ) (y + 1
                    * heigth + img_Height + 10));
                // 开始画表头
                g2.drawLine(( int ) x, ( int ) (y + 1 * heigth + img_Height + 120), ( int ) x + 480, ( int ) (y + 1
                    * heigth + img_Height + 120));
                g2.drawLine(( int ) x, ( int ) (y + 1 * heigth + img_Height + 120), ( int ) x, ( int ) (y + 1 * heigth
                    + img_Height + 140));
                g2.drawString(str5, ( float ) x, ( float ) y + 1 * heigth + img_Height + 135);
                g2.drawLine(( int ) x + 150, ( int ) (y + 1 * heigth + img_Height + 120), ( int ) x + 150, ( int ) (y
                    + 1 * heigth + img_Height + 140));
                g2.drawString(str6, ( float ) x + 150, ( float ) y + 1 * heigth + img_Height + 135);
                g2.drawLine(( int ) x + 200, ( int ) (y + 1 * heigth + img_Height + 120), ( int ) x + 200, ( int ) (y
                    + 1 * heigth + img_Height + 140));
                g2.drawString(str7, ( float ) x + 200, ( float ) y + 1 * heigth + img_Height + 135);
                g2.drawLine(( int ) x + 300, ( int ) (y + 1 * heigth + img_Height + 120), ( int ) x + 300, ( int ) (y
                    + 1 * heigth + img_Height + 140));
                g2.drawString(str8, ( float ) x + 300, ( float ) y + 1 * heigth + img_Height + 135);
                g2.drawLine(( int ) x + 400, ( int ) (y + 1 * heigth + img_Height + 120), ( int ) x + 400, ( int ) (y
                    + 1 * heigth + img_Height + 140));
                g2.drawString(str9, ( float ) x + 400, ( float ) y + 1 * heigth + img_Height + 135);
                g2.drawLine(( int ) x + 440, ( int ) (y + 1 * heigth + img_Height + 120), ( int ) x + 440, ( int ) (y
                    + 1 * heigth + img_Height + 140));
                g2.drawString(str10, ( float ) x + 440, ( float ) y + 1 * heigth + img_Height + 135);
                g2.drawLine(( int ) x + 480, ( int ) (y + 1 * heigth + img_Height + 120), ( int ) x + 480, ( int ) (y
                    + 1 * heigth + img_Height + 140));
                g2.drawLine(( int ) x, ( int ) (y + 1 * heigth + img_Height + 140), ( int ) x + 480, ( int ) (y + 1
                    * heigth + img_Height + 140));
                // 画表头结束
                // 开始画表格内容
                g2.drawLine(( int ) x, ( int ) (y + 1 * heigth + img_Height + 140), ( int ) x, ( int ) (y + 1 * heigth
                    + img_Height + 160));
                g2.drawString("42度 古井贡酒 兰花淡雅 450ml", ( float ) x, ( float ) y + 1 * heigth + img_Height + 155);
                g2.drawLine(( int ) x + 150, ( int ) (y + 1 * heigth + img_Height + 140), ( int ) x + 150, ( int ) (y
                    + 1 * heigth + img_Height + 160));
                g2.drawString("450ml", ( float ) x + 150, ( float ) y + 1 * heigth + img_Height + 155);
                g2.drawLine(( int ) x + 200, ( int ) (y + 1 * heigth + img_Height + 140), ( int ) x + 200, ( int ) (y
                    + 1 * heigth + img_Height + 160));
                g2.drawString("4902018771078", ( float ) x + 200, ( float ) y + 1 * heigth + img_Height + 155);
                g2.drawLine(( int ) x + 300, ( int ) (y + 1 * heigth + img_Height + 140), ( int ) x + 300, ( int ) (y
                    + 1 * heigth + img_Height + 160));
                g2.drawString("20141110", ( float ) x + 300, ( float ) y + 1 * heigth + img_Height + 155);
                g2.drawLine(( int ) x + 400, ( int ) (y + 1 * heigth + img_Height + 140), ( int ) x + 400, ( int ) (y
                    + 1 * heigth + img_Height + 160));
                g2.drawString("瓶", ( float ) x + 400, ( float ) y + 1 * heigth + img_Height + 155);
                g2.drawLine(( int ) x + 440, ( int ) (y + 1 * heigth + img_Height + 140), ( int ) x + 440, ( int ) (y
                    + 1 * heigth + img_Height + 160));
                g2.drawString("1", ( float ) x + 440, ( float ) y + 1 * heigth + img_Height + 155);
                g2.drawLine(( int ) x + 480, ( int ) (y + 1 * heigth + img_Height + 140), ( int ) x + 480, ( int ) (y
                    + 1 * heigth + img_Height + 160));
                g2.drawLine(( int ) x, ( int ) (y + 1 * heigth + img_Height + 160), ( int ) x + 480, ( int ) (y + 1
                    * heigth + img_Height + 160));
                // 画表格内容结束
                g2.drawImage(src, ( int ) x, ( int ) (y + 1 * heigth + img_Height + 11), c);
                return PAGE_EXISTS;
            default:
                return NO_SUCH_PAGE;
        }
    }



    public static void main(String[] args) {
        // 通俗理解就是书、文档
        Book book = new Book();
        PageFormat pf = new PageFormat();
        // 设置成横打
        pf.setOrientation(PageFormat.REVERSE_LANDSCAPE);
        // 设置成竖打
        // pf.setOrientation(PageFormat.PORTRAIT);
        // 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
        Paper p = new Paper();
        // 纸张大小
        p.setSize(590, 840);
        // double x, double y, double width, double height
        // p.setImageableArea(10, 10, 590, 840);
        // 横打这样子配置
        p.setImageableArea(-72, 72, 590, 840);
        // 竖着大这样子配置
        // p.setImageableArea(72, 72, 590, 840);
        // A4(595 X 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
        pf.setPaper(p);
        // 把 PageFormat 和 Printable 添加到书中，组成一个页面
        book.append(new PrintTest(), pf);
        // 获取打印服务对象
        PrinterJob job = PrinterJob.getPrinterJob();
        // 设置打印类
        job.setPageable(book);
        try {
            // 可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
            boolean a = job.printDialog();
            if (a) {
                job.print();
            }
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
}
