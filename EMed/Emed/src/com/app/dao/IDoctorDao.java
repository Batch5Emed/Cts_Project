package com.app.dao;

import java.util.List;

import com.app.pojos.Appointment;
import com.app.pojos.User;

public interface IDoctorDao {

	List<Appointment> getApp(User u);

	void acceptreq(Integer apid);

	void rejectreq(Integer apid);

}
