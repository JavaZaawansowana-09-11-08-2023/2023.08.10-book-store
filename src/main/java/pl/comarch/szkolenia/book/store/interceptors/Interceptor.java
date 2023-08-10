package pl.comarch.szkolenia.book.store.interceptors;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;
import pl.comarch.szkolenia.book.store.session.SessionObject;

public class Interceptor implements HandlerInterceptor {

    @Resource
    SessionObject sessionObject;

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        if(sessionObject != null)
            modelAndView.addObject("logged", sessionObject.isLogged());
    }
}
