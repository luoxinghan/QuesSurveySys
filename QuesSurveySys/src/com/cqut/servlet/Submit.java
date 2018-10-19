package com.cqut.servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.dao.OptionDao;
import com.cqut.dao.QuestionDao;
import com.cqut.dao.QuestionnaireDao;
import com.cqut.dao.UserAnswerDao;
import com.cqut.dao.UserDao;
import com.cqut.dao.UserSurveyDao;
import com.cqut.dto.Option;
import com.cqut.dto.Questionnaire;
import com.cqut.dto.User;
import com.cqut.dto.UserAnswer;
import com.cqut.dto.UserSurvey;
import com.cqut.util.StringUtil;

/**
 * Servlet implementation class Submit
 */
@WebServlet("/Submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submit() {
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
		Questionnaire getQsn = new Questionnaire();
		String qsnId = request.getParameter("qsnId");
		getQsn.setId(qsnId);
		Questionnaire questionnaire = QuestionnaireDao.getQuestionnaireDao().getAQuestionnaire(getQsn);
		questionnaire.setQuestions(QuestionDao.getQuestionDao().getQuestionsByQsnId(getQsn.getId()));
		ArrayList<String[]> answer = new ArrayList<String[]>();
		
		InetAddress address = InetAddress.getLocalHost();
		String hostAddress = address.getHostAddress();
		/**下面进行数据的添加*/
		
		/** 添加一个新的用户 */
		User user = new User();
		user.setId(StringUtil.createTimestamp());
		user.setUserName(hostAddress);
		user.setUserType((byte) 0);
		user.setIsDelete((byte) 0);
		UserDao.getUserDao().addAUser(user);
		
		UserSurvey userSurvey = new UserSurvey();
		userSurvey.setId(StringUtil.createTimestamp());
		userSurvey.setQsnId(qsnId);
		userSurvey.setUserId(user.getId());
		UserSurveyDao.getUserSurveyDao().addAUserSurvey(userSurvey);
		
		for(int i = 0; i < questionnaire.getQuestions().size(); i++) {
			if (questionnaire.getQuestions().get(i).getQuestionType() == 1) {
				String[] aStrings = request.getParameterValues("q" + String.valueOf(i+1));
				for(int j = 0; j < aStrings.length; j++) {
					Option option = OptionDao.getOptionDao().getOptionById(aStrings[j]);
					UserAnswer userAnswer = new UserAnswer();
					userAnswer.setId(StringUtil.createTimestamp());
					userAnswer.setUserSurveyId(userSurvey.getId());
					userAnswer.setQuestionId(option.getQuestionId());
					userAnswer.setOptionId(aStrings[j]);
					userAnswer.setOptionInfo(option.getOptionName());
					UserAnswerDao.getUserAnswerDao().addAUserAnswer(userAnswer);
				}
				answer.add(request.getParameterValues("q" + String.valueOf(i+1)));
			} else if (questionnaire.getQuestions().get(i).getQuestionType() == 2) {
				String[] aStrings = new String[1];
				aStrings[0] = request.getParameter("q"+String.valueOf(i+1));
				UserAnswer userAnswer = new UserAnswer();
				userAnswer.setId(StringUtil.createTimestamp());
				userAnswer.setUserSurveyId(userSurvey.getId());
				userAnswer.setQuestionId(questionnaire.getQuestions().get(i).getId());
				userAnswer.setOptionInfo(aStrings[0]);
				UserAnswerDao.getUserAnswerDao().addAUserAnswer(userAnswer);
			} else {
				String[] aStrings = new String[1];
				aStrings[0] = request.getParameter("q"+String.valueOf(i+1));
				Option option = OptionDao.getOptionDao().getOptionById(aStrings[0]);
				UserAnswer userAnswer = new UserAnswer();
				userAnswer.setId(StringUtil.createTimestamp());
				userAnswer.setUserSurveyId(userSurvey.getId());
				userAnswer.setQuestionId(option.getQuestionId());
				userAnswer.setOptionId(aStrings[0]);
				userAnswer.setOptionInfo(option.getOptionName());
				UserAnswerDao.getUserAnswerDao().addAUserAnswer(userAnswer);
				answer.add(aStrings);
			}
		}
		
		request.getRequestDispatcher("./index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
