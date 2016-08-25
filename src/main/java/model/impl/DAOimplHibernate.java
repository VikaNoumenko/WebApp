package model.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import hibernate.HibernateUtil;
import hibernate.entity.MessageEntity;
import hibernate.entity.UserEntity;
import model.DAO;


public class DAOimplHibernate implements DAO {

	// Получение пароля
	public String getPassword(String userName) {
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("userName", userName));
		List<UserEntity> lst = criteria.list();
		for (UserEntity ue : lst) {
			if (ue.getUserName().equals(userName)) {
				return ue.getPassword();
			}
		}
		return null;
	}
	
	//создание пользователя
	public void createUser(Map<String, String> info) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		UserEntity user = new UserEntity();
		user.setUserName(info.get("userName"));
		user.setPassword(info.get("password"));
		session.save(user);
		session.getTransaction().commit();

	}
	
	// восстановление пароля
	public boolean resetPassword(String userName, String password) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("UPDATE UserEntity SET password = :password "
				+ "WHERE userName = :userName ");
		query.setString("password", password);
		query.setString("userName", userName);
		int result = query.executeUpdate();
		session.getTransaction().commit();
		
		if(result == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	//  отправка сообщений
	public boolean setMessage(String from, String to, String text) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		MessageEntity msg = new MessageEntity();

		msg.setSender(from);
		msg.setReceiver(to);
		msg.setText(text);
		msg.setSendDate();

		session.save(msg);
		session.getTransaction().commit();
		
		return true;
	}

	// Получение списка сообщений пользователя
	public List<?> getUserMessages(String userName) {
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(MessageEntity.class);
		criteria.add(Restrictions.eq("receiver", userName));
		List<MessageEntity> messageList = criteria.list();
		return messageList;
	}
	
	// Получения списка польователей
	public List<?> getUsersList() {
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(UserEntity.class);
		List<UserEntity> usersList = criteria.list();
		return usersList;
	}

	// Получение информации о пользователе
	public List<?> getUserInfo(String userName) {
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("userName", userName));
		List<UserEntity> userInfo = criteria.list();
		return userInfo;
	}




}
