/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entity.Gruppyi;
import entity.Studentyi;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
@Stateless
public class GroupService implements GroupInterface {
    private Session session; 
    
    public GroupService(){
      SessionFactory sf = HibernateUtil.getSessionFactory();
      session= sf.openSession();
     
   }
    

    @Override
    public List getTable() {
          Transaction t = this.session.beginTransaction();
          org.hibernate.Query query2 = this.session.createQuery("from Gruppyi g");
          List ups2 = (List)query2.list();
          t.commit();
          return ups2;
    }

    @Override
    public void delete(long id) {
        Transaction t = this.session.beginTransaction();
        Query q=session.createQuery("DELETE Gruppyi g WHERE g.shifr = :number");
        q.setParameter("number", id);
        q.executeUpdate();
        t.commit();       
    }

    @Override
    public void create(String nazvanie, Date dataFormir, int kodPlana, String status, Date statusDate, List<Studentyi> studentyis) {
        Gruppyi gr= new Gruppyi();
        Transaction t = this.session.beginTransaction();

        gr.setNazvanie(nazvanie);
        gr.setDataFormir(dataFormir);
        gr.setKodPlana(kodPlana);
        gr.setStatus(status);
        gr.setStatusDate(statusDate);
        gr.setStudentyiCollection(studentyis);
        this.session.saveOrUpdate(gr); 
        t.commit();
    }

    @Override
    public void update() {
        
    }
    
}
