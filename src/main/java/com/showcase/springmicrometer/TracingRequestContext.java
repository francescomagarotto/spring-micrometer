package com.showcase.springmicrometer;

import java.util.Map;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.context.request.RequestContextHolder;

public class Context extends RequestContextHolder {
    private InheritableThreadLocal<Map<String, String>> tracing = new NamedThreadLocal<>()
}
