package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class UserManager implements ServletContextListener, HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		ServletContext ctx = se.getSession().getServletContext();

		synchronized (ctx) {
			int count = (Integer) ctx.getAttribute("user_count");
			ctx.setAttribute("user_count", ++count);
		}
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext ctx = se.getSession().getServletContext();

		synchronized (ctx) {
			int count = (Integer) ctx.getAttribute("user_count");
			ctx.setAttribute("user_count", --count);
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("user_count", 0);
	}

	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("user_count", 0);
	}

}
