package resource;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author dmitriz
 */
public class MultilineCellRenderer extends javax.swing.JTextArea implements TableCellRenderer {

    private ArrayList<ArrayList<Integer>> rowColHeight = new ArrayList<ArrayList<Integer>>();

    public MultilineCellRenderer() {        
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
    }
    
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column) {
        
        //построение ячейки и обозначение её значений
        if (value!=null){
            resource.msg Msg=(resource.msg)value;
            ImageIcon img=Msg.getImage();
            if (img!=null){
                JButton label = new JButton();
                ImageIcon icon=img;
                label.setIcon(icon); 
                table.setRowHeight(row, 110);
                return label;
            }
            if (Msg.getAuthor()!=null)
                if (!Msg.getAuthor().equals("")) {
                    JTextPane pane=new JTextPane();
                    pane.setFont(new Font("Times New Roman",Font.BOLD,12)); 
                    pane.setText(Msg.getAuthor()+":");
                    table.setRowHeight(row, 20);
                    pane.setEditable(false);
                    return pane;}
                else
                    setText(Msg.getString());
            else
                setText(Msg.getString());
        }
        else{
            setText("");
        }
        this.setEditable(false);
        table.setCellSelectionEnabled(false);
        //определение параметров ячейки
        if (isSelected){
            setForeground(table.getSelectionBackground());
            setBackground(table.getSelectionBackground());
        } 
        else{
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        setFont(table.getFont());
        if (hasFocus){
            setBorder(UIManager.getBorder("Table.focusCellHightBorder"));
            if (table.isCellEditable(row, column)){
                setForeground(UIManager.getColor("Table.focusCellForeground"));
                setBackground(UIManager.getColor("Table.focusCellBackground"));
            }
        }
        else{
            setBorder(new javax.swing.border.EmptyBorder(1,2,1,2));
        }        
        int cWidth=table.getTableHeader().getColumnModel().getColumn(column).getWidth();
        setSize(new Dimension(cWidth,1000));
        int prefH=getPreferredSize().height;
        while (rowColHeight.size()<=row){
            rowColHeight.add(new ArrayList<Integer>(column));
        }
        ArrayList<Integer> colHeights=rowColHeight.get(row);
        while (colHeights.size()<=column){
            colHeights.add(0);
        }
        colHeights.set(column, prefH);
        int maxH=0;
        for(Integer colHeight: colHeights){
            if(colHeight>maxH){
                maxH=colHeight;
            }
        }
        if(table.getRowHeight(row)!=maxH){
            table.setRowHeight(row, maxH);
        }        
        return this;
    }
}
