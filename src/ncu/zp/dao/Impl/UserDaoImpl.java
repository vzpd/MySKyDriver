package ncu.zp.dao.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ncu.zp.dao.UserDao;
import ncu.zp.entity.User;
import ncu.zp.util.MyHibernateDaoSupport;

@Repository("UserDao")
public class UserDaoImpl extends MyHibernateDaoSupport implements UserDao {

	public void addUser(User user) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		session.save(user);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	public void delUser(int userId) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		User u = new User(userId);
		session.delete(u);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	public void updateUser(User user) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		session.update(user);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();

	}

	public List<User> selectUser() {
		List<User> users = new ArrayList<User>();
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		List list = session.createQuery("From User").list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			User u = (User) iterator.next();
			users.add(u);
		}
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return users;
	}

	public User getUserByUserId(int userId) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		// load 鏄鏄庢暟鎹簱涓竴瀹氬瓨鍦ㄨ繖鏉¤褰曪紝娌℃湁鍒欐姤鍑猴細ObjectNotFoundException
		// get 濡傛灉鏌ヤ笉鍒拌褰曪紝杩斿洖鐨勬槸涓�涓猲ull
		User user = (User) session.load(User.class, userId);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return user;
	}

	public boolean isExitByName(String userName) {
		/*
		 * Session session = this.getSession(true); Transaction tc = (Transaction)
		 * session.beginTransaction(); List user =
		 * (List)session.createQuery("From User u where u.userName=:userName").setString
		 * ("userName", userName).list(); if(user.size()>0){ try { tc.commit(); } catch
		 * (Exception e) { e.printStackTrace(); } session.close(); return true; } try {
		 * tc.commit(); } catch (Exception e) { e.printStackTrace(); } session.close();
		 */
		return false;
	}

	public boolean isExitByNameAndPass(User user) {
		Session session = this.getSession(true);
		List users = (List) session.createQuery("From User u where u.userName=:userName and u.userPassword=:passWord")
				.setString("userName", user.getUserName()).setString("passWord", user.getUserPassword()).list();
		if (users.size() > 0) {
			return true;
		} else {
			return false;
		}

	}

}
