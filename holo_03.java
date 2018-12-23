package holo_03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class holo_03
 */
@WebServlet("/holo_03")
public class holo_03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public holo_03() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		
		int intCnt=0;
		
		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("CNT")!=null)
		{
			intCnt=(Integer)session.getAttribute("CNT");
		}
		
		if(request.getParameter("CNTUP")!=null)
		{
			intCnt++;
			if(intCnt>=10)
			{
				intCnt=10;
			}
			session.setAttribute("CNT", intCnt);
		}
		else if(request.getParameter("CNTDOWN")!=null)
		{
			intCnt--;
			if(intCnt<=-10)
			{
				intCnt=-10;
			}
			session.setAttribute("CNT", intCnt);
		}
		else if(request.getParameter("CLR")!=null)
		{
			session.removeAttribute("CNT");
		}
		RequestDispatcher disp = request.getRequestDispatcher("result_03.jsp");
		disp.forward(request, response);
	}

}
