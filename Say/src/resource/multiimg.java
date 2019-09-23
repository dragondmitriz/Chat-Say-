package resource;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;
/**
 *
 * @author user
 */
public class multiimg {
    public Image img;
    private int n;
    multiimg(Image e){
        img=e.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        n=1;
    }
    public void add(Image e){
        if (n<3){
            ImageIcon icon=new ImageIcon(img);
            BufferedImage grap=new BufferedImage(105*(n+1),100,BufferedImage.BITMASK);
            grap.getGraphics().drawImage(icon.getImage(), 0 , 0, null);
            icon=new ImageIcon(e.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
            grap.getGraphics().drawImage(icon.getImage(), 105*n++, 0, null);
            img=grap;
        }
        else{
            JOptionPane.showMessageDialog(null, "Можно отправить не более 3 изображений за одно сообщение!\nЭто сделано во имя компактности приложения.");
        }
    }
}
