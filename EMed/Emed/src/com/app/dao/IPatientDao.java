package com.app.dao;

import java.util.Date;
import java.util.List;

import com.app.pojos.User;

public interface IPatientDao {

	List<User> getDoctorsList();

	void setApp(Integer docid, Date appdate, User u);

}
