package org.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.AdmineDao;
import org.web.dao.ComDao;
import org.web.daoimpl.AdmineDaoImpl;
import org.web.daoimpl.ComDaoImpl;
import org.web.factory.AdmineFactory;
import org.web.model.Admine;
import org.web.model.Com;
import org.web.model.UserInfo;

@WebServlet("/admineService")
public class AdmineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("AdmineServlet");
		String op = request.getParameter("op");
		if (op != null) {
			try {
				if (op == "adminelogin" || "adminelogin".equals(op)) {
					// ����Ա��¼
					adminelogin(request, response);
				}else if(op == "listuser" || "listuser".equals(op)){
					//����Ա��ȡ�û��б�
					listuser(request,response);
				}else if(op == "showuser" || "showuser".equals(op)) {
					//����Ա��ʾ�û���Ϣ
					showuser(request,response);
				}else if(op == "addcom" || "addcom".equals(op)) {
					//����Ա������Ʒ
					addcom(request,response);
				}else if(op == "listcom" || "listcom".equals(op)) {
					//����Ա��ȡ��Ʒ�б�
					listcom(request,response);
				}else if(op == "getComPage" || "getComPage".equals(op)) {
					//����Ա����Ʒ�б��ҳ
					getComPage(request,response);
				}else if(op == "deletecom" || "deletecom".equals(op)) {
					//����Աɾ����Ʒ
					deletecom(request,response);
				}else if(op == "updatecom" || "updatecom".equals(op)) {
					//����Ա�޸���Ʒ��Ϣ
					updatecom(request,response);
				}else if(op == "showcom" || "showcom".equals(op)) {
					//����ID��ȡ��Ʒ��Ϣ
					showcom(request,response);
				}
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//����ID��ȡ��Ʒ��Ϣ
	private void showcom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int comId = Integer.parseInt(request.getParameter("comId"));
		System.out.println(comId);
		Com com = new Com();
		com.setComId(comId);
		Com co = AdmineFactory.getComDao().getComByid(comId);
		request.setAttribute("co", co);
		request.getRequestDispatcher("com/updatecom.jsp").forward(request, response);
		
	}

	//����Ա�޸���Ʒ��Ϣ
	private void updatecom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comName = request.getParameter("comName");
		String comType = request.getParameter("comType");
		String origin = request.getParameter("origin");
		Double price = Double.parseDouble(request.getParameter("price"));
		int comId = Integer.parseInt(request.getParameter("comId"));
		
		Com co = new Com();
		co.setComName(comName);
		co.setComType(comType);
		co.setOrigin(origin);
		co.setPrice(price);
		co.setComId(comId);

		boolean success = AdmineFactory.getComDao().updatecom(co);
		if(success) {
			request.getSession().setAttribute("co", co);
			request.getRequestDispatcher("admineService?op=getComPage").forward(request, response);
		}else {
			response.sendRedirect("com/updatecom.jsp");
		}
		
	}

	//����Աɾ����Ʒ
	private void deletecom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int comId = Integer.parseInt(request.getParameter("comId"));
		Com com = new Com();
		com.setComId(comId);
		boolean success = AdmineFactory.getComDao().deletecom(com);
		request.getRequestDispatcher("admineService?op=getComPage").forward(request, response);
		
		
	}

	//����Ա����Ʒ�б��ҳ
	private void getComPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.getRequestDispatcher("com/listcom.jsp").forward(request, response);
		
	}

	//��ȡ��Ʒ�б�
	private void listcom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Com> comList = AdmineFactory.getComDao().getallCom();
		System.out.println(comList);
		request.setAttribute("comList", comList);
		request.getRequestDispatcher("com/listcom.jsp").forward(request, response);
	}
	
	//������Ʒ
	private void addcom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comName = request.getParameter("comName");
		String comType = request.getParameter("comType");
		String origin = request.getParameter("origin");
		double price = Double.parseDouble(request.getParameter("price"));
		Com com = new Com();
		com.setComName(comName);
		com.setComType(comType);
		com.setOrigin(origin);
		com.setPrice(price);
		
		boolean success = AdmineFactory.getComDao().addcom(com);
		if(success) {
			//�����ɹ�
			request.getSession().setAttribute("com", com);
			request.getRequestDispatcher("admineService?op=getComPage").forward(request, response);
		}else {
			//����ʧ��
			response.sendRedirect("com/addcom.jsp");
		}
		
	}

	//��ʾ�û���Ϣ
	private void showuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		UserInfo userInfo = AdmineFactory.getUserInfoDao().getUserInfoByid(userId);
		request.setAttribute("userInfo", userInfo);
		request.getRequestDispatcher("userinfo/showuser.jsp").forward(request, response);
	}

	//��ȡ�û��б�
	private void listuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserInfo> userInfoList = AdmineFactory.getUserInfoDao().getallUsers();
		request.setAttribute("userInfoList", userInfoList);
		request.getRequestDispatcher("userinfo/listusers.jsp").forward(request, response);
	}

	// ����Ա��¼
	private void adminelogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ղ���
		String aName = request.getParameter("admineName");
		String aPass = request.getParameter("adminePass");
		Admine admine = new Admine();
		admine.setAdmineName(aName);
		admine.setAdminePass(aPass);

		// ����login����	
		Admine adm = AdmineFactory.getAdmineDao().login(admine);
		System.out.println(adm);
		if (adm != null) {
			request.getSession().setAttribute("admine", adm);
			request.getRequestDispatcher("admine/adminemain.jsp").forward(request,response);
		} else {
			response.sendRedirect("admine/adminelogin.jsp");
		}
	}

}
