package com.showcase.springmicrometer;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.context.request.RequestContextHolder;

public class TracingRequestContext extends RequestContextHolder {

    private static final ThreadLocal<Map<String, String>> tracingHeaders = InheritableThreadLocal.withInitial(
            HashMap::new);

    public static Map<String, String> getTracingHeaders() {
        return tracingHeaders.get();
    }

    public static void setTracingHeaders(Map<String, String> tracingHeadersParam) {
        tracingHeaders.set(tracingHeadersParam);
    }
}
