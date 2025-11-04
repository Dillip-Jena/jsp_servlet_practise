package in.app6;

import java.io.IOException;
import java.time.LocalDateTime;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/testservlet6")
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException{
        System.out.println("[Filter initialized] LoggingFilter is ready!");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{
        System.out.println("[Logging Filter] Request received at " + LocalDateTime.now());
        System.out.println("[Logging Filter] Remote IP: " + req.getRemoteAddr());

        //Pass request to next filter or servlet
        chain.doFilter(req, res);

        System.out.println("[Logging Filter] Response sent at " + LocalDateTime.now());
    }

    @Override
    public void destroy(){
        System.out.println("[Filter destroyed] Cleaning up loggingfilter....");
    }
}
