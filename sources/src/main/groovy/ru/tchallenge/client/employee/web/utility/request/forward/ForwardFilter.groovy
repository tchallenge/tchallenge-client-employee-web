package ru.tchallenge.client.employee.web.utility.request.forward

import groovy.transform.TypeChecked

import java.util.regex.Pattern
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.springframework.web.filter.OncePerRequestFilter

@TypeChecked
class ForwardFilter extends OncePerRequestFilter {

    Collection<String> exclusions
    String target

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {
        String contextPath = request.getContextPath()
        String uri = request.getRequestURI().substring(contextPath.length())
        if (bypass(uri)) {
            filterChain.doFilter(request, response)
        } else {
            request.getRequestDispatcher(target).forward(request, response)
        }
    }

    private boolean bypass(String uri) {
        exclusions
                .stream()
                .map { String it -> matches(uri, it) }
                .filter { Boolean it -> it }
                .findFirst()
                .present
    }

    private static Boolean matches(String uri, String exclusion) {
        Pattern.compile(exclusion).matcher(uri).matches()
    }
}
