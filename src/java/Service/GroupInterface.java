/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entity.Studentyi;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface GroupInterface {
     List getTable();
    void delete(long id);
    void create(String nazvanie, Date dataFormir, int kodPlana, String status, Date statusDate, List<Studentyi> studentyis);
    void update();
    
}
