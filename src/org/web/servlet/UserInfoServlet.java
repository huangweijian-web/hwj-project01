package org.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.UserInfoDao;
import org.web.daoimpl.UserInfoDaoImpl;
import org.web.factory.AdmineFactory;
import org.web.model.Com;
import org.web.model.UserInfo;

@WebServlet("/userInfoService")
public class UserInfoServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String op = request.getParameter("op");
		if (op != null) {
			try {
				if (op == "register" || "register".equals(op)) {
					// 注册
					register(request, response);
				}else if(op == "login" || "login".equals(op)) {
					//登录
					login(request,response);
				}else if(op == "update" ||"update".equals(op)) {
					//用户修改个人信息
					update(request,response);
				}else if(op == "browescom" || "browescom".equals(op)) {
					//用户浏览商品
					browescom(request,response);
				}
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//用户浏览商品
	private void browescom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strPage = request.getParameter("page");
		int page = 0;
		if(strPage == null) {
			page = 1;
		}else {
			page = Integer.parseInt(strPage);
		}
		int size = 5;
		
		int totalRecords = AdmineFactory.getComDao().getComCount();
		int totalPages = 0;
		if(totalRecords % size == 0) {
			totalPages = totalRecords / size;
		}else {
			totalPages = totalRecords / size + 1;
		}
		request.setAttribute("totalPages", totalPages);
		
		if(page < 1) {
			page = 1;
		}
		
		List<Com> comList = AdmineFactory.getComDao().getComPage(page, size);
		request.setAttribute("comList",comList);
		request.getRequestDispatcher("com/browescom.jsp").forward(request, response);
		
		
	}

	//用户修改个人信息
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//接收参数
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		String mobilePhone = request.getParameter("mobilePhone");
		UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
		if(userInfo == null) {
			response.sendRedirect("userinfo/login.jsp");
		}else {
			
			int userId = userInfo.getUserId();
			
			// 将参数值保存到对象中
			UserInfo us = new UserInfo();
			us.setUserName(userName);
			us.setUserPass(userPass);
			us.setMobilePhone(mobilePhone);
			us.setUserId(userId);
			boolean success = AdmineFactory.getUserInfoDao().update(us);
			System.out.println(success);
			if(success ) {
				request.getSession().setAttribute("userInfo", us);
				request.getRequestDispatcher("userinfo/showmy.jsp").forward(request, response);
			}else {
				response.sendRedirect("userinfo/update.jsp");
			}
		}
	}

	//登录
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(userName);
		userInfo.setUserPass(userPass);
		
		//调用login方法
		UserInfo us = AdmineFactory.getUserInfoDao().login(userInfo);
		if(us != null) {
			request.getSession().setAttribute("userInfo", us);
			request.getRequestDispatcher("main.jsp").forward(request,response);
		}else {
			response.sendRedirect("userinfo/login.jsp");
		}
		
	}

	// 注册
	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收参数
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		// 将参数值保存到对象中
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(userName);
		userInfo.setUserPass(userPass);
		// 调用UserInfoDao的register方法
		boolean success = AdmineFactory.getUserInfoDao().register(userInfo);
		if (success) {
			// 注册成功 跳转到登录页面
			request.getRequestDispatcher("userinfo/login.jsp").forward(request, response);
		} else {
			// 注册失败 
			response.sendRedirect("userinfo/register.jsp");
		}

	}
}
