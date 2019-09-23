package resource;
import java.io.*;
import java.net.*;
/**
 *
 * @author dmitriz
 */
public class dmitriz_out_world implements Runnable{
    @Override
    public void run()
    {
        try {
            Socket s=new Socket(resource.Form.server,27773);
            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(resource.Form.msg);
            oos.close();
            s.close();
        } catch(IOException e) {}
        resource.Form.msg=new msg();
    }
}
