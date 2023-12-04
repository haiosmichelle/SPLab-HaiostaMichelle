package ro.uvt.info.designpatternslab2023.services;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Component
@Order(1)
@Slf4j
public class TransFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        log.info("Starting a transaction for request: " + req.getRequestURI());

        try {
            chain.doFilter(request, response);
        } finally {
            log.info("Committing a transaction for request: " + req.getRequestURI());

        }
    }

}