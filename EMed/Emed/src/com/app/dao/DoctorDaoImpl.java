package com.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Appointment;
import com.app.pojos.User;
import com.mysql.cj.xdevapi.SessionFactory;

@Transactional
@Repository
public class DoctorDaoImpl implements IDoctorDao {
	
	@Autowired
	org.hibernate.SessionFactory sf;
	
	@Autowired
	JavaMailSender sendmail;
	
	
	@Override
	public List<Appointment> getApp(User u )
	{
		String jpql = "Select a from Appointment a where a.docId= :id and appstatus = 'PENDING'";
		return sf.getCurrentSession().createQuery(jpql,Appointment.class).setParameter("id",u.getUserId()).getResultList();
		
	}
	
	@Override
	public void acceptreq(Integer apid)
	{
		Appointment ap = sf.getCurrentSession().get(Appointment.class, apid);
		ap.setAppstatus("CONFIRMED");
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(ap.getUser().getEmail());
		mail.setSubject("Appointment Confirmed");
		mail.setText("Hello , "+ ap.getUser().getUserNanme() + " . Your requested appointment for " + ap.getApdate() + "has been confirmed.");
		sendmail.send(mail);
	}
	
	@Override
	public void rejectreq(Integer apid)
	{
		Appointment ap = sf.getCurrentSession().get(Appointment.class, apid);
		ap.setAppstatus("DECLINED");
	}
	
}
