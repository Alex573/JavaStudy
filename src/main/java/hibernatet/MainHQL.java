package hibernatet;

import hibernatet.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.util.List;

public class MainHQL {


    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
        Session session = sessionFactory.openSession();

        List<Product> products = null;
        try {
            session.beginTransaction();

          //  products =(List<Product>) session.createQuery("from Product").list();
//            products =(List<Product>) session.createQuery(
//                    "From Product as p INNER JOIN FETCH p.productCategory as pc").list();

//            products =(List<Product>) session.createQuery(
//                    "SELECT p From Product as p INNER JOIN FETCH p.productCategory as pc").list();

            Product product = new Product();
            product.setDescription("desProducta2");
            product.setPrice(BigDecimal.valueOf(10000));
            product.setTitle("Product3");

            session.save(product);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();

        }finally {
            session.close();
            sessionFactory.close();
        }

//        products.forEach(System.out::println);



    }
}
