package com.mindasoft.javaee._01_servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by min on 2018/1/3 21:08.
 */
public class ServletLearning implements Servlet {

	private static final Logger logger = LoggerFactory.getLogger(ServletLearning.class);

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		logger.info("###init");
	}

    @Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		logger.info("###service");
	}

    @Override
	public void destroy() {
		logger.info("###destroy");
	}

	/**
	 *   一个由servlet容器使用的servlet配置对象，用于在servlet初始化时向它传递信息。
	 *
	 * getServletName()方法概述：public java.lang.String getServletName()
	 * 该方法返回一个servlet实例的名称，该名称由服务器管理员提供。
	 *
	 * getServletContext()方法概述：public ServletContext getServletContext()
	 * 返回一个ServletContext对象的引用。
	 *
	 * getInitParameter(String name)方法概述：public java.lang.String getInitParameter(java.lang.String name)
	 * 返回一个由参数String name决定的初始化变量的值，如果该变量不存在，返回null。
	 *
	 * getInitParameterNames()方法概述：public java.util.Enumeration getInitParameterNames()
	 * 返回一个存储所有初始化变量的枚举函数。如果servlet没有初始化变量，返回一个空枚举函数。
	 *
	 * @return
	 */
    @Override
	public ServletConfig getServletConfig() {

		logger.info("###ServletConfig");
		return null;
	}

    @Override
	public String getServletInfo() {
		logger.info("###getServletInfo");
		return null;
	}
}
