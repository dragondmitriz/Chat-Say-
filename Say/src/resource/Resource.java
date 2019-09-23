package resource;

/**
 *
 * @author dmitriz
 */
public class Resource {
    public static void show_msg(resource.msg msg){
        if ((msg.getAuthor()!=null)||(!msg.getAuthor().equals(""))){ 
            msg author=new msg();
            author.setAuthor(msg.getAuthor());
            if (resource.Form.jTable1.getValueAt(13, 0)!=null) {
                for(int i=0;i<13;i++) 
                resource.Form.jTable1.setValueAt(resource.Form.jTable1.getValueAt(i+1, 0), i, 0);
                resource.Form.jTable1.setValueAt(author, 13, 0);
            }
            else{
                int ind=0;
                while(resource.Form.jTable1.getValueAt(ind, 0)!=null){
                    ind++;
                }
               resource.Form.jTable1.setValueAt(author, ind, 0);
            }
        }
        if (msg.getImage()!=null){
                    if (resource.Form.jTable1.getValueAt(13, 0)!=null) {
                        for(int i=0;i<13;i++) 
                            resource.Form.jTable1.setValueAt(resource.Form.jTable1.getValueAt(i+1, 0), i, 0);
                        resource.Form.jTable1.setValueAt(msg, 13, 0);
                    }
                    else{
                        int ind=0;
                        while(resource.Form.jTable1.getValueAt(ind, 0)!=null){
                            ind++;
                        }
                        resource.Form.jTable1.setValueAt(msg, ind, 0);
                    }  
                }
        if ((msg.getString()!=null)&&(!msg.getString().equals(""))){
                    resource.msg Msg=new resource.msg();
                    Msg.setText(msg.getString());
                    if (resource.Form.jTable1.getValueAt(13, 0)!=null) {
                        for(int i=0;i<13;i++) 
                            resource.Form.jTable1.setValueAt(resource.Form.jTable1.getValueAt(i+1, 0), i, 0);
                        resource.Form.jTable1.setValueAt(Msg, 13, 0);
                    }
                    else{
                        int ind=0;
                        while(resource.Form.jTable1.getValueAt(ind, 0)!=null) {
                            ind++;
                        }
                        resource.Form.jTable1.setValueAt(Msg, ind, 0);
                    } 
                } 
    }
    
    public static String name;
}
