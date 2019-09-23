package resource;
import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;
import javax.swing.table.*;
import javax.swing.*;
/**
 *
 * @author dmitriz
 */
public class dmitriz_world_in implements Runnable{  
    public dmitriz_world_in(){
        try{
            resource.Form.finish=false;
            Socket s=new Socket(resource.Form.server,27775);
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());           
            Thread.sleep(10);
            try{
            for(int j=0;j<=7;j++){
                resource.msg msg=(resource.msg)ois.readObject();
                Resource.show_msg(msg);
            }
            }catch(ClassNotFoundException e){}
                catch(IOException e){
            ois.close();
            s.close();}
        }catch(IOException | InterruptedException e){}
        resource.Form.finish=true;
    }
    
    @Override
    public void run(){     
        Socket s=null;
        ObjectInputStream ois=null;
        try{
            s=new Socket(resource.Form.server,27771);
            ois=new ObjectInputStream(s.getInputStream()); 
        }catch(IOException e){}
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        while(!resource.Form.dmitriz_world_in_quit){            
            try{
                resource.msg msg=new msg();
                msg=(resource.msg)ois.readObject();
                Resource.show_msg(msg);
            }catch(IOException | ClassNotFoundException e){
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException ex){}}            
        }
        try{
           s.close();
           ois.close();
        }catch(IOException e){}
    }
}

