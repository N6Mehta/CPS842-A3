/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test.hello;

import javax.swing.JOptionPane;
import java.util.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ni2
 */
public class NewJApplet extends javax.swing.JApplet {

   String query;
   String searchTerm;
   String path;
  // public static List<String> googleLinks;
   List<String> finalLinks;
   ArrayList<Integer> awards = new ArrayList<Integer>();
          /**
     * Initializes the applet NewJApplet
     */
    @Override
    public void init() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                            
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Meta Search!");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButton1)))))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           searchTerm = jTextField1.getText();
       //    jTextArea1.setText(" Google Result:" + "\n");
             String Glinks;
             String Blinks;
       try {
           
          Glinks = getsearchGoogle(searchTerm);
          Blinks = getsearchBing(searchTerm);
          finalLinks = Bingparse(Blinks);
          finalLinks.addAll(Googleparse(Glinks));
         // System.out.println(finalLinks.size());
         
         award(finalLinks,awards);
         merge(finalLinks,awards);
           
       } catch (Exception ex) {
           ex.printStackTrace();
           //jLabel2.setText("nope");
       }
       
      
      //sortGivenArray();
      
       
           for(int i = 0; i<finalLinks.size(); i++) {
               String temp = jTextArea1.getText();
               jTextArea1.setText(temp + "\n" + finalLinks.get(i) + "\n");
           }
           
           //String temp1 = jTextArea1.getText();
           //jTextArea1.setText(temp1 + "\n" + "Bing Results:" + "\n");
           
         //  for(int i = 0; i<bingLinks.size(); i++) {
          //     String temp = jTextArea1.getText();
           //    jTextArea1.setText(temp + "\n" + bingLinks.get(i) + "\n");
          // }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void award(List<String> url, List<Integer> award)
    {
	int N = 10;
        boolean batman = false;
	int size = url.size();	
        //System.out.println(size);
	for(int i=0; i <= size; i++)
	{
           
             if(i==9){
                 award.add(N-i);
                 //System.out.println(N-i);
                 if(batman = true) break ;
                 i=0;
                 batman = true;
              }
              else 
                   award.add(N-i);  
               //System.out.println(N-i);
             
	}
	
    }    
    
    
    public void merge(List<String> url,List<Integer> awards)
    {
	String holder;
	for(int i=0;i<url.size() ;i++)
	{
		holder = url.get(i);
                System.out.println(holder);
		
		for(int j=i; j < url.size(); j++)
		{
                    System.out.println(j);
			if(holder == url.get(j))//if they match
			{
				int e = awards.get(i) + awards.get(j);//add them together
				awards.set(i,e);
				awards.remove(j);
				url.remove(j);
			}
		}
	}
    }
    
    
    public void sortGivenArray(){
         
        int smallInt = 0;
        int smallIntIndex = 0;      
         
        for(int i=1;i<awards.size();i++){
             
            smallInt = awards.get(i-1);
            smallIntIndex = i-1;
             
            for(int j=i;j<awards.size();j++){
                if(awards.get(j)<smallInt){
                    smallInt = awards.get(j);
                    smallIntIndex = j;
                }
            }
         
            //Swap the smallest element with the first element of unsorted subarray
            swap(i-1, smallIntIndex);
	    swap(finalLinks.indexOf(i-1), smallIntIndex);             
        }
    }
     
    void swap(int p, int q)
    {
        int temp;
        temp = p;
        p = q;
        q = temp;
    }
    
    public String getsearchGoogle(String searchTerm){
       path = "https://www.google.com/search?q=" + searchTerm + "&num=10";
        final InputStream stream; 
        String steam;
        try {
        final String agent = "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)";
        URL url = new URL(path);
        final URLConnection connection = url.openConnection();
        
        connection.setRequestProperty("User-Agent", agent);
        stream = connection.getInputStream();
        
        steam = returnString(stream);
        return steam;
        
        } catch (Exception ex) {
           ex.printStackTrace();
       }
          return "nope";
    }
    
    public String getsearchBing(String searchTerm){
        path = "http://www.bing.com/search?q=" + searchTerm + "&num=10";
        
        final InputStream stream;
        String steam;
        
        try {
        URL url = new URL(path);
        final URLConnection connection = url.openConnection();
        
        stream = connection.getInputStream();
        
        steam = returnString(stream);
        return steam;
        
        } catch (Exception ex) {
           ex.printStackTrace();
       }
          return "nope";
    }
    
    
    
    public String returnString(InputStream in) {
        StringBuilder builder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            /** finally block to close the {@link BufferedReader} */
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return builder.toString();
    }
    
    public List<String> Bingparse(final String html) {
        List<String> fin = new ArrayList<String>();
        
        try{
         
        String part1 = "<h2><a href=";
        String part2 =">";
        Pattern pat = Pattern.compile(Pattern.quote(part1) + "(.*?)" + Pattern.quote(part2));
        Matcher mat = pat.matcher(html);
        
        while(mat.find()) {
            String name = mat.group(0).trim();
            name = name.substring(13);
            name = name.substring(0, name.indexOf("\" h="));

            //System.out.println(name);
            fin.add(name);
        }
        return fin;
        } catch (Exception ex) {
           ex.printStackTrace();
       }
       return fin;
    }
    
    public List<String> Googleparse(final String html) {
       
        List<String> fin = new ArrayList<String>();
        try{
        String part1 = "<h3 class=\"r\"><a href=\"/url?q=";
        String part2 = "\">";
        // fin.add("test");
        Pattern pat = Pattern.compile(Pattern.quote(part1) + "(.*?)" + Pattern.quote(part2));
        Matcher mat = pat.matcher(html);
        
        while(mat.find()) {
            String name = mat.group(0).trim();
            
            name = name.substring(name.indexOf("/url?q=") + 7);
            name = name.substring(0, name.indexOf("&amp;"));
            
            fin.add(name);
           // fin.add("test");
        }
        return fin;
        } catch (Exception ex) {
           ex.printStackTrace();
       }
       return fin;
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
