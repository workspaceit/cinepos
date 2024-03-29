package dao;

import entity.Genre;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mi on 1/12/17.
 */
@Repository
public class GenreDao extends BaseDao {
    public void insert(Genre genre){
        Session session = null;

        try {
            session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.save(genre);
            session.getTransaction().commit();
        }catch (HibernateException hEx){
            // Insert to database exception log
            hEx.printStackTrace();
        }finally {
            if(session!=null)session.close();
        }
    }
    public void delete(Genre genre){
        Session session = null;

        try {
            session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.delete(genre);
            session.getTransaction().commit();
        }catch (HibernateException hEx){
            // Insert to database exception log
            hEx.printStackTrace();
        }finally {
            if(session!=null)session.close();
        }
    }
    public void update(Genre genre){
        Session session = null;

        try {
            session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.update(genre);
            session.getTransaction().commit();
        }catch (HibernateException hEx){
            // Insert to database exception log
            hEx.printStackTrace();
        }finally {
            if(session!=null)session.close();
        }
    }
    public Genre getById(int id){
        Session session = null;

        try{
            session = this.sessionFactory.openSession();
            return (Genre)session.createQuery("FROM Genre genre  where genre.id = :id").setParameter("id", id).uniqueResult();
        }catch (HibernateException hEx){
            // Insert to database exception log
            hEx.printStackTrace();
        }finally{
            if(session!=null)session.close();
        }
        return null;
    }
    public Genre getByName(String genreName){
        Session session = null;

        try{
            session = this.sessionFactory.openSession();
            return (Genre)session.createQuery("FROM Genre genre  where genre.name = :name")
                    .setParameter("name", genreName)
                    .uniqueResult();
        }catch (HibernateException hEx){
            // Insert to database exception log
            hEx.printStackTrace();
        }finally{
            if(session!=null)session.close();
        }
        return null;
    }
    public boolean isNameUsedByOther(int id,String genreName){
        Session session = null;
        Genre genre = null;
        try{
            session = this.sessionFactory.openSession();
            genre = (Genre)session.createQuery("FROM Genre genre  where genre.name = :name and genre.id != :id")
                    .setParameter("id", id)
                    .setParameter("name", genreName)
                    .setMaxResults(1)
                    .uniqueResult();
            return (genre==null)?false:true;
        }catch (HibernateException hEx){
            // Insert to database exception log
            hEx.printStackTrace();
        }finally{
            if(session!=null)session.close();
        }
        return (genre==null)?false:true;
    }
    public List<Genre> getAll(){
        Session session = this.sessionFactory.openSession();
        try{
            session = this.sessionFactory.openSession();
            return session.createQuery("FROM Genre order by id desc ")
                    .list();
        }catch (HibernateException hEx){
            // Insert to database exception log
            hEx.printStackTrace();
        }finally{
            if(session!=null)session.close();
        }
        return new ArrayList<>();

    }
    public List<Genre> getAllAlphabetically(){
        Session session = this.sessionFactory.openSession();
        try{
            session = this.sessionFactory.openSession();
            return session.createQuery("FROM Genre order by name asc ")
                    .list();
        }catch (HibernateException hEx){
            // Insert to database exception log
            hEx.printStackTrace();
        }finally{
            if(session!=null)session.close();
        }
        return new ArrayList<>();

    }
}
