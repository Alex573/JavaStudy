package hibernatet;

import hibernatet.models.Product;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class MainSQL {


    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
        Session session = sessionFactory.openSession();

        List<Product> products = null;
        try {
            session.beginTransaction();
            SQLQuery sqlQueryUpdate = session.createSQLQuery("UPDATE product SET title = ? WHERE id = ?");
            sqlQueryUpdate.setParameter(0,"dghdfghj");
            sqlQueryUpdate.setParameter(1,"2");
            sqlQueryUpdate.executeUpdate();

            SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM product");
            sqlQuery.addEntity(Product.class);
            products = sqlQuery.list();



            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();

        }finally {
            session.close();
            sessionFactory.close();
        }

        products.forEach(System.out::println);



    }
}
