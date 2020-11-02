/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author laukk
 */
public class StatisticsTest {

Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka k‰ytt‰‰ "stubia"
        stats = new Statistics(readerStub);
    }  
    
    @Test
    public void palautaPelaajaK() {
        Player player = stats.search("Kurri");
        assertEquals(new Player("Kurri", "EDM", 37, 53), player);
    }
    
    @Test
    public void palautaNullKunPelaajaaEiLoydy() {
        Player player = stats.search("Jarkko");
        assertEquals(null, player);
    }
    
    @Test
    public void palautaListaSamanJoukkueenPelaajista() {
        List<Player> players = stats.team("EDM");
        ArrayList<Player> comparison = new ArrayList<>();
        comparison.add(new Player("Semenko", "EDM", 4, 12));
        comparison.add(new Player("Kurri", "EDM", 37, 53));
        comparison.add(new Player("Gretzky", "EDM", 35, 89));
        assertEquals(comparison, players);
    }
    
    
}
