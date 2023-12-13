package controller;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DangNhap
 */
@WebServlet("/dang-nhap")
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String quantity = request.getParameter("quantity");
		String phone = request.getParameter("phone");
		String url = "";
		boolean check = true;

		request.setAttribute("email", email);
		request.setAttribute("password", password);
		request.setAttribute("quantity", quantity);
		request.setAttribute("phone", phone);

		Pattern emailPt = Pattern.compile("\\w+@\\w+(\\.\\w+)*");
		Matcher emailMt = emailPt.matcher(email);
		if (!emailMt.matches()) {
			check = false;
			request.setAttribute("emailErr", "Email is invalid!");
		}

		Pattern passwordPt = Pattern.compile("(\\w){6,10}");
		Matcher passwordMt = passwordPt.matcher(password);
		if (!passwordMt.matches()) {
			check = false;
			request.setAttribute("passwordErr", "Password is invalid!");
		}

		Pattern quantityPt = Pattern.compile("(\\d){1,2}");
		Matcher quantityMt = quantityPt.matcher(quantity);
		if (!quantityMt.matches()) {
			check = false;
			request.setAttribute("quantityErr", "Quantity is invalid!");
		}

		Pattern phonePt = Pattern.compile("\\d{10}");
		Matcher phoneMt = phonePt.matcher(phone);
		if (!phoneMt.matches()) {
			check = false;
			request.setAttribute("phoneErr", "Phone is invalid!");
		}

		if (check == false)
			url = "/index.jsp";
		else
			url = "/success.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
