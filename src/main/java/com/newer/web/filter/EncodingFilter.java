/**
 * EncodingFilter.java
 *   作者:fulia
  *  版权所有：XXX公司
  *  创作日期：2019年7月20日
 */
package com.newer.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fulia   
 * 2019年7月20日
 * @version 1.0.0
 * @since 1.8
 */
public class EncodingFilter implements Filter{
	
	private String encoder;//字符集名
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req=(HttpServletRequest)arg0;
		req.setCharacterEncoding(encoder);
		HttpServletResponse resp=(HttpServletResponse)arg1;
		resp.setContentType("text/html;charset="+encoder);
		arg2.doFilter(req, resp);
		//System.out.println("完成"+encoder+"字符集转码");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoder=filterConfig.getInitParameter("encoder");	
		
	}
	
	

}
