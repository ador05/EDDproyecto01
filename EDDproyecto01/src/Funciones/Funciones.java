/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;
import EDD.ListaVertices;
import EDD.Vertice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import EDD.ListaAristas;
import EDD.Arista;
/**
 *
 * @author ador_2005
 */
public class Funciones {
    
    public void write_txt(ListaVertices usuarios){
        String usuarios_actuales = "";
        if (!usuarios.EsVacio()){
            Vertice temp = usuarios.getInicio();
            for (int i = 0; i < usuarios.getSize(); i++) {
                usuarios_actuales += temp.getID() + "," + temp.getUsername()+ "\n";
                temp = temp.getpNext();
            }
        }
        try{
            PrintWriter pw= new PrintWriter("test//usuarios.txt");
            pw.print(usuarios_actuales);
            pw.close();
            
        }catch(Exception err){
            System.out.println("Error de escritura");
        }
        
    }
    
    public ListaVertices LeerUsuarios(){
        ListaVertices usuarios = new ListaVertices();
        String line;
        String usuarios_txt = "";
        String path = "test//usuarios.txt";
        File file = new File(path);
        
        try{
            if(!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine()) != null){
                    if(!line.isEmpty()){
                        if (!"Usuarios".equals(line) && !"usuarios".equals(line)){
                            if(!"relaciones".equalsIgnoreCase(line)){
                                usuarios_txt += line + "\n"; 
                            }else{
                                break;
                            }
                               
                        }                   
                    }
                }
                if (!"".equals(usuarios_txt)){
                    String[] usuarios_split = usuarios_txt.split("\n");
                    for (int i = 0; i < usuarios_split.length; i++) {
                        String[] usuario = usuarios_split[i].split(", ");
                        usuarios.insertar_final(Integer.parseInt(usuario[0]), usuario[1]);
                        
                    }
                }
                br.close();
//                System.out.println("Lectura exitosa");
            }
            
        }catch(Exception err){
            System.out.println("Error de lectura");
            
        }
        return usuarios;
    }
    public ListaAristas LeerRelaciones(){
        ListaAristas relaciones = new ListaAristas();
        String line;
        String relaciones_txt = "";
        String path = "test//usuarios.txt";
        File file = new File(path);
        int check = 0;
        
        try{
            if(!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine()) != null){
                   
                    if(!line.isEmpty()){
                        if ("relaciones".equalsIgnoreCase(line)){
                            check = 1;
                        }
                        
                        if (check == 1){
                            if(!"relaciones".equalsIgnoreCase(line)){
                                relaciones_txt += line + "\n"; 
   
                        }                   
                    }
                }
                }
                if (!"".equals(relaciones_txt)){
                    String[] relaciones_split = relaciones_txt.split("\n");
                    String[] relacion;
                    for (int i = 0; i < relaciones_split.length; i++){
                        
                        try{
                            relacion = relaciones_split[i].split(", ");
                            int id1 = Integer.parseInt(relacion[0]);
                        
                            int id2 = Integer.parseInt(relacion[1]);
                        
                            int size = Integer.parseInt(relacion[2]);
                                                     
                            relaciones.insertar_final(id1, id2, size);
                            
                        }catch (Exception e){
                            relacion = relaciones_split[i].split(",");
                            
                            int id1 = Integer.parseInt(relacion[0]);
                        
                            int id2 = Integer.parseInt(relacion[1]);
                        
                            int size = Integer.parseInt(relacion[2]);
                                                     
                        relaciones.insertar_final(id1, id2, size);
                        }
                       
                        
                        
                        
                    }
                }
                br.close();
//                System.out.println("Lectura exitosa");
            }
            
        }catch(Exception err){
            System.out.println("Error de lectura");
            
        }
        return relaciones;
    }
}
