package permission.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 检查control是否登录用户 Created by MQ on 2015/3/21.
 */
public class StatelessAuthcFilter extends AccessControlFilter {


    @Override
    protected boolean isAccessAllowed(final ServletRequest servletRequest,
                                      final ServletResponse servletResponse, final Object o)
            throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(final ServletRequest servletRequest,
                                     final ServletResponse servletResponse)
            throws Exception {
        HttpServletRequest httpServletRequest = null;
        HttpServletResponse httpServletResponse = null;
        try {
            httpServletRequest = (HttpServletRequest) servletRequest;
            httpServletResponse = (HttpServletResponse) servletResponse;
        } catch (Exception e) {
            throw new ClassCastException();
        }
/*        HttpSession session = httpServletRequest.getSession(false);
        if (session == null) {
            onLoginFail(httpServletResponse);
            return false;
        } else {
            String requestURL = httpServletRequest.getRequestURL().toString().toLowerCase();
            String apiUrl = requestURL.substring(requestURL.indexOf("/api/"));
            apiUrl = apiUrl.toLowerCase();
            apiUrl = apiUrl.replace("//", "/");
            Subject subject = SecurityUtils.getSubject();
            if (!subject.isPermitted(apiUrl)) {
                onPermissionFail(httpServletResponse);
                return false;
            }
        }*/
        return true;
    }

    /**
     * 登录失败时默认返回401状态码
     *
     * @param httpResponse Response对象
     * @throws IOException IO异常
     */
    private void onLoginFail(final HttpServletResponse httpResponse) throws IOException {
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.getWriter().write("login error");
    }

    /**
     * 登录失败时默认返回403状态码
     *
     * @param httpResponse Response对象
     * @throws IOException IO异常
     */
    private void onPermissionFail(final HttpServletResponse httpResponse) throws IOException {
        httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpResponse.getWriter().write("Permission error");
    }

}
