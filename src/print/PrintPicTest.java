/*****************************************************************************
 * 安徽食品药品监督管理局追溯系统
 *****************************************************************************
 * PrintPic.java
 *----------------------------------------------------------------------------
 * (C) 沈阳八维时空科技发展
 *     SHENYANG EIGHTSPACE TECHNOLOGY DEVELOPMENT CO.,LTD.  2014
 *----------------------------------------------------------------------------
 * Version    Date       By            Comment
 * 1.0        2014-11-19    Poppy       新建
 *****************************************************************************/
package print;

import java.awt.Color;
import java.awt.Component;
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
 * 打印图片
 * 
 * @author Poppy
 * @date 2014-11-19
 * @since 1.0
 */
public class PrintPicTest implements Printable {

    private Image src;

    private Component c = null;

    private int endX;

    private int endY;



    /*
     * (non-Javadoc)
     * 
     * @see java.awt.print.Printable#print(java.awt.Graphics,
     * java.awt.print.PageFormat, int)
     */
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

        // 转换成Graphics2D
        Graphics2D g2 = ( Graphics2D ) graphics;
        // 设置打印颜色为黑色
        g2.setColor(Color.black);
        // 打印起点坐标
        int startX = ( int ) pageFormat.getImageableX();
        int startY = ( int ) pageFormat.getImageableY();
        switch (pageIndex) {
            case 0:
                // 开始画图片的位置
                g2.drawImage(src, startX, startY, endX, endY, c);
                return PAGE_EXISTS;
            default:
                return NO_SUCH_PAGE;
        }
    }



    public static void main(String[] args) {
        PrintPicTest printPicTest = new PrintPicTest();
        // 打印图片，括号里写上本地图片的路径
        printPicTest.src = Toolkit.getDefaultToolkit().getImage("F:\\longmao.jpg");
        // 设置图片的宽
        int img_width = printPicTest.src.getWidth(printPicTest.c);
        long ctm1 = System.currentTimeMillis();
        // 如果宽是-1说明不知道宽是多少，意思就是说，这个时候图片还没有读取完，所以循环，一直到读取到了就跳出，如果一直读取不到，那么30秒后自动跳出。
        while (img_width == -1) {
            img_width = printPicTest.src.getWidth(printPicTest.c);
            long ctm2 = System.currentTimeMillis();
            if (ctm2 - ctm1 > 30000) {
                break;
            }
        }
        // 设置图片的高
        int img_Height = printPicTest.src.getHeight(printPicTest.c);
        long ctm3 = System.currentTimeMillis();
        // 如果长是-1说明不知道宽是多少，意思就是说，这个时候图片还没有读取完，所以循环，一直到读取到了就跳出，如果一直读取不到，那么30秒后自动跳出。
        while (img_width == -1) {
            img_Height = printPicTest.src.getHeight(printPicTest.c);
            long ctm4 = System.currentTimeMillis();
            if (ctm4 - ctm3 > 30000) {
                break;
            }
        }
        System.out.println(img_Height + "," + img_width);
        // 通俗理解就是书、文档
        Book book = new Book();
        // PageFomat，这个设置完了要放到book中的
        PageFormat pf = new PageFormat();
        // 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
        Paper p = new Paper();
        // 纸张大小
        p.setSize(590, 840);
        // p.setImageableArea(10, 10, 590, 840);
        // A4(595 X 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
        if (img_Height > img_width) {
            // 高大于宽，竖着打
            pf.setOrientation(PageFormat.PORTRAIT);
            // 竖着大这样子配置
            p.setImageableArea(72, 72, 446, 696);
        } else {
            // 宽大于高，横着打
            pf.setOrientation(PageFormat.REVERSE_LANDSCAPE);
            // 横打这样子配置
            p.setImageableArea(72, 72, 446, 696);
        }
        printPicTest.endX = img_width;
        printPicTest.endY = img_Height;
        pf.setPaper(p);
        // 把 PageFormat 和 Printable 添加到书中，组成一个页面
        book.append(printPicTest, pf);
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
