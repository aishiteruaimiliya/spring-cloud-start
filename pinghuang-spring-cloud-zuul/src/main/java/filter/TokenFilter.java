package main.java.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class TokenFilter extends ZuulFilter {

    private final Logger log = LoggerFactory.getLogger(ZuulFilter.class);
    // 过滤时机
    @Override
    public String filterType() {
        return "pre";
    }


    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        try{
            Integer a = Integer.valueOf(request.getParameter("a"));
            Integer b = Integer.valueOf(request.getParameter("b"));
        }catch (Exception e){
            log.error("请求参数不正确");
            return null;
        }
        currentContext.setSendZuulResponse(true);
        currentContext.setResponseStatusCode(200);
        currentContext.set("isSuccess",true);
        return null;
    }
}
