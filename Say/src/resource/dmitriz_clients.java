package resource;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import static resource.Form.clients;
import static resource.Form.server;

/**
 *
 * @author dmitriz
 */
public class dmitriz_clients implements Runnable{
    @Override
    public void run(){
        while(Form.go){
            try{
                Socket s=new Socket(server,17773);
                ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
                clients=(ArrayList<Client>)ois.readObject();
                ois.close();
                s.close();
            }catch(IOException | ClassNotFoundException e){}
            DefaultListModel model=new DefaultListModel();
            for(int i=0;i<clients.size();i++){
                if (clients.size()>0)
                    if (!clients.get(i).getName().equals(Resource.name))
                        model.addElement(clients.get(i).getName());
            }
            Form.jList2.setModel(model);
            try {
            Thread.sleep(10000);
            } catch (InterruptedException e) {}
        }
    }
}
