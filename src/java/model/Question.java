package model;
import java.sql.Timestamp;
import control.DBConnect;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenov
 */
public class Question 
{
 int QID;
 String login_id;
 //private Timestamp asked;
 int like;
 int dislike;
 String question;
 static int qid=1;
 
    public Question()
    {
    }
    public Question(String user_id,String question,int QID) {
        this.login_id=user_id;
        this.QID = QID;
        //this.asked = asked;
        //this.like = like;
        //this.dislike = dislike;
        this.question = question;
    }

    public String getlogin_id() 
    {
        return login_id;
    }

    public void setlogin_id(String login_id) {
        this.login_id = login_id;
    }
    
    public int getQID() {
        return QID;
    }

    public void setQID(int QID) {
        this.QID = QID;
    }

   /* public Timestamp getAsked() {
        return asked;
    }*/

    /*public void setAsked(Timestamp asked) {
        this.asked = asked;
    }*/

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

 
 public boolean postQuestion(String user_id,String question)
 {
    DBConnect db = new DBConnect ();
    try
        {   qid++;
            
             String SQL = "insert into question(user_id,ques) values ('" + user_id + "','" + question + "')";
             db.pstmt = db.conn.prepareStatement(SQL);
             try
             {
             db.pstmt.executeUpdate();
             return true;
             }
             catch (SQLException e)
             {
             return false;
             }
             }
        catch(SQLException e)
        {
           return false; 
        }
         finally
        {
            try
            {
            db.conn.close();
            }
            catch (SQLException e)
            {
            return false;
            }
        }
        
 }

    public boolean deleteQuestion(int QID , String login_id ){
         DBConnect db = new DBConnect ();
        
        try
        {
            String SQL = "";
            db.pstmt = db.conn.prepareStatement(SQL);
            try
            {
                if (db.pstmt.executeUpdate() != 0)
                    return true;
            }
            catch(SQLException e)
            {
                    return false;
            }
        }
        catch(SQLException e)
        {
            return false;
        }
        finally
        {
            try
            {
                db.conn.close();
            }
            catch(SQLException e)
            {
                return false;
            }
        }
        return false;
    }
        
    } 