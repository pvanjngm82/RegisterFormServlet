package main.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter pw = res.getWriter();

    String name = req.getParameter("name");
    String dob = req.getParameter("dob");
    String gender = req.getParameter("gender");
    String qlfy = req.getParameter("qlfy");
    String[] hobbies = req.getParameterValues("hb");

    String hobbiesStr = "None selected";
    if (hobbies != null && hobbies.length > 0) {
      List<String> hobbyList = Arrays.asList(hobbies);
      hobbiesStr = String.join(", ", hobbyList);
    }

    pw.println("<!DOCTYPE html>");
    pw.println("<html lang='en'>");
    pw.println("<head>");
    pw.println("<meta charset='UTF-8'>");
    pw.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
    pw.println("<link href='https://fonts.googleapis.com/css2?family=Poppins&display=swap' rel='stylesheet'>");
    pw.println("<style>");
    pw.println("body {");
    pw.println("  margin: 0;");
    pw.println("  padding: 0;");
    pw.println("  background: url('https://images.unsplash.com/photo-1497436072909-60f360e1d4b1?q=80&w=1932&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D') no-repeat center center fixed;");
    pw.println("  background-size: cover;");
    pw.println("  font-family: 'Poppins', sans-serif;");
    pw.println("  display: flex;");
    pw.println("  align-items: center;");
    pw.println("  justify-content: center;");
    pw.println("  height: 100vh;");
    pw.println("}");

    pw.println(".container {");
    pw.println("  background: rgba(0, 0, 0, 0.75);");
    pw.println("  padding: 40px;");
    pw.println("  border-radius: 20px;");
    pw.println("  max-width: 600px;");
    pw.println("  width: 90%;");
    pw.println("  color: white;");
    pw.println("  box-shadow: 0 0 20px rgba(0,0,0,0.6);");
    pw.println("}");

    pw.println("h2 {");
    pw.println("  text-align: center;");
    pw.println("  margin-bottom: 30px;");
    pw.println("}");

    pw.println("table {");
    pw.println("  width: 100%;");
    pw.println("  border-collapse: collapse;");
    pw.println("}");

    pw.println("td {");
    pw.println("  padding: 12px 16px;");
    pw.println("  border-bottom: 1px solid #444;");
    pw.println("}");

    pw.println("td.label {");
    pw.println("  font-weight: bold;");
    pw.println("  color: #a7c0ff;");
    pw.println("  width: 40%;");
    pw.println("}");

    pw.println("@media (max-width: 500px) {");
    pw.println("  .container { padding: 20px; }");
    pw.println("  td { font-size: 14px; }");
    pw.println("}");
    pw.println("</style>");
    pw.println("</head>");
    pw.println("<body>");
    pw.println("<div class='container'>");
    pw.println("<h2>Submitted Details</h2>");
    pw.println("<table>");
    pw.println("<tr><td class='label'>Name</td><td>" + name + "</td></tr>");
    pw.println("<tr><td class='label'>Date of Birth</td><td>" + dob + "</td></tr>");
    pw.println("<tr><td class='label'>Gender</td><td>" + gender + "</td></tr>");
    pw.println("<tr><td class='label'>Qualification</td><td>" + qlfy + "</td></tr>");
    pw.println("<tr><td class='label'>Hobbies</td><td>" + hobbiesStr + "</td></tr>");
    pw.println("</table>");
    pw.println("</div>");
    pw.println("</body>");
    pw.println("</html>");

    pw.close();
  }
}
