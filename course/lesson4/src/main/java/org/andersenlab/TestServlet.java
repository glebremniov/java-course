package org.andersenlab;

import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");
    var out = response.getWriter();
    out.println("test");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/json");
    var requestBody = getBody(request);

    var out = response.getWriter();
    out.printf("""
        {
          "message": "Response from servlet",
          "requestBody": %s
        }
        """, requestBody);
  }

  private String getBody(HttpServletRequest request) throws IOException {
    return request.getReader().lines().collect(Collectors.joining());
  }

}
