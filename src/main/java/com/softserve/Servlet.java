package com.softserve;
import com.softserve.entity.Bookings;
import com.softserve.entity.City;
import com.softserve.entity.Rooms;
import com.softserve.service.TravelService;
import com.softserve.service.TravelServiceImp;
import java.io.*;
import java.sql.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Extend HttpServlet class
public class Servlet extends HttpServlet {
    private static TravelService travelService = new TravelServiceImp();
    private String message;

    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        City city = travelService.findCity("Lviv").get(0);
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        Bookings bookings = new Bookings(Date.valueOf(start), Date.valueOf(end), 1,
            Rooms.Luxury.valueOf(request.getParameter("luxury")),
            Rooms.Bedrooms.valueOf(request.getParameter("bedrooms")),city );
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    public void destroy() {
        // do nothing.
    }
}
