package com.bkhn.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bkhn.model.ChoiceQuestion;
import com.bkhn.model.QuizQuestion;
import com.bkhn.model.Subject;
import com.bkhn.model.User;

/*
 * jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
 * */
public class DatabaseConnection {
	public final String DB_NAME = "OOP";
	
	private boolean isConnected;
	private Connection m_connection;	
	private	Statement m_statement;
	
	/*-------------------- Common functions ------------------------*/
	public DatabaseConnection(){
		isConnected = false;	
	}
	
	public boolean connectToDataBase()
	{
		try {
		    String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=" + DB_NAME + ";integratedSecurity=True;";
		    m_connection = DriverManager.getConnection(dbURL);
		    if (m_connection != null) {
		    	m_statement = m_connection.createStatement();
		    	System.out.println("Connected");
		    	DatabaseMetaData dm = (DatabaseMetaData) m_connection.getMetaData();
		    	System.out.println("Driver name: " + dm.getDriverName());
		    	System.out.println("Driver version: " + dm.getDriverVersion());
		    	System.out.println("Product name: " + dm.getDatabaseProductName());
		    	System.out.println("Product version: " + dm.getDatabaseProductVersion()); 
		    	isConnected = true;
		    	return true;
		    	}
		   } catch (SQLException ex) {
		     System.err.println("Cannot connect database, " + ex);
		   }
		isConnected = false;		
		return false;
	}
	
