public class PersonFactory {
    
   public Person getPerson(String personType){
    if(personType == null){
       return null;
    }		
    if(personType.equalsIgnoreCase("PATIENT")){
       return new Patients();
       
    } else if(personType.equalsIgnoreCase("DOCTOR")){
       return new Doctor();
       
    } else if(personType.equalsIgnoreCase("ADMIN")){
       return new Admin();
    }
    return null;
 }
}
