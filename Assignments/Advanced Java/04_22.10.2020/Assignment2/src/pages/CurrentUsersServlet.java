package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/current_users")
public class CurrentUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {

			HttpSession session = request.getSession();
			ServletContext ctx = session.getServletContext();
			int userCount = 0;

			// Applying Thread Safety to Context Attribute
			synchronized (ctx) {
				userCount = (Integer) ctx.getAttribute("user_count");
			}

			pw.print("<h1>Current Users : " + userCount + "</h1><br><br>");
			pw.print("<h3><a href='logout'>LOGOUT</h3>");
		}
	}

}
