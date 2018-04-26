/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
//https://docs.oracle.com/javase/tutorial/collections/interfaces/sorted-set.html

package selectcontractlab;

import java.util.Comparator;
import java.util.Set;
/**
 *
 * @author Evan
 * @param <String>
 */
public interface SortedSet <String> extends Set<String> {
    SortedSet<String> subSet(String fromElement, String toElement);
    SortedSet<String> headSet(String toElement);
    SortedSet<String> tailSet(String fromElement);

    // Endpoints
    String first();
    String last();

    // Comparator access
    Comparator<? super String> comparator();
}
