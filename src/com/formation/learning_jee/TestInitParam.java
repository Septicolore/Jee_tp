package com.formation.learning_jee;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = "/test_param",
		initParams = {
				@WebInitParam(name="username", value="Julien"),
				@WebInitParam(name="age", value="32")
		}
		)

public class TestInitParam extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletConfig myServletConfig = this.getServletConfig();
		
		// resp.setContentType("text/html; charset=utf-8");
		
		/* resp.getWriter()
		.append("<p>")
		.append(myServletConfig.getInitParameter("username"))
		.append("</p>"); */
		
		//r�cup�rer les param�tres d'url, s'ils sont vides alors vous affichez initparam sinon
		//la valeur entr�e par l'user
		String username = req.getParameter("username");
		String age = req.getParameter("age");

		String initUsername = myServletConfig.getInitParameter("username");
		String initAge = myServletConfig.getInitParameter("age");
		
		/* resp.getWriter()
		.append("Username : ")
		.append(username == null || username.isEmpty() ? initUsername : username)
		.append("<br>")
		.append("Age : ")
		.append(age == null || age.isEmpty() ? initAge : age); */
		
		List<String> names = Arrays.asList("Michael", "Geoffrey", "Cubitus", "lol", "LOL2");
		Map<String, Integer> ages = new HashMap<>();
		ages.put("Michael", 28);
		ages.put("Geoffrey", 28);
		ages.put("Cubitus", 4);
		ages.put("lol", 5);
		ages.put("LOL2", 5);
		
		//infos � transmettre au jsp
		req.setAttribute("nickname", username == null || username.isEmpty() ? initUsername : username);
		req.setAttribute("yearsOld", age == null || age.isEmpty() ? initAge : age);
		
		req.setAttribute("listeDeNom", names);
		
		req.setAttribute("listeAge", ages);
		
		//� indiquer en dernier ligne du fichier
		this.getServletContext().getRequestDispatcher("/WEB-INF/test_param.jsp").forward(req, resp);
	}

	

}
