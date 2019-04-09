package myblog.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



import myblog.bean.Order;
import myblog.bean.User;
import myblog.dao.DingDao;
import myblog.dao.UserDao;

/**
 * Servlet implementation class SigninAction
 */
@WebServlet("/SigninAction")
public class SigninAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SigninAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("signin.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DingDao dao=new DingDao();
		String product[]= {"耳机","鼠标","键盘","小音箱","摄像头"};
		int p[]= {36,100,30,158,200};
		for(int i=0;i<250;i++) {
			String supplier="vending@163.com";
			String buyer=getRandomString((int)(1+Math.random()*(10-1+1)));
			String vending=getRandomString((int)(1+Math.random()*(10-1+1)));
			int j=(int)(Math.random()*(5-1+1));
			String goods=product[j];
			int num=(int)(1+Math.random()*(30-1+1));
			float price=num*p[j];
			Date date=randomDate("2019-03-04 00:00:00 ","2019-03-18 23:59:59 ");
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			String dateStr = "";  
			dateStr = sdf.format(date);  
			Timestamp ts = new Timestamp(System.currentTimeMillis());  
			ts = Timestamp.valueOf(dateStr);  
			Order order=new Order(supplier,buyer,vending,goods,num,price,ts);
			dao.create(order);
		}
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		
//		String username = request.getParameter("inputEmail");
//		String password = request.getParameter("inputPassword");
//		
//		
//		UserDao userDao = new UserDao();
//		User user = userDao.query(username);
//		
//		if (user != null && user.getPassword().equals(password)) {
//			request.getSession(true).setAttribute("User", user);
//			out.println("<script>alert('signin successfully.');location='index.jsp';</script>");
//		} else {
//			out.println("<script>alert('signin failed.');location='signin.html';</script>");
//		}
	

	}
	protected static int getRandom(int count) {
	    return (int) Math.round(Math.random() * (count));
	}
	protected String getRandomString(int length){
		String string = "abcdefghijklmnopqrstuvwxyz"; 
	    StringBuffer sb = new StringBuffer();
	    int len = string.length();
	    for (int i = 0; i < length; i++) {
	        sb.append(string.charAt(getRandom(len-1)));
	    }
	    return sb.toString();
	}
	protected Date randomDate(String beginDate,String endDate){
		try {
			 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss "); 
			 Date start = format.parse(beginDate);  // 构造开始日期 
			 Date end = format.parse(endDate);  // 构造结束日期  
			// getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
			 if(start.getTime() >= end.getTime()){  
				 return null;  
			 }
			 long date = random(start.getTime(),end.getTime()); 
			 return new Date(date);  
		} catch (Exception e) {  
			e.printStackTrace();  
		}
		 
		return null;  
		
	}
	protected long random(long begin,long end) {
		long rtn = begin + (long)(Math.random() * (end - begin));  
		// 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
		 if(rtn == begin || rtn == end){  
			 return random(begin,end); 
		 }
		return rtn;  
	}
}
