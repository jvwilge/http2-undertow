package nl.jpoint;

import io.undertow.server.HttpServerExchange;
import io.undertow.servlet.spec.HttpServletRequestImpl;
import io.undertow.util.Methods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

public class MyServlet extends HttpServlet {

	// Mapped to https://localhost:8443/hello-world/api/hello
	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

		HttpServletRequestImpl r = (HttpServletRequestImpl) req;

		HttpServerExchange exchange = r.getExchange();
		exchange.getConnection().pushResource("/hello-world/api/again", Methods.GET, exchange.getRequestHeaders());

		PrintWriter writer = resp.getWriter();
		writer.write("Hello, World! @ " + Instant.now().toString() + "\n");
		writer.close();
	}

}