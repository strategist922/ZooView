/**
 * 
 * This is a sample for the usage of the Zookeeper, 
 * to start remote tools.
 * 
 **/
package zkviewercore;

import sample.Executor;

/**
 *
 * @author root
 */
public class ZkViewerCore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // this is a creat time to start the Executor ...
        String[] paraNames = { "zkServer", "zNode", "filename", "program", "program.arg1" };
        String[] para  = { "192.168.3.149", "/zooview/cfg", "log/autorun.log", 
                           "ant", "-buildfile", "autoruntool.xml", "status", "-Dcmd=status" };
        
        args = new String[ para.length ];
        for( int i = 0; i < para.length; i++ ) {
            args[i] = para[i];
        }  
        
        Executor.main(args);
    }
}
