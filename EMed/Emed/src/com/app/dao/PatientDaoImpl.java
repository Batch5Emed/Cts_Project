package com.app.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Appointment;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

@Transactional
@Repository
public class PatientDaoImpl implements IPatientDao {
	
@Autowired
SessionFactory sf;


@Override
public List<User> getDoctorsList()
{
	System.out.println("in doclist");
	String jpql = "select u from User u where u.userType= :us";
	return sf.getCurrentSession().createQuery(jpql,User.class).setParameter("us",Role.DOCTOR).getResultList();
}

@Override
public void setApp(Integer docid,Date appdate,User u)
{
    
	Appointment newap = new Appointment();
	newap.setDocId(docid);
	newap.setUser(u);
	newap.setApdate(appdate);
	newap.setAppstatus("PENDING");
	sf.getCurrentSession().save(newap);
	u.getApp().add(newap);
}


}