	/*-------------------- Handle Store Subject --------------------*/
	public int insertSubject(Subject subject) {
		if(isConnected == false)
			return 0;
		int count = 0;
		String sql = "SELECT * FROM dbo.tbSubject WHERE id = '" + subject.getId() +"'";
		PreparedStatement stmt;
		ResultSet rs;
		try {
			stmt = m_connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next())
			{
				return count;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sql = "INSERT INTO dbo.tbSubject( id, name, num_chapter, introduction )" +
		        "VALUES('"+subject.getId()+"', N'"+subject.getName()+"',"+subject.getNumChapter()+", N'"+subject.getIntroduction()+"')";
		
		try {
			count = m_statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int updateSubject(Subject subject) {
		if(isConnected == false)
			return 0;
		
		int count = 0;
		String sql = "UPDATE dbo.tbSubject SET name = N'"+
		subject.getName()+"', num_chapter = "+
		subject.getNumChapter()+", introduction = N'"+
		subject.getIntroduction()+"'WHERE id = '"+
		subject.getId()+"'";
		try {
			count = m_statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int deleteSubject(Subject subject){
		if(isConnected == false)
			return 0;
		
		int count = 0;
		String sql = "DELETE FROM dbo.tbQuizQuestion WHERE dbo.tbQuizQuestion.id IN \r\n" + 
				"(SELECT dbo.tbQuestion.id FROM dbo.tbQuestion WHERE dbo.tbQuestion.s_id = '"+subject.getId()+"')\r\n" + 
				"\r\n" + 
				"DELETE FROM dbo.tbChoiceQuestion WHERE dbo.tbChoiceQuestion.id IN \r\n" + 
				"(SELECT dbo.tbQuestion.id FROM dbo.tbQuestion WHERE dbo.tbQuestion.s_id = '"+subject.getId()+"')\r\n" + 
				"\r\n" + 
				"DELETE FROM dbo.tbQuestion WHERE dbo.tbQuestion.s_id = '"+subject.getId()+"'\r\n" + 
				"\r\n" + 
				"DELETE FROM dbo.tbSubject WHERE dbo.tbSubject.id = '"+subject.getId()+"'";
		try {
			count = m_statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	
	public ArrayList<Subject> getAllSubject(){
		ArrayList<Subject> arrayList = new ArrayList<Subject>();
		if(isConnected == false)
			return arrayList;
		String sql = "SELECT * FROM dbo.tbSubject";
		ResultSet resultSet;
		String id, name, intro;
		int num;
		try {
			resultSet = m_statement.executeQuery(sql);
			while(resultSet.next()) {
				id = resultSet.getString("id");
				name = resultSet.getString("name");
				intro = resultSet.getString("introduction");
				num = resultSet.getInt("num_chapter");
				arrayList.add(new Subject(name, id, num, intro));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrayList;
	}
	
	/*-------------------- Quiz Question ---------------------------*/
	public int insertQuizQuestion(QuizQuestion question) {
		if(isConnected == false)
			return 0;
		
		int count = 0;
		String sql = "SELECT * FROM dbo.tbQuestion WHERE id = "+ question.getId() +"";
		PreparedStatement stmt;
		ResultSet rs;
		try {
			stmt = m_connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next())
			{
				return count;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sql = "INSERT INTO dbo.tbQuestion( id, content, s_id, chapter, lvl )\r\n" + 
				"VALUES  ("+question.getId()+",N'"+question.getContent()+"','"+question.getSubject()+"',"+question.getChapter()+","+question.getLevel()+")\n" +
					"INSERT INTO dbo.tbQuizQuestion( id, suggestion )" + 
						"VALUES  ("+question.getId()+",N'"+question.getSuggestion()+"')";
		
		try {
			count = m_statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int updateQuizQuestion(QuizQuestion question)
	{
		if(isConnected == false)
			return 0;
		
		int count = 0;
		String sql = 	"DELETE FROM dbo.tbQuizQuestion WHERE id = "+question.getId()+"\r\n" + 
						"UPDATE dbo.tbQuestion SET content = '"+question.getContent()+"', chapter = "+question.getChapter()+", lvl = "+question.getLevel()+" WHERE id = 0\r\n" + 
						"INSERT INTO dbo.tbQuizQuestion( id, suggestion )\r\n" + 
						"VALUES  ( "+question.getId()+",N'"+question.getSuggestion()+"')";
		try {
			count = m_statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	
	public int deleteQuizQuestion(QuizQuestion question)
	{
		if(isConnected == false)
			return 0;
		
		int count = 0;
		String sql = 	"DELETE FROM dbo.tbQuizQuestion WHERE id = "+question.getId()+"\r\n" + 
						"DELETE FROM dbo.tbQuestion WHERE id = "+question.getId()+"";
		try {
			count = m_statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	
	public ArrayList<QuizQuestion> getAllQuizQuestion(String subjectId)
	{
		ArrayList<QuizQuestion> arrayList = new ArrayList<QuizQuestion>();
		if(isConnected == false)
			return arrayList;
		String sqlCommon = "SELECT dbo.tbQuestion.id, dbo.tbQuestion.content,dbo.tbQuestion.s_id, dbo.tbQuestion.chapter, dbo.tbQuestion.lvl, dbo.tbQuizQuestion.suggestion\r\n" + 
				"FROM (dbo.tbQuestion JOIN dbo.tbQuizQuestion ON tbQuizQuestion.id = tbQuestion.id) WHERE dbo.tbQuestion.s_id = '"+subjectId+"'";
		ResultSet resultSetCommon;
		int id, chapter, level;
		String content, suggestion = null;
		try {
			resultSetCommon = m_statement.executeQuery(sqlCommon);
			while (resultSetCommon.next()) {
				id = resultSetCommon.getInt("id");
				content = resultSetCommon.getString("content");
				chapter = resultSetCommon.getInt("chapter");
				level = resultSetCommon.getInt("lvl");
				suggestion = resultSetCommon.getString("suggestion");
				arrayList.add(new QuizQuestion(id, content, subjectId, chapter, level, suggestion));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return arrayList;
	}
	
	/*-------------------- Choice Question -------------------------*/
	public int insertChoiceQuestion(ChoiceQuestion question) {
		if(isConnected == false)
			return 0;
		
		int count = 0;
		String sql = "SELECT * FROM dbo.tbQuestion WHERE s_id = '"+question.getId()+"'";
		ResultSet resultSet;
		try {
			resultSet = m_statement.executeQuery(sql);
			while(resultSet.next())
				return count;
			String sql1 = "INSERT INTO dbo.tbQuestion( id, content, s_id, chapter, lvl )\r\n" + 
					"VALUES  ("+question.getId()+",N'"+question.getContent()+"','"+question.getSubject()+"',"+question.getChapter()+","+question.getLevel()+")";
			count = m_statement.executeUpdate(sql1);
			if(count > 0){
				for(int i=0; i< question.getChoices().size(); i++) {
					String sql2 = "INSERT INTO dbo.tbChoiceQuestion( id, choices)\r\n" + 
								 "VALUES  ("+question.getId()+",N'"+question.getChoices().get(i)+"')";
					m_statement.executeUpdate(sql2);
				}
				
				for(int i=0; i< question.getAnswers().size(); i++) {
					String sql3 = "UPDATE dbo.tbChoiceQuestion SET isanswer = 1 "
							+ "WHERE id = '"+question.getId()+"' AND choices = N'"+question.getAnswers().get(i)+"'";
					m_statement.executeUpdate(sql3);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	
	public int updateChoiceQuestion(ChoiceQuestion question){
		if(isConnected == false)
			return 0;
		
		int count = 0;
		String sql = "DELETE FROM dbo.tbChoiceQuestion WHERE id = "+question.getId()+""
				+ "DELETE FROM dbo.tbQuestion WHERE id = "+question.getId()+"";
		try {
			count = m_statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		count = insertChoiceQuestion(question);
		return count;
	}
	
	public int deleteChoiceQuestion(ChoiceQuestion question) {
		if(isConnected == false)
			return 0;
		
		int count = 0;
		String sql = "DELETE FROM dbo.tbChoiceQuestion WHERE id = "+question.getId()+""
				+ "DELETE FROM dbo.tbQuestion WHERE id = "+question.getId()+"";
		try {
			count = m_statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	
	public ArrayList<ChoiceQuestion> getAllChoiceQuestion(String subjectId)
	{
		ArrayList<ChoiceQuestion> arrayList = new ArrayList<ChoiceQuestion>();
		if(isConnected == false)
			return arrayList;
		String sql1 = "SELECT * FROM dbo.tbQuestion\r\n" + 
				"WHERE 0 < (SELECT COUNT(*) FROM dbo.tbChoiceQuestion WHERE dbo.tbChoiceQuestion.id = dbo.tbQuestion.id) AND dbo.tbQuestion.s_id = '"+subjectId+"'";
		ResultSet resultSetQ = null, resultSetA = null;
		try {
			// add question
			int id = 0, chapter = 0, level = 0;
			String content = null, subject = null; 
			resultSetQ = m_statement.executeQuery(sql1);
			while(resultSetQ.next()) {
				id = resultSetQ.getInt("id");
				content = resultSetQ.getString("content");
				subject = resultSetQ.getString("s_id");
				chapter = resultSetQ.getInt("chapter");
				level = resultSetQ.getInt("lvl");
				ChoiceQuestion question = new ChoiceQuestion(id, content, subject, chapter, level, null, null);
				arrayList.add(question);
			}
			// add choices
			for(int i=0; i< arrayList.size(); i++) {
				String sql2 = "SELECT * FROM dbo.tbChoiceQuestion WHERE id = "+arrayList.get(i).getId()+"";
				resultSetA = m_statement.executeQuery(sql2);
				while(resultSetA.next()) {
					String choice = resultSetA.getString("choices");
					arrayList.get(i).addChoices(choice);
					if(resultSetA.getBoolean("isanswer")==true) {
						arrayList.get(i).addAnswers(choice);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrayList;
	}
	
	/*--------------------- User-----------------------------------*/
	public int insertUser(User user) {
		if(isConnected == false)
			return 0;
		
		int count = 0;
		
		String check = "SELECT * FROM dbo.tbUser WHERE name = '"+user.getName()+"'";
		String sql = "INSERT INTO dbo.tbUser( name, pass, isadmin )\r\n" + 
						"VALUES  ('"+user.getName()+"','"+user.getPass()+"',"+(user.isAdmin()==true ? 1:0)+")";
		try {
			ResultSet resultSet = m_statement.executeQuery(check);
			if(resultSet.next())
				return count;
			count = m_statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	
	public int updateUser(User user) {
		if(isConnected == false)
			return 0;
		
		int count = 0;
		String sql = "UPDATE dbo.tbUser SET pass = '"+user.getPass()+"', isadmin = "+user.isAdmin()+" WHERE name = '"+user.getName()+"'";
		try {
			count = m_statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	
	public int deleteUser(String name) {
		if(isConnected == false)
			return 0;
		
		int count = 0;
		String sql = "DELETE FROM dbo.tbUser WHERE name = '"+name+"'";
		try {
			count  = m_statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	
	public User getUser(String name) {
		if(isConnected == false)
			return null;
		User user2 = null;
		String sql = "SELECT * FROM dbo.tbUser WHERE name = '"+name+"'";
		try {
			ResultSet resultSet = m_statement.executeQuery(sql);
			if(resultSet.next()) {
				user2 = new User(resultSet.getString("name"), resultSet.getString("pass"), resultSet.getBoolean("isadmin"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user2;
	}
}
