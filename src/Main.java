import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\t******************************PESU HealthCare Management System***********************************\n");
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        // PersonFactory pf = new PersonFactory();
        // Person a = pf.getPerson("ADMIN");
        Admin a = new Admin();
        Patients p = null;
        Doctor d = null;
        while (true) {
            System.out.print(
                    "\t**********************************************************************************************\n");
            System.out.print(
                    "\t*                                                                                            *\n");
            System.out.print(
                    "\t*                  1. ADMIN - LOGIN                                                          *\n");
            System.out.print(
                    "\t*                  2. PATIENT - LOGIN                                                        *\n");
            System.out.print(
                    "\t*                  3. DOCTOR - LOGIN                                                         *\n");
            System.out.print(
                    "\t*                                                                                            *\n");
            System.out.print(
                    "\t*                  4. PATIENT-SIGN-UP                                                        *\n");
            System.out.print(
                    "\t*                                                                                            *\n");
            System.out.print(
                    "\t*                  5. EXIT                                                                   *\n");
            System.out.print(
                    "\t**********************************************************************************************\n");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: // Admins portal
                {
                    boolean checkadmin = false;
                    System.out.println("*****************Welcome to Admins portal***********************");
                    String un;
                    String pd;
                    System.out.print("USERNAME-->");
                    un = sc.next();
                    System.out.print("Password-->");
                    pd = sc.next();
                    if ((un.compareTo("abc") == 0 && pd.compareTo("1234") == 0)
                            || (un.compareTo("xyz") == 0 && pd.compareTo("1234") == 0)) {
                        while (true) {
                            System.out.print(
                                    "\t**********************************************************************************************\n");
                            System.out.print(
                                    "\t*                                                                                            *\n");
                            System.out.print(
                                    "\t*                  1.Doctors List                                                             *\n");
                            System.out.print(
                                    "\t*                  2.Patients List.                                                           *\n");
                            System.out.print(
                                    "\t*                  3.Add Doctor                                                               *\n");
                            System.out.print(
                                    "\t*                  4.Remove Doctor                                                            *\n");
                            System.out.print(
                                    "\t*                  5.Appointments Detail                                                      *\n");
                            System.out.print(
                                    "\t*                  6.View Feedbacks                                                           *\n");
                            System.out.print(
                                    "\t*                  7.View Reports                                                             *\n");
                            System.out.print(
                                    "\t*                  8.LOGOUT                                                                  *\n");
                            System.out.print(
                                    "\t**********************************************************************************************\n");
                            int ch = sc.nextInt();
                            switch (ch) {
                                case 1: {
                                    a.viewDoctors();
                                    break;
                                }
                                case 2: {
                                    a.viewPatients();
                                    break;
                                }
                                case 3: {
                                    int Id = a.addDoctor();
                                    d = new Doctor();
                                    d.DoctorRegistration(Id);
                                    break;
                                }
                                case 4: {
                                    System.out.println("Enter doctorID!!");
                                    int id = sc.nextInt();
                                    a.RemoveDoctor(id);
                                    break;
                                }
                                case 5: {
                                    a.ViewAppointment();
                                    break;
                                }
                                case 6: {
                                    a.ViewFeedback();
                                    break;
                                }
                                case 7: {
                                    a.ViewReports();
                                    break;
                                }
                                case 8: {
                                    checkadmin = true;
                                    break;

                                }
                                default: {
                                    System.out.println("Please Choose An Appropriate Option!!!");
                                }
                            }
                            if (checkadmin)
                                break;
                        }

                    } else
                        System.out.println("Invalid Username or Password");
                    break;
                }
                case 2:
                {
                    boolean checkPatient = false;
                    int flag = 0;
                    System.out.println("*****************Welcome to patient portal***********************");
                    int id;
                    String pd;
                    System.out.print("ID:");
                    id = sc.nextInt();
                    System.out.print("Password:");
                    pd = sc.next();
                    try {
                        Connection con = DatabaseConn.getCon();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("Select * from Users");
                        while (rs.next()) {
                            if (rs.getInt(1) == id && rs.getString(2).compareTo("Patient") == 0
                                    && (rs.getString(3).compareTo(pd) == 0)) {
                                flag = 1;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (flag == 1) {
                        p = new Patients();
                        while (true) {
                            System.out.print(
                                    "\t**********************************************************************************************\n");
                            System.out.print(
                                    "\t*                                                                                            *\n");
                            System.out.print(
                                    "\t*                  1.View Profile                                                             *\n");
                            System.out.print(
                                    "\t*                  2.View Doctors                                                             *\n");
                            System.out.print(
                                    "\t*                  3.Book Appointments                                                        *\n");
                            System.out.print(
                                    "\t*                  4.View Reports                                                              *\n");
                            System.out.print(
                                    "\t*                  5.View Appointments                                                        *\n");
                            System.out.print(
                                    "\t*                  6.View Previous Appointments                                               *\n");
                            System.out.print(
                                    "\t*                  7.Give FeedBack                                                           *\n");
                            System.out.print(
                                    "\t*                  8.LOGOUT                                                                  *\n");
                            System.out.print(
                                    "\t**********************************************************************************************\n");
                            int ch = sc.nextInt();
                            switch (ch) {
                                case 1: {
                                    p.ShowPatientDetails(id);
                                    break;
                                }
                                case 2: {
                                    p.viewDoctor();
                                    break;
                                }
                                case 3: {
                                    p.BookAppointment(id);
                                    break;

                                }
                                case 4: {
                                    p.ViewReport(id);
                                    break;
                                }
                                case 5: {
                                    p.viewAppointment(id);
                                    break;
                                }
                                case 6: {
                                    p.AppointmentHistory(id);
                                    break;
                                }
                                case 7: {
                                    p.Givefeedback(id);
                                    break;

                                }
                                case 8: {
                                    checkPatient = true;
                                    break;
                                }
                                default: {
                                    System.out.println("Please Choose An Appropriate Option!!!");
                                }
                            }
                            if (checkPatient)
                                break;
                        }
                    } else {
                        System.out.println("Invali UserID or password!!!");
                    }
                    break;
                }
                case 3:
                {
                    boolean checkDoctor = false;
                    System.out.println("***************Welcome to Doctors portal******************");
                    int flag = 0;
                    int id;
                    String pd;
                    System.out.print("DOCTOR - ID : ");
                    id = sc.nextInt();
                    System.out.print("Password : ");
                    pd = sc.next();
                    try {
                        Connection con = DatabaseConn.getCon();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("Select * from Users");
                        while (rs.next()) {
                            if (rs.getInt(1) == id && rs.getString(2).compareTo("Doctor") == 0
                                    && (rs.getString(3).compareTo(pd) == 0)) {
                                flag = 1;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Not Registerd");
                    }
                    if (flag == 1) {
                        while (true) {
                            System.out.print(
                                    "\t**********************************************************************************************\n");
                            System.out.print(
                                    "\t*                                                                                            *\n");
                            System.out.print(
                                    "\t*                  1.View Doctor Profile                                                     *\n");
                            System.out.print(
                                    "\t*                  2.View Appointments                                                        *\n");
                            System.out.print(
                                    "\t*                  3.Diagonise Patient                                                        *\n");
                            System.out.print(
                                    "\t*                  4.LOGOUT                                                                  *\n");
                            System.out.print(
                                    "\t*                                                                                            *\n");
                            System.out.print(
                                    "\t**********************************************************************************************\n");
                            int ch = sc.nextInt();
                            switch (ch) {
                                case 1: {
                                    d = new Doctor();
                                    d.ShowDoctorDetails(id);
                                    break;
                                }
                                case 2: {
                                    d = new Doctor();
                                    d.viewAppointment(id);
                                    break;
                                }
                                case 3: {
                                    d = new Doctor();
                                    d.DiagonistPatient(id);
                                    break;
                                }
                                case 4: {
                                    checkDoctor = true;
                                    break;
                                }
                                default: {
                                    System.out.println("Select Approprate option");
                                }
                            }
                            if (checkDoctor)
                                break;
                        }
                        break;
                    }
                    else {
                        System.out.println("Invalid Username or Password!!!");
                    }
                    break;
                }
                case 4:
                {
                    p = new Patients();
                    int pid = p.addPatient();
                    System.out.println("*** Fill the following details ***");
                    p.PatientRegistration(pid);
                    break;
                }
                case 5: {
                    System.out.println("**THANKS FOR VISITING US - Have A Nice Day**");
                    check = true;
                    break;
                }
                default: {
                    System.out.println("** PLEASE CHOOSE AN APPROPRIATE OPTION **");
                }
            }
            if (check)
                break;
        } 
        sc.close();
    }
}
