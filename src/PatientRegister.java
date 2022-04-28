// import java.sql.*;

// public class PatientRegister implements Register {
    
//     @Override
//     public void Registerr(){

//     }

//     public void register(int pid, String fn, String ln, String G, String cn, int age, String Eid, String BloodGroup, String Address) {
//         try {
//             Connection con = DatabaseConn.getCon();
//             Statement st = con.createStatement();
//             st.executeUpdate("INSERT INTO Patients VALUES ('" + pid + "','" + fn + "','" + ln + "','" + G + "','" + cn
//                     + "','" + age + "','" + Eid + "','" + BloodGroup + "','" + Address + "')");
//             System.out.println("Registered Succesfully!!");
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
//     }
// }
