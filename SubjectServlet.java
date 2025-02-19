package ac.za.subjectservlet;

import ac.zaa.admissioncalculator.AdmissionCalculator;
import java.io.IOException;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectServlet extends HttpServlet {

    public static HashSet<Subject> subjectList = new HashSet<>();
    private static final int MAX_SUBJECTS = 6;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String buttonName = (String) request.getParameter("button");

        if (isAddSubjectButton(buttonName) && subjectList.size() <= MAX_SUBJECTS) {

            String subjectname = request.getParameter("subject");
            int level = Integer.parseInt(request.getParameter("level"));
            Subject sub = new Subject(subjectname, level);
            subjectList.add(sub);
            includeIndexPage(request, response);
        } else {

            if (subjectList.size() >= MAX_SUBJECTS) {

                AdmissionCalculator list = new AdmissionCalculator(subjectList);

                String outcome = list.getAdmissionStatus();

                request.setAttribute("outcome", outcome);

                subjectList.clear();

                forwardToAdmissionResultPage(request, response);

            } else {
                response.getWriter().print("<h1 style='color:red'>Please add Six Best subcjet</h1>");
                includeIndexPage(request, response);

            }

        }

    }

    private boolean isAddSubjectButton(String buttonName) {
        return buttonName.equalsIgnoreCase("Add Subject");
    }

    private void includeIndexPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        dispatcher.include(request, response);
    }

    private void forwardToAdmissionResultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AdmissionResultViewer.jsp");
        dispatcher.forward(request, response);
    }

}
