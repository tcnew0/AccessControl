package com.zzb.competence.util.listener;

import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.ProxoolFacade;
import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

/**
 * Created by guanzhenxing on 2014-06-07.
 */
public class ProxoolContextListener implements ServletContextListener{

    /** proxool 初始化context路径 */
    public static final String PROXOOL_LOCATION_PARAM = "proxoolConfigLocation";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        // get context
        ServletContext context = servletContextEvent.getServletContext();

        // 根目录
        String root = context.getRealPath("/");

        // 获取xml路径
        String path = context.getInitParameter(PROXOOL_LOCATION_PARAM);

        try {
            JAXPConfigurator.configure(root+ File.separator+path ,false);
        } catch (ProxoolException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // shut down proxool hook
        ProxoolFacade.shutdown(0);
    }
}
