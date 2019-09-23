package resource;

import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author dmitriz
 */
public class msg implements java.io.Serializable{
    private String author;
    private String str;
    private ImageIcon img=null;
    msg(){
        str=null;
        img=null;
        author=null;
    }
    public String getString(){
        return str;
    }
    public ImageIcon getImage(){
        return img;
    }
    public void addImage(Image e){
        img=new ImageIcon(e);
    }
    public void setText(String e){
        str=e;
    }
    public void clear(){
        img=null;
    }
    public void setAuthor(String Author){
        author=Author;
    }
    public String getAuthor(){
        return author;
    }
}
