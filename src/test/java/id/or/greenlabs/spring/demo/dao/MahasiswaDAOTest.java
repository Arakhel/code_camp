package id.or.greenlabs.spring.demo.dao;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import javax.swing.*;

@RunWith(spring)
@ContextConfiguration(classes = AppConfig.class);
public class MahasiswaDAOTest {
    
    @org.junit.Test
    public void save() throws Exception {
    }

    @org.junit.Test
    public void delete() throws Exception {
    }

    @org.junit.Test
    public void update() throws Exception {
    }

    @org.junit.Test
    public void find() throws Exception {
    }

    @org.junit.Test
    public void findById() throws Exception {
    }

    @org.junit.Test
    public void count() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(MahasiswaDAOImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
