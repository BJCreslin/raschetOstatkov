package Controlers;

import models.Entities.Item;
import models.Entities.MakeItemTable;
import models.Entities.MakersTable;
import models.Entities.ProductGroup;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;


public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private static Logger logger = LoggerFactory.logger(HibernateSessionFactoryUtil.class);

    private HibernateSessionFactoryUtil() {
    }


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {

            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Item.class);
                configuration.addAnnotatedClass(MakeItemTable.class);
                configuration.addAnnotatedClass(MakersTable.class);
                configuration.addAnnotatedClass(ProductGroup.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties());

                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception ex) {
                logger.error("Ошибка создания sessionFactory", ex);
            }
        }
        return sessionFactory;
    }
}
