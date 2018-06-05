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
import javax.ejb.Local;
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
public class ServiceBean implements StudInterface{
    private Session session; 
    
    public ServiceBean(){
      SessionFactory sf = HibernateUtil.getSessionFactory();
      session= sf.openSession();
     
   }
   

    @Override
    public List getTable() {
          //Transaction t = this.session.beginTransaction();
          org.hibernate.Query query =   this.session.createQuery("from Studentyi u"); 
          List ups = (List)query.list();
          //t.commit();
          System.out.println("go");
          return ups;
    }

    @Override
    public void delete(long id) {
        Transaction t = this.session.beginTransaction();
        Query q=session.createQuery("DELETE Studentyi s WHERE s.nomerZachetki = :number");

    q.setParameter("number", id);

    q.executeUpdate();
    t.commit();
        
    }

    @Override
    public void create(long nomerZachetki, int gruppyi, String familiya, String imya, String otchestvo, String gorod, String adres, String tel, String status, Date statusDate) {
        
   Transaction t = this.session.beginTransaction();
   Studentyi St =new Studentyi(); 
      St.setNomerZachetki(nomerZachetki);
      St.setStatus(status);
      St.setStatusDate(statusDate);
      St.setFamiliya(familiya);
      St.setImya(imya);
      St.setOtchestvo(otchestvo);
      St.setAdres(adres);
      St.setGorod(gorod);
      St.setShifrGruppyi((Gruppyi) this.session.load(Gruppyi.class,gruppyi));
      St.setTel(tel);
      
      this.session.saveOrUpdate(St);  
      t.commit();
    }

    @Override
    public void update(long nomerZachetki, int gruppyi, String familiya, String imya, String otchestvo, String gorod, String adres, String tel, String status) {
        Transaction tx = this.session.beginTransaction();
        Studentyi Stud =getStud(nomerZachetki);
        Stud.setAdres(adres);
        Stud.setFamiliya(familiya);
        Stud.setImya(imya);
        Stud.setOtchestvo(otchestvo);
        Stud.setNomerZachetki(nomerZachetki);
        Stud.setStatus(status);
        Stud.setTel(tel);
        Stud.setShifrGruppyi((Gruppyi) this.session.load(Gruppyi.class,gruppyi));
        this.session.saveOrUpdate(Stud);
        
       /*Query query = this.session.createQuery("update Studentyi set adres = :adres, gorod = :gorod, tel = :tel, status=:status, shifrGruppyi=:shifrGruppyi ,imya=:imya, familiya=:familiya, otchestvo=:otchestvo "+
                " where nomerZachetki = :nomerZachetki");
        query.setParameter("imya",imya);
        query.setParameter("familiya",familiya);
        query.setParameter("otchestvo",otchestvo);
        query.setParameter("status",status);
        query.setParameter("shifrGruppyi",(Gruppyi) this.session.load(Gruppyi.class,gruppyi));
        query.setParameter("adres",adres);
        query.setParameter("gorod", gorod);
        query.setParameter("tel",  tel);
        query.setParameter("nomerZachetki", nomerZachetki);
        
        query.executeUpdate();*/
        tx.commit();
        
        
    }

    @Override
    public Studentyi getStud(long id) {
//        Transaction t = this.session.beginTransaction();
          org.hibernate.Query query =   this.session.createQuery("from Studentyi u where u.nomerZachetki=:id"); 
          query.setParameter("id",id);
          return (Studentyi) query.list().get(0);
          
    }

    @Override
    public void update(Studentyi stud) {
        
    }
}
