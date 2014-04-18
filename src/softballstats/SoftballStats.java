/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softballstats;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
    private static final int GAME=1;
    private static final int AB=2;
    private static final int R=3;
    private static final int SINGLE=4;
    private static final int DOUBLE=5;
    private static final int TRIPLE=6;
    private static final int HR=7;
    private static final int SAC=8;
    private static final int BB=9;
    private static final int RBI=10;
    private static final int SO=11;
    private static final int FO=12;
    private static final int GIDP=13;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        String directoryName = args[0];
        Map<String, Player> players = new HashMap<String, Player>();
        
        File directory = new File(directoryName);
        File[] listOfFiles = directory.listFiles();
        
        File output = new File(directoryName+"\\total_stats.txt");
        PrintWriter writer = new PrintWriter(output);
        
        try {
            
            Player totals = new Player("TOTALS");
            for (File file : listOfFiles) {
                BufferedReader reader = new BufferedReader(new FileReader(file));

                String line = "";
                Boolean header=true;
                

                while((line = reader.readLine()) != null){
                    if(header){
                        if(line.equalsIgnoreCase("stats")){
                            header=false; 
                            continue;
                        }
                        else
                            break;
                    } // skips the header line

                    // splits the file on commas and remove quotes
                    String[] stats = line.split(Player.DELIM); 

                    Player player=null;
                    if(players.containsKey(stats[NAME])){
                        player=players.get(stats[NAME]);
                        player.setAbs(player.getAbs()+Integer.parseInt(stats[AB]));
                        player.setGames(player.getGames()+Integer.parseInt(stats[GAME]));
                        player.setRuns(player.getRuns()+Integer.parseInt(stats[R]));
                        player.setSingles(player.getSingles()+Integer.parseInt(stats[SINGLE]));
                        player.setDoubles(player.getDoubles()+Integer.parseInt(stats[DOUBLE]));
                        player.setTriples(player.getTriples()+Integer.parseInt(stats[TRIPLE]));
                        player.setHomeruns(player.getHomeruns()+Integer.parseInt(stats[HR]));
                        player.setSacs(player.getSacs()+Integer.parseInt(stats[SAC]));
                        player.setWalks(player.getWalks()+Integer.parseInt(stats[BB]));
                        player.setRbi(player.getRbi()+Integer.parseInt(stats[RBI]));
                        player.setSos(player.getRbi()+Integer.parseInt(stats[SO]));  
                        player.setFos(player.getRbi()+Integer.parseInt(stats[FO]));  
                        player.setGidp(player.getRbi()+Integer.parseInt(stats[GIDP]));  
                    }
                    else{
                        player = new Player(stats[NAME], Double.parseDouble(stats[GAME]),
                                Double.parseDouble(stats[AB]),
                                Double.parseDouble(stats[R]),Double.parseDouble(stats[SINGLE]),
                                Double.parseDouble(stats[DOUBLE]),Double.parseDouble(stats[TRIPLE]),
                                Double.parseDouble(stats[HR]),Double.parseDouble(stats[SAC]),
                                Double.parseDouble(stats[BB]), Double.parseDouble(stats[RBI]),
                                Double.parseDouble(stats[SO]), Double.parseDouble(stats[FO]),
                                Double.parseDouble(stats[GIDP]));

                        players.put(player.getName(), player);                  
                    }

                    totals.setAbs(totals.getAbs()+Integer.parseInt(stats[AB]));
                    totals.setRuns(totals.getRuns()+Integer.parseInt(stats[R]));
                    totals.setSingles(totals.getSingles()+Integer.parseInt(stats[SINGLE]));
                    totals.setDoubles(totals.getDoubles()+Integer.parseInt(stats[DOUBLE]));
                    totals.setTriples(totals.getTriples()+Integer.parseInt(stats[TRIPLE]));
                    totals.setHomeruns(totals.getHomeruns()+Integer.parseInt(stats[HR]));
                    totals.setSacs(totals.getSacs()+Integer.parseInt(stats[SAC]));
                    totals.setWalks(totals.getWalks()+Integer.parseInt(stats[BB]));
                    totals.setRbi(totals.getRbi()+Integer.parseInt(stats[RBI]));
                }     
            }
            writer.println("NAME G AB R H 1B 2B 3B HR RBI BB SF SO FO GIDP AVG OBP SLG OPS");
            for(Map.Entry<String, Player> player : players.entrySet()){
                    writer.println(player.getValue());
            }
            writer.println(totals);
            writer.close();
            
        } catch (IOException ex) {
            Logger.getLogger(SoftballStats.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
}
