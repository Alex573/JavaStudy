package hibernatet;

import hibernatet.models.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class MainCriteria {


    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
        Session session = sessionFactory.openSession();

        List<Product> products = null;
        try {
            session.beginTransaction();
//            Criteria criteria = session.createCriteria(Product.class);
//            //criteria.add(Restrictions.eq("title", "Product3"));
////            criteria.add(Restrictions.between(
////                    "price", BigDecimal.valueOf(4999),BigDecimal.valueOf(20000)));
//            criteria.addOrder(Order.desc("price"));
            Criteria criteria = session.createCriteria(Product.class, "product");
            criteria.createCriteria("product.productCategory","productCategory");
            //criteria.add(Restrictions.eq("ProductCategory.title", "cat"));
           // criteria.add(Restrictions.eq("product.title", "Product3"));
            // criteria.setProjection(Projections.distinct(Projections.property("product")));
            // criteria.setMaxResults(1);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);


                products = criteria.list();

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
