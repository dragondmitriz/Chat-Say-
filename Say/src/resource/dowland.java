package resource;

/**
 *
 * @author dmitriz
 */
public class dowland implements Runnable{
    public static boolean dowland=true;
    @Override
    public void run(){
        dowland=true;
        String str="";
        int ind=0;
        while(dowland){
            str+="|";
            ind+=1;
            Form.jProgressBar1.setValue(ind);
            Form.jProgressBar1.setString(Integer.toString(ind)+"%");
            Form.jLabel1.setText(str);
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){}
            if (str.length()>=100){
                str="";
                ind=0;
                Form.jProgressBar1.setValue(ind);
                Form.jProgressBar1.setString(Integer.toString(ind)+"%");
            }
        }
        ind=0;
        Form.jProgressBar1.setValue(ind);
        Form.jProgressBar1.setString(Integer.toString(ind)+"%");
    }
}
