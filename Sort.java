/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Long
 */
public class Sort {

    public static void sort(List<Student> items, boolean asc) {

        Student tmp = null;
        for (int i = 0; i < items.size(); i++) {
            int index = i;
            for (int j = i; j < items.size(); j++) {
                if (asc) {
                    if (items.get(index).getName().compareToIgnoreCase(items.get(j).getName()) < 0) {
                        index = j;
                    }
                } else {
                    if (items.get(index).getName().compareToIgnoreCase(items.get(j).getName()) > 0) {
                        index = j;
                    }
                }
                if (i != index) {
                    tmp = items.get(i);
                    items.set(i, items.get(index));
                    items.set(index, tmp);
                }
            }
          
        }
    }
    
    

    public static void reverse(List<Student> items) {
        
        Student tmp = null;
        for( int i = 0, j = items.size() - 1; i > j; i++, j--){
            tmp = items.get(i);
            items.set(i, items.get(j));
            items.set(j, tmp);
        }
    }
}
