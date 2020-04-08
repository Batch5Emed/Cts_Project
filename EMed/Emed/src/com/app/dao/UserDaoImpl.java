package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Role;
import com.app.pojos.User;


@Transactional
@Repository
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	SessionFactory sf;
	
	
	@Autowired
	JavaMailSender sendmail;
	
	
	
@Override
public User getUserByMail(String email,String pwd)
{
	System.out.println("in user dao");
String jpql = "Select u from User u where email= :em and password= :pwd";
return sf.getCurrentSession().createQuery(jpql,User.class).setParameter("em", email).setParameter("pwd", pwd).getSingleResult();
}

@Override
public void registerUser(User u)
{
	
	u.setUserType(Role.PATIENT);
	SimpleMailMessage mail=new SimpleMailMessage();
	mail.setTo(u.getEmail());
	mail.setSubject("Registration Successfull");
	mail.setText("Thank you " + u.getUserNanme() + " for registering on our website. ");
	sendmail.send(mail);
    sf.getCurrentSession().save(u);
}

@Override
public void regDoc(User u)
{
	
	u.setUserType(Role.DOCTOR);
	SimpleMailMessage mail=new SimpleMailMessage();
	mail.setTo(u.getEmail());
	mail.setSubject("Welcome Doctor , Registration Successfull");
	mail.setText("Thank you Dr " + u.getUserNanme() + " to be our part . You have successfully registered with Email : "+ u.getEmail() + " and Password : " + u.getPassword() );
	sendmail.send(mail);
    sf.getCurrentSession().save(u);
}


@Override
public List<User> getAllUser()
{
	String jpql = "Select u from User u";
	return sf.getCurrentSession().createQuery(jpql,User.class).getResultList();
}












}
