package org.andersenlab;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/test")
public class TestFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    var out = response.getWriter();

    Optional.ofNullable(((HttpServletRequest) request).getHeader("clientName"))
            .orElseThrow(() -> new RuntimeException("Very important header name is not present"));

    out.println("filter is invoked before");

    chain.doFilter(request, response); // sends request to next resource

    out.println("filter is invoked after");
  }
}
