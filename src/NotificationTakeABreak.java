import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationTakeABreak {
	
	public static void main(String[] args) throws AWTException {
		
		TimerTask task = new TimerTask() {

			@Override
			public void run() 
			{
				 
				if (SystemTray.isSupported()) 
				{
			        NotificationTakeABreak notify = new NotificationTakeABreak();
			        try {
						notify.displayNotificationTray();
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
				else
				{
					System.err.println("System is not supported!");
			    }
				
			}			
		};
		
		Timer timer = new Timer();
	    long delay = 0;
	    long intevalPeriod = 1 * 3600000;
	    
	    // schedules the task to be run in an interval 

	    timer.scheduleAtFixedRate(task, delay, intevalPeriod);
       
    }
	
	public void displayNotificationTray() throws AWTException {
        
        SystemTray tray 	= SystemTray.getSystemTray();
        Image image 		= Toolkit.getDefaultToolkit().createImage("icon.png");  
        TrayIcon trayIcon	= new TrayIcon(image, "Notification Demo");
        
        trayIcon.setImageAutoSize(true);
        
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);
        
        String subject = "Take a break...";
        String message = "Take a deep breath...\nHave some water...\nDaily water need for your body is approx 3.5L";
        
        trayIcon.displayMessage(subject, message, MessageType.INFO);
    }
}
