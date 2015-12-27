package nl.jpoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

public class MyServlet2 extends HttpServlet {

	// Mapped to https://localhost:8443/hello-world/api/again
	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		writer.write("This was alreay pushed @ " + Instant.now().toString() + "\n");
		writer.close();
	}

}