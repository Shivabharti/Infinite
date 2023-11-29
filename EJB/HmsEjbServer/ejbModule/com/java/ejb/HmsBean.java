package com.java.ejb;

import java.sql.SQLException; 
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class HmsBean
 */
@Stateless
@Remote(HmsBeanRemote.class)
public class HmsBean implements HmsBeanRemote {
	
	@PersistenceContext(unitName= "HMSMgmtPU")
	private EntityManager entityManager;
	
	static HmsDaoImpl daoImpl;
	static {
		daoImpl=new HmsDaoImpl();
	}

    /**
     * Default constructor. 
     */
    public HmsBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public List<Doctor> showDoctor() {
		// TODO Auto-generated method stub
		System.out.println("Entit Manager is" +entityManager);
		Query query = entityManager.createQuery("SELECT e FROM Doctor e");
		return (List<Doctor>)query.getResultList();
				
	}

//	@Override
//	public List<Doctor> showDoctor() throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		return daoImpl.showDoctorDao();
//	}

	@Override
	public List<Room> showRoom() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.showRoomDao();
	}

	@Override
	public String addPatient(Patient patient) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.addPatientDao(patient);
	}

	@Override
	public List<Patient> showPatient() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.showPatientDao();
	}

	@Override
	public List<String> getRoomType() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.getRoomType();
	}

//	@Override
//	public String addPatientReport(PatinetReport patient) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public String addPatientReport(PatinetReport patient) {
		entityManager.merge(patient);
		return "Employ Record Inserted...";
	}

}
