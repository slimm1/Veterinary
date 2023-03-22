package ARRAYS;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Treatment
{
    private static String[] tr = {"Castración","Inyección Letal","Lavado de dientes","Colonoscopia","Desparasitar","Vacunación"};
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
    private LocalDateTime dateTime;
    private String description;
    public Treatment(String newDate, int idDesc){
        if(idDesc>=tr.length){
            idDesc=5;
        }
        description=tr[idDesc];
        dateTime = LocalDateTime.parse(newDate, formatter);
    }
    
    public String getTreatment(){
        return description;
    }
    
    public LocalDateTime getDate(){
        return dateTime;
    }   
    
    public boolean equals(Object other){
        if(other==null){return false;}
        if(!(other instanceof Treatment)){return false;}
        Treatment tr = (Treatment) other;
        if(description.equalsIgnoreCase(tr.getTreatment()) && dateTime.equals(tr.getDate())){ return true;}
        return false;
    }
    
    public int getDescriptionId(String description){
        for(int pos=0;pos<tr.length;pos++){
            if(description.equalsIgnoreCase(tr[pos])){
                return pos;
            }
        }
        return-1;
    }
    
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(" Tratamiento ---> " + description + " con fecha " + dateTime.toString().replaceAll("T"," "));
        return output.toString();
    }
    
    public String reWriteFormat(){
        return dateTime.toString().replaceAll("T"," ")+"/"+ getDescriptionId(description);
    }
}
