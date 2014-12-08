/**
 * 
 */
package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * simple introduction
 * 
 * @author wangz
 * @date 2014-6-14
 * @since 1.0
 */
public class Test {

    public static void main(String[] args) throws Exception {
        jdbc();
    }



    public static void jdbc() throws Exception {
        Class.forName("org.postgresql.Driver").newInstance();
        String url = "jdbc:postgresql://192.168.1.9:5444/jh_proenv";
        // myDB为数据库名
        String user = "jh_proenv";
        String password = "jh123";
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement st = conn.createStatement();
        Statement st1 = conn.createStatement();
        String sql = " select interflowcode from storage_detail ";
        ResultSet rs = st.executeQuery(sql);
        int count = 0;
        while (rs.next()) {
            String trayCode = String.valueOf((++count / 80) + 1);
            String sqlStr = " INSERT INTO tray_info ( traycode, flowcode ) " + " VALUES (' " + trayCode + " ','"
                + rs.getString(1) + "')";
            System.out.println(sqlStr);
            st1.addBatch(sqlStr);
            if (count % 1000 == 0) {
                st1.executeBatch();
                st1.clearBatch();
            }
        }
        st1.executeBatch();
    }

}
