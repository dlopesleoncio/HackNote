/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Options;

/**
 *
 * @author diogo
 */


public class OptionTableModel extends AbstractTableModel{

    String[] columns = {"Comando","Descrição"};
    List<Options> options = new ArrayList();
    @Override
    public int getRowCount() {  
        return options.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
        
            case 0:
                return options.get(rowIndex).getOptionCommand();
                
            
            case 1:
                return options.get(rowIndex).getDescription();
            default:
                return "dados não encontrados";
        } 
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    
}
