package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CheckRegister;
import model.FreeSeats;
import model.User;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		FreeSeats freeSeats = new FreeSeats();
		getServletContext().setAttribute("freeSeats", freeSeats);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final Object lock = request.getSession().getId().intern();
		CheckRegister checkRegister = new CheckRegister();
		FreeSeats freeSeats = (FreeSeats) getServletContext().getAttribute("freeSeats");
		int availableSeats = freeSeats.getFreeSeats();

		HttpSession session = request.getSession();
		String url = "/register.jsp";
		String action = request.getParameter("action");
		if (action.equals("registrationCheck")) {
			url = checkRegister.checkUser(request, response);
		}

		synchronized (lock) {
			session.setAttribute("availableSeats", availableSeats);
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CheckRegister checkRegister = new CheckRegister();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		final Object lock = request.getSession().getId().intern();
		FreeSeats freeSeats = (FreeSeats) getServletContext().getAttribute("freeSeats");

		int availableSeats = freeSeats.getFreeSeats();
		String action = request.getParameter("action");
		String url = "/register.jsp";
		String error = "";

		if (action.equals("registerUser")) {
			url = checkRegister.registerUser(request, response);
		} else if (action.equals("buyTicket")) {

			if (availableSeats == 0) {
				error = "No more tickets available, please come back tommorow";
				request.setAttribute("errorMessage", error);
				url = "/soldOut.jsp";
			} else {
				synchronized (lock) {
					int seatNumber = freeSeats.addPassenger();
					if (seatNumber == -1) {
						error = "Cannot add more passengers";
						request.setAttribute("errorMessage", error);
						url = "/soldOut.jsp";
					} else {
						getServletContext().setAttribute("freeSeats", freeSeats);
						getServletContext().setAttribute("seatNumber", seatNumber);
						session.setAttribute("user", user);
						url = "/confirmation.jsp";
					}
				}
			}
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);

	}

}
