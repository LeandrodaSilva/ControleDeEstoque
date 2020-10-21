/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.regex.PatternSyntaxException;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import views.components.TableComponent;
import views.components.TextFieldComponent;

/**
 *
 * @author ld_si
 */
public class SearchController extends EffectController {
    private TextFieldComponent tfSearch;
    private TableComponent table;
    
    
    public SearchController(TextFieldComponent tfSearch, TableComponent table) {
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
