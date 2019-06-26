/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.regex.PatternSyntaxException;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import view.basic.Table;
import view.basic.TextField;

/**
 *
 * @author ld_si
 */
public class ControllerSearch implements CaretListener{
    private TextField tfSearch;
    private Table table;
    
    
    public ControllerSearch(TextField tfSearch, Table table) {
        this.table = table;
        this.tfSearch = tfSearch;
        this.tfSearch.addCaretListener(this);
    }
    
    @Override
    public void caretUpdate(CaretEvent e) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        String text = tfSearch.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter(text));
            } catch (PatternSyntaxException pse) {
                System.err.println("Erro na busca: " + pse.getMessage());
            }
        }
    }
    
}
