/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacecadetsone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author administrator
 */
public class SpaceCadetsOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        InputStreamReader input = new InputStreamReader(System.in); 
        BufferedReader reader = new BufferedReader(input); 
        
        System.out.println("Input ID: ");
        String id = reader.readLine();
        
        String parturl = "https://www.ecs.soton.ac.uk/people/";
        parturl = parturl.concat(id);
        URL url = new URL(parturl);
        Scanner scan = new Scanner(url.openStream());
        StringBuffer routput = new StringBuffer();
        while(scan.hasNext()) {
            routput.append(scan.next());
        } 

        int start = routput.indexOf("<title>");
        int end = routput.indexOf("|E");
        String name = routput.substring(start, end);
        name = name.substring(7);
        
        if ("People".equals(name)){
            System.out.println("Invalid ID");
        } else {
            System.out.println(name);
        }  
       
    }
    
}
