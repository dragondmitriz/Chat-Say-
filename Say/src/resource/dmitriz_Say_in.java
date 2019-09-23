package resource;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author dmitriz
 */
public class dmitriz_Say_in implements Runnable{
    Socket s;
    ObjectOutputStream oos;
    String target;
    
    dmitriz_Say_in(String str){
        try{            
            s=new Socket(Form.server,37771);
            oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(str);
            target=str;
            Form.finish=true;
        }catch(IOException e){JOptionPane.showMessageDialog(null, "Конструктор считывания: "+e);}
    }
    
    @Override
    public void run(){
        ObjectInputStream ois=null;
        try{
            ois=new ObjectInputStream(s.getInputStream());
        }catch(IOException e){JOptionPane.showMessageDialog(null, "Считывание:"+e);}
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        try{
            ois.readObject();
            resource.dowland.dowland=false;
            Form.jLabel1.setText(target);
        }catch(IOException | ClassNotFoundException e){}
        while(!resource.Form.dmitriz_Say_in_quit){            
            try{
                resource.msg msg;
                msg=(resource.msg)ois.readObject();
                Resource.show_msg(msg);
            }catch(IOException | ClassNotFoundException e){}            
        }
        try{
           s.close();
           ois.close();
        }catch(IOException e){}
    }
}
