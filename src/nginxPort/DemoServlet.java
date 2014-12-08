package nginxPort;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;



    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException {
        int port = request.getServerPort();
        String path = request.getServletPath();
        // request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println(path);
        ServletOutputStream out = response.getOutputStream();
        String responseContent = "�˿ںţ� " + port + ", ·����" + path;
        out.write(responseContent.getBytes());
    }

}
