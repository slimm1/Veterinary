package ARRAYS;
import java.util.Scanner;
/**
 * Write a description of class MainUse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainUse
{
    static ManagePets m = new ManagePets();
    static Scanner sc = new Scanner(System.in);
    static int aux=1;
    public static void main (String[]Args){
        m.extractFromFile();
        printMenu();
    }
    private static void printMenu(){
        System.out.println("*------------------------------------*");
        System.out.println("| >>>>>>>>>>>>>> MENU <<<<<<<<<<<<<< |");
        System.out.println("*------------------------------------*");
        System.out.println("| 1.- Dar de alta una mascota...     |");
        System.out.println("*------------------------------------*");
        System.out.println("| 2.- Añadir un tratamiento....      |");
        System.out.println("*------------------------------------*");
        System.out.println("| 3.- Eliminar mascota...            |");
        System.out.println("*------------------------------------*"); 
        System.out.println("| 4.- Mascotas con mismo tratamiento |");
        System.out.println("*------------------------------------*");
        System.out.println("| 5.- Generar fichero de datos...    |");
        System.out.println("*------------------------------------*");
        System.out.println("| 6.- Guardar datos y salir....      |");
        System.out.println("*------------------------------------*");  
        System.out.println("| 7.- Salir sin guardar...           |");
        System.out.println("*------------------------------------*"); 
        int respuesta = toInt(sc.nextLine());
        while(respuesta<=0||respuesta>7){
            System.out.println("*-------------*");
            System.out.println("| No entiendo |");
            System.out.println("*-------------*");
            respuesta = toInt(sc.nextLine());
        }
        menuCondition(respuesta);
    }
    
    private static void menuCondition(int answer){
        switch(answer){
            case 1:
                m.addPet(addNewPet());
                printMenu();
                break;
            case 2:
                addTreatToPet();
                printMenu();
                break;
            case 3: 
                deletePet();
                break;
            case 4: 
                showNamesSharedTr();
                printMenu();
                break;
            case 5: 
                m.exportFile();
                printMenu();
                break;
            case 6: if(aux==0){System.out.println("*--------------------------------------------------*");
                               System.out.println("| No puedes SALIR, tienes mascotas sin tratamiento |");
                               System.out.println("*--------------------------------------------------*");
                                printMenu();
                                break;
                            }else{m.reWrite();
                                System.out.println("*--------------*");
                                System.out.println("| Hasta luego! |");
                                System.out.println("*--------------*");
                                break;}
                
            case 7:
                System.out.println("*--------------*");
                System.out.println("| Hasta luego! |");
                System.out.println("*--------------*");
                break;
            default:
                break;
        }
    }
    
    private static Pet addNewPet(){
        aux=0;
        String name;
        int id;
        System.out.println("*------------------------------------------*");
        System.out.println("| Introduce el nombre de la nueva mascota: |");
        System.out.println("*------------------------------------------*");
        name=sc.nextLine();
        System.out.println("*--------------------------------------*");
        System.out.println("| Introduce el id de la nueva mascota: |");
        System.out.println("*--------------------------------------*");
        id=toInt(sc.nextLine());
        Pet newPet = new Pet(name, id);
        while(m.comparePets(newPet)){
            System.out.println("*--------------------------- -*");
            System.out.println("| Este ID ya está registrado! |");
            System.out.println("*-----------------------------*");
            System.out.println("*--------------------------------------*");
            System.out.println("| Introduce el id de la nueva mascota: |");
            System.out.println("*--------------------------------------*");
            id=toInt(sc.nextLine());
            newPet = new Pet(name, id);
        }
        System.out.println("*-------------------------------------------*");
        System.out.println("| Se ha registrado la mascota exitosamente! | --> " + newPet.getname());
        System.out.println("*-------------------------------------------*");
        return newPet;
    } 
    
    private static void addTreatToPet(){
        System.out.println("*--------------------------------*");
        System.out.println("| Introduce el ID de la mascota: |");
        System.out.println("*--------------------------------*");
        int answer=toInt(sc.nextLine());
        while(answer<=0 || answer > m.getLength()){
            System.out.println("*-------------------*");
            System.out.println("| Este ID no existe |");
            System.out.println("*-------------------*");
            answer=toInt(sc.nextLine());
        }
        Pet myP = m.getPetById(answer);
        System.out.println("Elige un tratamiento para la mascota ---> " + myP.getname());
        Treatment newT= createTrScanner();
        myP.addTreatment(newT);
        System.out.println("*-----------------------------------------------*");
        System.out.println("| Se ha registrado el tratamiento exitosamente! |");
        System.out.println("*-----------------------------------------------*"); 
        aux++;
    }
    
    private static Treatment createTrScanner(){
        System.out.println("*-----------------------*");
        System.out.println("| 0.- Castración...     |");
        System.out.println("*-----------------------*");
        System.out.println("| 1.- Inyección letal   |");
        System.out.println("*-----------------------*");
        System.out.println("| 2.- Lavado de dientes |");
        System.out.println("*-----------------------*");
        System.out.println("| 3.- Colonoscopia...   |");
        System.out.println("*-----------------------*");
        System.out.println("| 4.- Desparasitar...   |");
        System.out.println("*-----------------------*");
        System.out.println("| 5.- Vacunación.....   |");
        System.out.println("*-----------------------*");
        int answer=toInt(sc.nextLine());
        while(answer<0 || answer > 5){
            System.out.println("*------------------*");
            System.out.println("| Opción no válida |");
            System.out.println("*------------------*");
            answer=toInt(sc.nextLine());
        }
        System.out.println("Introduce la fecha formateada (\"aaaa-MM-dd HH:mm\")");
        String date = sc.nextLine();
        while(!date.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}$")){
            System.out.println("*-----------------*");
            System.out.println("| Formato erróneo |");
            System.out.println("*-----------------*"); 
            date = sc.nextLine();
        }
        Treatment newT = new Treatment(date, answer-1);
        return newT;
    }
    
    private static void deletePet(){
        int id;
        System.out.println("*--------------------------------------------------*");
        System.out.println("| Introduce el ID de la mascota para darla de baja |");
        System.out.println("*--------------------------------------------------*");
        id=toInt(sc.nextLine());
        while(id<=0 || id > m.getLength()){
            System.out.println("*-------------------*");
            System.out.println("| Este ID no existe |");
            System.out.println("*-------------------*");
            id=toInt(sc.nextLine());
        }
        Pet deleteP= m.getPetById(id);
        System.out.println("*--------------------------------------------*");
        System.out.println("| Seguro que quieres dar de baja la mascota? | --> " + deleteP.getname());
        System.out.println("*--------------------------------------------*");  
        System.out.println(" --> Pulsa ENTER para continuar. Introduce un caracter para cancelar");
        String answer=sc.nextLine();
        if(!answer.isBlank()){
            printMenu();
        }
        else{
            int index = m.getPosObject(deleteP);
            m.deletePetFromIndex(index);
            System.out.println("*------------------------------------------*");
            System.out.println("| Se ha eliminado la mascota exitosamente! |");
            System.out.println("*------------------------------------------*");  
            printMenu();
        }
    }
    
    private static void showNamesSharedTr(){
        System.out.println("Elige un tratamiento para comparar: ");
        System.out.println("*-----------------------*");
        System.out.println("| 0.- Castración...     |");
        System.out.println("*-----------------------*");
        System.out.println("| 1.- Inyección letal   |");
        System.out.println("*-----------------------*");
        System.out.println("| 2.- Lavado de dientes |");
        System.out.println("*-----------------------*");
        System.out.println("| 3.- Colonoscopia...   |");
        System.out.println("*-----------------------*");
        System.out.println("| 4.- Desparasitar...   |");
        System.out.println("*-----------------------*");
        System.out.println("| 5.- Vacunación.....   |");
        System.out.println("*-----------------------*");
        int answer=toInt(sc.nextLine());
        while(answer<0 || answer > 5){
            System.out.println("*------------------*");
            System.out.println("| Opción no válida |");
            System.out.println("*------------------*");
            answer=toInt(sc.nextLine());
        }
        Treatment t = new Treatment("2022-08-21 12:21", answer);
        Pet[] listP = m.sharedTreatment(t);
        if(listP!=null){
            StringBuilder sb = new StringBuilder();
            sb.append("COMPARANDO --> " + t.getTreatment());
            sb.append(System.getProperty("line.separator"));
            sb.append(System.getProperty("line.separator"));
            for(Pet content:listP){
                sb.append("ID " + content.getId());
                sb.append(" " + content.getname());
                sb.append(System.getProperty("line.separator"));
            }
            System.out.println(sb.toString());
        }
        else{
            System.out.println("*------------------------------------------*");
            System.out.println("| No existen mascotas con ese tratamiento! |");
            System.out.println("*------------------------------------------*");  
        }
    }
    
    private static boolean fullInt(String respuesta){
        for(int pos=0; pos<respuesta.length(); pos++){
            if(!(Character.isDigit(respuesta.charAt(pos)) || (respuesta.charAt(pos)=='-' && pos==0))){
                return false;
            }
        }
        return true;
    }

    private static int toInt(String respuesta){
        while(!fullInt(respuesta) || respuesta.isBlank()){
            System.out.println("El número introducido no es correcto");
            respuesta=sc.nextLine();
        }
        int numero=Integer.valueOf(respuesta);
        return numero;
    }
}
