package com.showcase.springmicrometer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class HeaderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        Map<String, String> tracingHeader = TracingRequestContext.getTracingHeaders();
        String header = request.getHeader("tracing-label");
        if (header == null || header.isEmpty()) {
            tracingHeader.put("tracing-label", "showcase");
        }
        TracingRequestContext.setTracingHeaders(tracingHeader);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
