package resource;
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;
/**
 *
 * @author dmitriz
 */
public class dmitriz_Say_out implements Runnable{
    Socket s;   
    String target;
    
    dmitriz_Say_out(String str){
        target=str;
    }
    @Override
    public void run(){
        try {
            ObjectOutputStream oos;
            s=new Socket(Form.server,37772);
            oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(target);
            while(!Form.dmitriz_Say_in_quit){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                if (Form.Say_out){
                    oos.writeObject(resource.Form.msg);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                    oos.flush();
                    oos.reset();
                    Form.Say_out=false;
                }
            }
        } catch(IOException e) {}
        resource.Form.msg=new msg();
    }
}
