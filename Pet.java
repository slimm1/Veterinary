package ARRAYS;

public class Pet
{
    private String name;
    private int id;
    private int countTr;
    private Treatment tr[] = new Treatment[20];
    
    public Pet(String name, int id){
        this.name=name;
        this.id=id;
        countTr=0;
    }
    
    public String getname(){
        return name;
    }
    
    public int getId(){
        return id;
    }
    
    public int getTreatNum(){
        return countTr;
    }
    
    public void addTreatment(Treatment newTr){
        if(!compareTreat(newTr)){
            tr[countTr++] = newTr; 
        }
    }
    
    public boolean compareTreat(Treatment newTr){
        for(int pos=0; pos<countTr;pos++){
            if(newTr.equals(tr[pos])){
                return true;
            }
        }
        return false;
    }
    
    public boolean equals(Object other){
        if(other==null){return false;}
        if(!(other instanceof Pet)){ return false;}
        Pet p = (Pet) other;
        if(id==p.getId()){return true;}
        return false;
    }
    
    public boolean sameTreat(Treatment compTr){
        for(int pos = 0; pos<countTr; pos++){
            if(tr[pos].getTreatment().equals(compTr.getTreatment())){
                return true;
            }
        }
        return false;
    }
    
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("ID: " + id + " nombre: " + name );
        output.append(System.getProperty("line.separator"));
        output.append(System.getProperty("line.separator"));
        for(int pos=0; pos<countTr; pos++){
            output.append((pos+1) + tr[pos].toString());
            output.append(System.getProperty("line.separator"));
        }
        return output.toString();
    }
    
    public String reWriteFormat(){
        StringBuilder output = new StringBuilder();
        if(countTr>1){
            for(int pos = 0; pos<countTr;pos++){
                if(pos==countTr-1){
                    output.append(name+"/"+id+"/" + tr[pos].reWriteFormat());
                    break;
                }
                output.append(name+"/"+id+"/" + tr[pos].reWriteFormat());
                output.append(System.getProperty("line.separator"));
            }
        }
        else{
            output.append(name+"/"+id+"/" + tr[0].reWriteFormat());
        }
        return output.toString();
    }
}
