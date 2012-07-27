/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.swing.JFrame;
import sample.Executor;

/**
 *
 * @author root
 */
public class AppListener implements ServletContextListener  {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        // this is a creat time to start the Executor ...
        
        /**
         * use these parameters from the App-Context
         */
        String[] paraNames = { "zkServer", "zNode", "filename", "program" };

        /**
         * init the other parameters from constants ...
         */
        
//        String[] para  = { "192.168.3.149", "/zooview/cfg", "log/autorun.log", 
//                           "ant", "-buildfile", "autoruntool.xml", "status", "-Dcmd=status" };
        
        String args[] = new String[ paraNames.length ];
        for( int i = 0; i < paraNames.length ; i++ ) {
            args[i] = sce.getServletContext().getInitParameter( paraNames[i] );
        }  
        
//        for( int i = paraNames.length; i < para.length; i++ ) {
//            args[i] = para[i];
//        }  
                
        
        globalArgs = args;
        javax.swing.JOptionPane.showMessageDialog(new JFrame("Info"), "ZooView is open now ... " );
        Executor.main(args);
        
    }

    public static String[] globalArgs = null;
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Executor.stop();
    }
    
}
