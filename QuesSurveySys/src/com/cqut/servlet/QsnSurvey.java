package com.cqut.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.dao.QuestionDao;
import com.cqut.dao.QuestionnaireDao;
import com.cqut.dto.Questionnaire;

/**
 * Servlet implementation class QsnSurvey
 */
@WebServlet("/QsnSurvey")
public class QsnSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QsnSurvey() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qsnId = request.getParameter("id");
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setId(qsnId);
		questionnaire = QuestionnaireDao.getQuestionnaireDao().getAQuestionnaire(questionnaire);
		questionnaire.setQuestions(QuestionDao.getQuestionDao().getQuestionsByQsnId(qsnId));
		request.setAttribute("qsn", questionnaire);
		request.getRequestDispatcher("./survey.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
