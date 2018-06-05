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
public interface StudInterface {
    
    List getTable();
    Studentyi getStud(long id);
    void delete(long id);
    void create(long nomerZachetki, int gruppyi, String familiya, String imya, String otchestvo, String gorod, String adres, String tel, String status, Date statusDate);
    void update(long nomerZachetki, int gruppyi, String familiya, String imya, String otchestvo, String gorod, String adres, String tel, String status);
    void update(Studentyi stud);
}

