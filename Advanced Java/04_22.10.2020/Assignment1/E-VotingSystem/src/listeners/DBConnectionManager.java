package listeners;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.DBUtils;

@WebListener
public class DBConnectionManager implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		try {
			DBUtils.cleanup();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		try {
			DBUtils.createSingletonConnection(ctx.getInitParameter("driver_class"), ctx.getInitParameter("db_url"),
					ctx.getInitParameter("username"), ctx.getInitParameter("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
