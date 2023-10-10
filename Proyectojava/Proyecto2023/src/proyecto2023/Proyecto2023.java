/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2023;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.security.SecureRandom;
/**
 *
 * @author Romario
 */
public class Proyecto2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String Ruta = ".\\src\\proyecto2023\\contra.txt";
        String contraseña ="";
        try {
            FileReader fileReader = new FileReader(Ruta);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            contraseña = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        
        Scanner ContraSis = new Scanner(System.in);
        
        System.out.println("Sistema de Votacion");
        System.out.println("Ingrese la contraseña del sistema");
        
        String contraUsu = ContraSis.nextLine();
         if (contraUsu.equals(contraseña)){
            System.out.println("Contraseña Correcta");
             System.out.println("Seleccione una opcion");
            System.out.println("Menu principal del sistema");
            System.out.println("1. agregar usuario del sistema");
            System.out.println("2. Administrador de votaciones");
            System.out.println("3. Registro de votantes");
            System.out.println("4. Auditor");
           Scanner opcionScanner = new Scanner(System.in);
           int posicion = opcionScanner.nextInt();
         
          switch (posicion){
          case 1: AgregarUsuariodelSistema ();
          break;
          case 2: AdministradorVotacion(); 
          break;
          case 3: System.out.println("Registro de votantes");
          break;
          case 4: System.out.println("Auditor");
                
          }
            
        } else{
            System.out.println("Vuelta ingresar la contraseña");
        
    } 
}
    
public static void AgregarUsuariodelSistema (){
    Scanner Dato = new Scanner(System.in);
    String nombre="";
    String apellido= "";
    String sexo="";
    String FechaNacimiento="";
    int anoN =0;
    int DPI=0;
    String correo="";
    String paisresidencia="";
    String departamento="";
    String municipio = "";
    String DireccionAc="";
    String Contrasena="";
    int resta =0;
    System.out.println("AGREGAR USUARIO AL SISTEMA");
    System.out.println("Ingrese dia y mes de nacimiento");
    FechaNacimiento = Dato.nextLine();
    System.out.println("Ingrese año de nacimiento");
    anoN = Dato.nextInt();
    Dato.nextLine();
    resta= 2023-anoN;
    if (resta>=18) {
    System.out.println("Continue ingresando datos");  
    System.out.println("Ingrese los nombres ");
    nombre = Dato.nextLine();
    System.out.println("Ingrese apellidos");
    apellido = Dato.nextLine();
    System.out.println("Ingrese genero M o F");
    sexo = Dato.nextLine();
    System.out.println("Ingrese DPI");
    DPI = Dato.nextInt();
    Dato.nextLine();
    System.out.println("Ingrese correo electronico");
    correo = Dato.nextLine();
    System.out.println("Ingrese Pais de residencia actual");
    paisresidencia = Dato.nextLine();
    System.out.println("Ingrese Departamento");
    departamento = Dato.nextLine();
    System.out.println("Ingrese Municipio");
    municipio = Dato.nextLine();
    System.out.println("Ingrese direccion de vivienda");
    DireccionAc = Dato.nextLine();
    System.out.println("Asignar Rol ");
    System.out.println("1. adminstrador 2. Administrador de votaciones \n 3. Registrador de Votantes 4.Auditor 5. votante ");
  
    int opcionRol = Dato.nextInt();
    Dato.nextLine();
    String rol ="";
    switch (opcionRol) {
    case 1:
        rol = "Administrador";
        break;
    case 2:
        rol = "Administrador de Votaciones";
        break;
    case 3:
        rol = "Registrador de Votantes";
        break;
    case 4:
        rol = "Auditor";
        break;
    case 5:
        rol = "Votante";
        break;
    default:
        System.out.println("Opción de rol no válida.");
        return;
}
    String pass = generarContraseña();
    String Usuario = nombre +"|"+ apellido +"|"+ sexo+"|"+FechaNacimiento+"|"+ String.valueOf(anoN)+"|"+pass+"\n";
  String Ruta = ".\\src\\proyecto2023\\usuariosistema.txt";
    try {
                        FileWriter usuariosistema = new FileWriter(Ruta, true);
                        BufferedWriter bw = new BufferedWriter(usuariosistema);
                        bw.write(Usuario);
                        bw.close();
                    } catch (IOException ex) {
                        System.out.println(ex);
                        //ogger.getLogger(Proyecto2023.class.getName()).log(Level.SEVERE, null, ex);
                    }
    
        
    } else {
        System.out.println("Usuario menor de edad no puede emitir su voto");
    }
    
 
    
    
     
 }
public static void AdministradorVotacion ()  {  
    
    System.out.println("Administracion de votaciones");
    System.out.println("Selecciona la Gestion");
    System.out.println("1. Gestion elecciones");
    System.out.println("2. Gestion Candidatos");
    System.out.println("3. Reportes");
    
    
    
} 

private static final String CARACTERES_PERMITIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-=_+";
//variable global estatica
    public static String generarContraseña() {
        SecureRandom random = new SecureRandom();
        StringBuilder contraseña = new StringBuilder(16);

        for (int i = 0; i < 16; i++) {
            int index = random.nextInt(CARACTERES_PERMITIDOS.length());
            contraseña.append(CARACTERES_PERMITIDOS.charAt(index));
        }

        return contraseña.toString();
    }

}


