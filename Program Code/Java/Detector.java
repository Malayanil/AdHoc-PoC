import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import javax.swing.*;  
import javax.swing.Timer;

public class Detector 
{   
    long lastTickTime, comp=1, millis;
    Timer timer;
	Duration duration;

    Detector()  
        {  
        JFrame f= new JFrame("Panel Example");    
        JPanel panel=new JPanel();
		JFrame ftwo= new JFrame("Alarm Panel");    
        JPanel paneltwo=new JPanel();  

        panel.setBounds(80,80,200,200);    
        panel.setBackground(Color.gray);  

        JButton b1=new JButton("Door");     
        b1.setBounds(50,100,80,30);    
        b1.setBackground(Color.yellow);   

        TextField t1=new TextField("5");  
        t1.setBounds(50,100, 200,30);  
        t1.setEditable(false);

        JButton b2=new JButton("Fingerprint Scanner");   
        b2.setBounds(400,400,10,10);    
        b2.setBackground(Color.blue);

        timer = new Timer(100, new ActionListener() 
		{
                @Override
                public void actionPerformed(ActionEvent e) 
				{  if(millis>=0)
					{
                	    long runningTime = System.currentTimeMillis() - lastTickTime;
                	    duration = Duration.ofMillis(5000 - runningTime);
                	    millis = duration.toMillis();
                	    t1.setText(Long.toString(millis/1000)); 
						comp=millis;
						
					}
					
					while(comp<0)
					{

              			paneltwo.setBounds(80,80,200,200);    
                        paneltwo.setBackground(Color.gray);

					    ftwo.add(paneltwo);  
        			    ftwo.setSize(200,200);    
		        		ftwo.setLayout(null);    
        				ftwo.setVisible(true);
						comp=999; 
						
					    TextField t1=new TextField("Alarm !");  
        				t1.setBounds(50,100, 10,10);  
        				t1.setEditable(false);
						paneltwo.add(t1);
					}

                }
        });

        b1.addActionListener(new ActionListener()
        {   
            
            public void actionPerformed(ActionEvent e)
          {
            lastTickTime = System.currentTimeMillis();
            timer.start();
			 
          }
        });

        b2.addActionListener(new ActionListener() 
		{
                @Override
                public void actionPerformed(ActionEvent e) 
				{
                    timer.stop();
					ftwo.setVisible(false); 				   
            
                }
        });

        panel.add(b1); 
		panel.add(b2);  
		panel.add(t1);
        f.add(panel);  
        f.setSize(400,400);    
        f.setLayout(null);    
        f.setVisible(true);    
        }

        public static void main(String args[])  
        {  
         new Detector();
        }  
    } 
