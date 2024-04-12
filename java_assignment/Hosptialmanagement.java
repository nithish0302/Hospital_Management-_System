package Java_Assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Hosptialmanagement {
	
	
	// Patient
	public static void Create_newpatient ()
	{
		try
		{
			Connection con = Connectionclass.getconnection();
			Scanner sc = new Scanner(System.in);
			PreparedStatement pst=con.prepareStatement("insert into patient (patient_name,address,phone_no,gender,dob) values (?,?,?,?,?)");
			
			
			System.out.println("Enter the patient_name");
			String patient_name = sc.nextLine();
			
			System.out.println("Enter address");
			String address = sc.nextLine();
			
			System.out.println("Enter the phone_no");
			int phone_no=sc.nextInt();
			
			System.out.println("Enter the gender");
			String gender = sc.next();
			
			
			System.out.println("Enter the Date of Birth");
			String dob = sc.next();
		
			pst.setString(1,patient_name);
			pst.setString(2, address);
			pst.setInt(3, phone_no);
			pst.setString(4, gender);
			pst.setString(5, dob);
			
			pst.executeUpdate();
			
			getPatientInformation(patient_name);
			con.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	 public static void getPatientInformation(String  patient_name) {
	        String sql = "SELECT * FROM patient WHERE patient_name = ?";
	        Connection con = Connectionclass.getconnection();
	        try {
	        	PreparedStatement pst = con.prepareStatement(sql);

	            pst.setString(1, patient_name);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	                System.out.println("Patient ID: " + rs.getInt("patient_id"));
	                System.out.println("Name: " + rs.getString("patient_name"));
	                System.out.println("Gender: "+ rs.getString("gender"));
	                System.out.println("Date of Birth: "+rs.getString("dob"));
	                System.out.println("Address: "+ rs.getString("address"));
	                System.out.println("Phone_no: "+ rs.getInt("phone_no"));
	               
	                
	            }
	            con.close();
	        } catch (Exception e) {
	            System.out.println(e);
	           
	        }
	    }
	 
	 public static void updatePatientInformation( String patient_name, int  phone_no, String address, String gender , String dob ) {
	        String sql = "UPDATE patient SET patient_name = ?,phone_no = ?, address = ?,  gender = ? , dob =?";
	        try {
	        	Connection con = Connectionclass.getconnection();
	             PreparedStatement pst = con.prepareStatement(sql);
	            pst.setString(1, patient_name);
	            pst.setInt(2, phone_no);
	            pst.setString(3, address);
	         
	            pst.setString(4, gender);
	            pst.setString(5, dob);
	            int affectedRows = pst.executeUpdate();
	            if (affectedRows > 0) {
	                System.out.println("Patient information updated successfully.");
	            } else {
	                System.out.println("Patient not found.");
	            }
	            getPatientInformation(patient_name);
	            con.close();
	        } catch (Exception  e) {
	            System.out.println(e);
	        }
	    }
	 public static void deletePatient(String patient_name) {
	        String sql = "DELETE FROM patient WHERE patient_name = ?";
	        try {
	        	Connection con = Connectionclass.getconnection();
	        
	             PreparedStatement pst = con.prepareStatement(sql); {
	            pst.setString(1, patient_name);
	            int affectedRows = pst.executeUpdate();
	            if (affectedRows > 0) {
	                System.out.println("Patient deleted successfully.");
	            } else {
	                System.out.println("Patient not found.");
	            }}
	             con.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	 
	 
	 //Staff
	 
	 public static void Create_newStaff ()
		{
			try
			{
				Connection con = Connectionclass.getconnection();
				Scanner sc = new Scanner(System.in);
				PreparedStatement pst=con.prepareStatement("insert into Staff (staff_name,address,phone_no,gender,dob,department_name,department_no) values (?,?,?,?,?,?,?)");
				
				
				System.out.println("Enter the Staff_name");
				String staff_name = sc.nextLine();
				
				System.out.println("Enter address");
				String address = sc.nextLine();
				
				System.out.println("Enter the phone_no");
				int phone_no=sc.nextInt();
				
				System.out.println("Enter the gender");
				String gender = sc.next();
				
				
				System.out.println("Enter the Date of Birth");
				String dob = sc.next();
				
				System.out.println("Enter the department_name");
				String department_name = sc.next();
			int department_id = 0 ;
				pst.setString(1,staff_name);
				pst.setString(2, address);
				pst.setInt(3, phone_no);
				pst.setString(4, gender);
				pst.setString(5, dob);
				pst.setString(6, department_name);
				  if(department_name .equalsIgnoreCase("Doctor"))
		          {
		        	  department_id = 1;
		        	
		          }
		          else if(department_name .equalsIgnoreCase("Nurse"))
		          {
		        	  department_id = 2;
		          }
		          else if(department_name .equalsIgnoreCase("Medical"))
		          {
		        	  department_id = 3;
		          }
		          else if(department_name .equalsIgnoreCase("Receptionist"))
		          {
		        	  department_id = 4;
		          }  pst.setInt(7, department_id);
				
				pst.executeUpdate();
				
				getStaffInformation(staff_name);
				con.close();
				
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
	 public static void getStaffInformation(String  staff_name) {
	        String sql = "SELECT * FROM Staff WHERE staff_name = ?";
	        Connection con = Connectionclass.getconnection();
	        try {
	        	PreparedStatement pst = con.prepareStatement(sql); 

	            pst.setString(1, staff_name);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	                System.out.println("Patient ID: " + rs.getInt("staff_id"));
	                System.out.println("Name: " + rs.getString("staff_name"));
	                System.out.println("Gender: "+ rs.getString("gender"));
	                System.out.println("Date of Birth: "+rs.getString("dob"));
	                System.out.println("Address: "+ rs.getString("address"));
	                System.out.println("Phone_no: "+ rs.getInt("phone_no"));
	               System.out.println("Department Name: "+ rs.getString("department_name"));
	                
	            }
	            con.close();
	        } catch (Exception e) {
	            System.out.println(e);
	           
	        }
	    }
	 public static void updateStaffInformation(String staff_name, int  phone_no, String address, String gender , String dob , String department_name ) {
	        String sql = "UPDATE Staff SET Staff_name = ?,phone_no = ?, address = ?, gender = ? , dob =? , department_name =?, department_id =?";
	        try  {
	        	Connection con = Connectionclass.getconnection();
	             PreparedStatement pst = con.prepareStatement(sql);
	             int department_id;
	            pst.setString(1, staff_name);
	            pst.setInt(2, phone_no);
	            pst.setString(3, address);
	            pst.setString(4, gender);
	            pst.setString(5, dob);
	            pst.setString(6, department_name);
	            if(department_name .equalsIgnoreCase("Doctor") )
		          {
		        	  department_id = 1;
		        	  pst.setInt(7, department_id);
		          }
		          else if(department_name .equalsIgnoreCase("Nurse"))
		          {
		        	  department_id = 2;
		        	  pst.setInt(7, department_id);
		          }
		          else if(department_name .equalsIgnoreCase("Medical") )
		          {
		        	  department_id = 3;
		        	  pst.setInt(7, department_id);
		          }
		          else if(department_name .equalsIgnoreCase("Receptionist"))
		          {
		        	  department_id = 4;
		        	  pst.setInt(7,department_id);
		          }
	            
	            int affectedRows = pst.executeUpdate();
	            if (affectedRows > 0) {
	                System.out.println("Staff information updated successfully.");
	            } else {
	                System.out.println("Staff not found.");
	            }
	            getStaffInformation(staff_name);
	            con.close();
	        } catch (Exception  e) {
	            System.out.println(e);
	        }
	    }
	 
	 public static void deleteStaff(String staff_name) {
	        String sql = "DELETE FROM Staff WHERE staff_name = ?";
	        try { 
	        Connection con = Connectionclass.getconnection();
	             PreparedStatement pst = con.prepareStatement(sql); 
	            pst.setString(1, staff_name);
	            int affectedRows = pst.executeUpdate();
	            if (affectedRows > 0) {
	                System.out.println("Staff deleted successfully.");
	            } else {
	                System.out.println("Staff not found.");
	            }
	            con.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	 public static void getAllStaff() {
		 
		    String sql = "SELECT * FROM Staff";
		    try {Connection con = Connectionclass.getconnection();
		         PreparedStatement pst = con.prepareStatement(sql);
		         ResultSet rs = pst.executeQuery();
		        while (rs.next()) {
		            System.out.println("Staff ID: " + rs.getInt("staff_id") +
		                               ", Name: " + rs.getString("staff_name") +
		                               ", Department Name: " + rs.getString("department_name") +
		                               ",Department No: " + rs.getInt("department_id ") +
		                               ", Phone: " + rs.getString("phone_no") );
		        }
		        con.close();
		    } catch (Exception e) {
		        System.out.println("Error retrieving staff members: " + e.getMessage());
		    }
		}
	 
	 
	 //Department
	 
	 
	 public static void Create_department() {
	        String sql = "INSERT INTO department (department_name, department_id) VALUES (?, ?)";
	      
	        try {
	        	  Connection con = Connectionclass.getconnection();
	  	        Scanner sc = new Scanner(System.in);
	  	  	PreparedStatement pst=con.prepareStatement("insert into department (department_name,department_no) values (?,?)");
	             
	  	  	
	  	  	System.out.println("Enter the department Name :");
	  	  	
	  	    String department_name = sc.next();
	  	    
	  	  	int department_id = 0;
	  	  	
	          pst.setString(1, department_name);
	          
	          if(department_name .equalsIgnoreCase("Doctor") )
	          {
	        	  department_id = 1;
	        	  
	          }
	          else if(department_name .equalsIgnoreCase("Nurse") )
	          {
	        	  department_id = 2;
	        	
	          }
	          else if(department_name .equalsIgnoreCase("Medical"))
	          {
	        	  department_id = 3;
	        	
	          }
	          else if(department_name .equalsIgnoreCase("Receptionist") )
	          {
	        	  department_id = 4;
	        	
	          }
	         
	         pst.setInt(2,department_id);
	          
	           
	            pst.executeUpdate();
	            System.out.println("Department added successfully.");
	            getAllDepartments();
	            con.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	 public static void delete_department(String department_name) {
	        String sql = "DELETE FROM department WHERE department_name = ?";
	        try  {
	        	Connection con = Connectionclass.getconnection();
	             PreparedStatement pst = con.prepareStatement(sql);
	            pst.setString(1, department_name);
	            int affectedRows = pst.executeUpdate();
	            if (affectedRows > 0) {
	                System.out.println("department deleted successfully.");
	            } else {
	                System.out.println("department not found.");
	            }
	            getAllDepartments();
	            con.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	 
	 public static void getAllDepartments() {
		    String sql = "SELECT * FROM department";
		    try  {
		    	Connection con = Connectionclass.getconnection();
		         PreparedStatement pst = con.prepareStatement(sql);
		         ResultSet rs = pst.executeQuery();
		        while (rs.next()) {
		            System.out.println("Department ID: " + rs.getInt("department_no") +", Name: " + rs.getString("department_name"));
		        }
		        con.close();
		    } catch (Exception e) {
		        System.out.println(e);
		    }
		}
	 
	 //Appointment
	 
	 public static void addAppointment(String patient_name, String staff_name, String appoinment_date_and_time,String status) {
	        String sql = "INSERT INTO Appoitnment (patient_name, staff_name, appoinment_date_and_time ,appoinment_status) VALUES (?, ?, ?, ?)";
	        try {
	        	Connection con = Connectionclass.getconnection();
	             PreparedStatement pst = con.prepareStatement(sql); 
	            pst.setString(1, patient_name);
	            pst.setString(2, staff_name);
	            pst.setString(3, appoinment_date_and_time);
	            pst.setString(4, status);
	            pst.executeUpdate();
	            System.out.println("Appointment added successfully.");
	            getAppointment();
	            con.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	  public static void updateAppointment(int appointmentId,  String status) {
		  Scanner sc = new Scanner(System.in);
	        String sql = "UPDATE Appoitnment SET status = ?,appoinment_date_and_time =? WHERE appointment_id = ?";
	        String appoinment_date_and_time;
	        try {
	        	Connection con = Connectionclass.getconnection();
	             PreparedStatement pst = con.prepareStatement(sql);
	             
	           
	            pst.setString(1, status);
	            
	            if(status=="posponted")
	            {
	            	appoinment_date_and_time = sc.next();
	            	pst.setString(2,appoinment_date_and_time);
	            }
	            pst.setInt(3, appointmentId);
	            int updated = pst.executeUpdate();
	            
	            if (updated > 0) {
	                System.out.println("Appointment updated successfully.");
	            } else {
	                System.out.println("Appointment with ID " + appointmentId + " not found.");
	            }
	            getAppointment();
	            con.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	  public static void getAppointment() {
		    String sql = "SELECT Appoitnment.appoinment_id, patient.patient_name AS patient_name, Staff.staff_name AS staff_name, Appoitnment.appoinment_date_and_time " +
		                 "FROM Appoitnment " +
		                 "JOIN patient ON Appoitnment.patient_name = patient.patient_name " +
		                 "JOIN Staff ON Appoitnment.staff_name = Staff.staff_name";
		    try {
		    	Connection con = Connectionclass.getconnection();
		    
		         PreparedStatement pst = con.prepareStatement(sql);
		         ResultSet rs = pst.executeQuery() ;
		        while (rs.next()) {
		            System.out.println("Appointment ID: " + rs.getInt("appoinment_id") +
		                               ", Patient: " + rs.getString("patient_name") + " " +
		                               ", Staff: " + rs.getString("staff_name") + " "  +
		                               ", Date: " + rs.getString("appoinment_date_and_time") );
		        }
		        con.close();
		    } catch (Exception e) {
		        System.out.println(e);
		    }
		    }
	 

	

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("1)Patient 2)Staff  3)Appoinment 4)Department");
	int a = sc.nextInt();
	switch(a)
	{
	case 1:
	System.out.println("1)create_newpatient\n  2)updatePatientInformation\n 3)getPatientInformation\n 4)deletePatient");
	int pat = sc.nextInt();
	switch(pat)
	{
	case 1:
		Create_newpatient();
		break;
	case 2:
		System.out.println("Enter the Patient Name: ");
		String patient_name = sc.next();
		System.out.println("Enter the Phone Number :");
		int  phone_no = sc.nextInt();
		System.out.println("Enter the address");
		String address = sc.next();
		System.out.println("Enter the gender");
		String gender = sc.next();
		System.out.println("Enter the Date of Birth:");
		String dob = sc.next();
		updatePatientInformation( patient_name, phone_no, address, gender, dob);
		break;
	
	case 3:
		System.out.println("Enter the Patient Name");
		String name = sc.next();
	getPatientInformation(name);
	break;
	
	case 4:
		System.out.println("Enter the Patient Name");
		String name1 = sc.next();
		deletePatient(name1);
		default:
			System.out.println("Enter the valid number");
		
	}
break;

	case 2:
		System.out.println("1)Create_newStaff\n 2)updateStaffInformation\n 3)getStaffInformation\n 4)deleteStaff\n 5)getAllStaff");
		int b=sc.nextInt();
		switch(b)
		{
		case 1:
			Create_newStaff();
			break;
		case 2:
			System.out.println("Enter the staff_name");
			String staff_name =sc.next();
			System.out.println("Enter the phone_no");
		    int  phone_no = sc.nextInt();
		    System.out.println("Enter the address");
		    String address = sc.next();
		    System.out.println("Enter the gender");
		    String gender = sc.next(); 
		    System.out.println("Enter the dob");
		    String dob =sc.next();
		    System.out.println("Enter the department_name");
		    String department_name = sc.next();
			updateStaffInformation(staff_name, phone_no, address, gender, dob, department_name);
			break;
		case 3:
			System.out.println("Enter the staff_name");
			String staff_name1 =sc.next();
			getStaffInformation(staff_name1);
			break;
		case 4:
			System.out.println("Enter the staff_name");
			String staff_name2 =sc.next();
			deleteStaff(staff_name2);
		break;
		
		case 5:
			getAllStaff();
			break;
			default:
				System.out.println("Enter the valid number");
		
		}
		
		break;
		
	case 3:
      System.out.println("1)addAppointment\n 2) updateAppointment\n 3)getAppointment");	
      int c = sc.nextInt();
      switch(c)
      {
      case 1:
    	  System.out.println("Enter the patient_name");
    	  String patient_name = sc.next() ;
    	  System.out.println("Enter the staff_name");
    	   String staff_name = sc.next();
    	   System.out.println("Enter the appoinment_date_and_time");
    	   String appoinment_date_and_time = sc.next();
    	   System.out.println("Enter the status");
    	   String status = sc.next();
    	  addAppointment(patient_name, staff_name, appoinment_date_and_time, status);
    	  
    	  break;
    	  
      case 2:
    	  int appointmentId = sc.nextInt();
    	   String status1 = sc.next();
    	  updateAppointment(appointmentId, status1);
    	  break;
    	
      case 3:
    	  getAppointment();
    	  break;
    	  
    	  
    	  default:
    		  System.out.println("Enter the valid number");
      }
      break;
      
	case 4:
		System.out.println("1)Create_department\n 2)delete_department 3)getAllDepartments");
		int d = sc.nextInt();
		switch(d)
		{
		case 1:
			Create_department();
			break;
		
		case 2:
			String dept_name = sc.next();
			delete_department(dept_name);
			break;
		
		case 3:
			getAllDepartments();
			break;
			
			default:
				System.out.println("Enter the valid numbers");
			
		}
      
		default:
			System.out.println("Enter the valid number");
	}	
}
}
