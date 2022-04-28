// import java.sql.*;

// public class DoctorRegister implements Register{
//     @Override
//     public void Registerr(){

//     }

//     public void doctor_Registration(int docid, String fn, String ln, String G, String cn, int age, int ec, String Q,
//             String dt, String ed) {
//         try {
//             Connection con = DatabaseConn.getCon();
//             Statement st = con.createStatement();
//             st.executeUpdate("INSERT INTO Doctors VALUES ('" + docid + "','" + fn + "','" + ln + "','" + G + "','" + cn
//                     + "','" + age + "','" + ec + "','" + Q + "','" + dt + "','" + ed + "')");
//             System.out.println("Doctor Added Successully");
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
//     }
// }
