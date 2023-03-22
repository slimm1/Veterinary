package ARRAYS;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
/**
 * Write a description of class ManagePets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ManagePets
{
    private static Pet ps[] = new Pet[100];
    private static int addPet;
    public void exportFile(){
        try{
            File output = new File("C:/Users/mramondas01/MARTIN RAMONDA DAM/PROG/FICHEROS/prueba_salida.txt");
            PrintWriter pw = new PrintWriter(output);
            orderArray();
            for(int pos=0; pos<addPet; pos++){
                pw.println(ps[pos].toString());
            }
            System.out.println("Se han exportado los datos");
            pw.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("*************** NO SE HA ENCONTRADO FICHERO ***************");
        }
    }
    
    public void extractFromFile(){
        File f = new File("C:/Users/mramondas01/MARTIN RAMONDA DAM/PROG/FICHEROS/prueba.txt");
        try{
            Scanner read = new Scanner(f);
            String petName;
            String date;
            int petId;
            int treatId;
            String[] line;
            addPet=0;
            while(read.hasNext()){
                line = read.nextLine().split("/");
                petName = line[0];
                petId= Integer.parseInt(line[1]);
                date = line[2];
                treatId=Integer.parseInt(line[3]);
                Pet lilPet = new Pet(petName,petId);
                if(!comparePets(lilPet)){
                    ps[addPet]= lilPet;
                    Treatment newTr = new Treatment(date,treatId);
                    if(!ps[addPet].compareTreat(newTr)){
                        ps[addPet].addTreatment(newTr);
                    }
                    addPet++;
                }
                else{
                    Treatment newTr = new Treatment(date,treatId);
                    if(!ps[getPosObject(lilPet)].compareTreat(newTr)){
                        ps[getPosObject(lilPet)].addTreatment(newTr);
                    }
                }
            }
            System.out.println("Se han importado los datos");
            read.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("*************** NO SE HA ENCONTRADO FICHERO ***************");
        }
    }
    
    public void reWrite(){
        try{
            File output = new File("C:/Users/mramondas01/MARTIN RAMONDA DAM/PROG/FICHEROS/prueba.txt");
            PrintWriter pw = new PrintWriter(output);
            orderArray();
            for(int pos=0; pos<addPet; pos++){
                pw.println(ps[pos].reWriteFormat());
            }
            System.out.println("Se han exportado los datos");
            pw.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("*************** NO SE HA ENCONTRADO FICHERO ***************");
        }
    }
    
    public boolean comparePets(Pet newP){
        for(int pos=0; pos<addPet;pos++){
            if(newP.equals(ps[pos])){
                return true;
            }
        }
        return false;
    }
    
    public int getPosObject(Pet newP){
        for(int pos=0; pos<addPet;pos++){
            if(newP.equals(ps[pos])){
                return pos;
            }
        }
        return -1;
    }
    
    public void addPet(Pet newP){
        ps[addPet] = newP;
        addPet++;
    }
    
    public Pet getPetById(int id){
        for(int pos = 0; pos<addPet; pos++){
            if(ps[pos].getId()==id){
                return ps[pos];
            }
        }
        return null;
    }
    
    public int getLength(){
        return addPet;
    }
    
    public void deletePetFromIndex(int index){
        Pet aux = ps[index];
        for(int pos=index; pos<addPet;pos++){
            ps[pos]=ps[pos+1];
        }
        addPet--;
    }
    
    public Pet[] sharedTreatment(Treatment tr){
        Pet[] aux = new Pet[addPet];
        int count=0;
        for(int pos=0; pos<addPet;pos++){
            if(ps[pos].sameTreat(tr)){
                aux[count]=ps[pos];
                count++;
            }
        }
        if(count>0){
            return Arrays.copyOf(aux, count);
        }
        return null;
    }

    public void orderArray(){
        Pet aux;
        for(int pos = 0; pos<addPet; pos++){
            for(int pos2=0; pos2<(addPet-pos-1);pos2++){
                if(ps[pos2].getId()>ps[pos2+1].getId()){
                    aux = ps[pos2];
                    ps[pos2] = ps[pos2+1];
                    ps[pos2+1] = aux;
                }
            }
        }
    }
}
