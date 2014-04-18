/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softballstats;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jb834r
 */
public class SoftballStats {

    private static final int NAME=0;
    private static final int AB=1;
    private static final int R=2;
    private static final int SINGLE=3;
    private static final int DOUBLE=4;
    private static final int TRIPLE=5;
    private static final int HR=6;
    private static final int SAC=7;
    private static final int BB=8;
    private static final int RBI=9;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String filename = args[0];
        Map<String, Player> players = new HashMap<String, Player>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            
            String line = "";
            Boolean header=true;
            while((line = reader.readLine()) != null){
                if(header){header=false; continue;} // skips the header line
                    
                // splits the file on commas and remove quotes
                String[] stats = line.split(Player.DELIM); 
                
                Player player=null;
                if(players.containsKey(stats[NAME])){
                    player=players.get(stats[NAME]);
                    player.setAbs(player.getAbs()+Integer.parseInt(stats[AB]));
                    player.setRuns(player.getRuns()+Integer.parseInt(stats[R]));
                    player.setSingles(player.getSingles()+Integer.parseInt(stats[SINGLE]));
                    player.setDoubles(player.getDoubles()+Integer.parseInt(stats[DOUBLE]));
                    player.setTriples(player.getTriples()+Integer.parseInt(stats[TRIPLE]));
                    player.setHomeruns(player.getHomeruns()+Integer.parseInt(stats[HR]));
                    player.setSacs(player.getSacs()+Integer.parseInt(stats[SAC]));
                    player.setWalks(player.getWalks()+Integer.parseInt(stats[BB]));
                    player.setRbi(player.getRbi()+Integer.parseInt(stats[RBI]));
                }
                else{
                    player = new Player(stats[NAME], Double.parseDouble(stats[AB]),
                            Double.parseDouble(stats[R]),Double.parseDouble(stats[SINGLE]),
                           Double.parseDouble(stats[DOUBLE]),Double.parseDouble(stats[TRIPLE]),
                            Double.parseDouble(stats[HR]),Double.parseDouble(stats[SAC]),
                            Double.parseDouble(stats[BB]), Double.parseDouble(stats[RBI]));
                    
                    players.put(player.getName(), player);                  
                }
            }
            
            for(Map.Entry<String, Player> player : players.entrySet()){         
                System.out.println(player.getValue());
            }
            
        } catch (IOException ex) {
            Logger.getLogger(SoftballStats.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
}
