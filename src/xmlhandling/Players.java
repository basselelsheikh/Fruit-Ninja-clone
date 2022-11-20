/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

/**
 *
 * @author beso_
 */
@XmlRootElement(name = "Players")
public class Players {
    
    private ArrayList<Player> players = new ArrayList<>();
    @XmlElement(name = "player")
    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void marshal() throws FileNotFoundException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Players.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);    
            OutputStream os = new FileOutputStream("players.xml");
            jaxbMarshaller.marshal(this, os);
            
        } catch (JAXBException e) {
            JOptionPane.showMessageDialog(null, "Error saving to file");
        }
    }

    public Players unmarshal() throws FileNotFoundException {
                File xmlFile = new File("players.xml");

        try {
            JAXBContext jaxbc = JAXBContext.newInstance(Players.class);
            Unmarshaller unmarsh = jaxbc.createUnmarshaller();
            Players players = (Players) unmarsh.unmarshal(xmlFile);
            return players;            
        } catch (JAXBException e) {
            JOptionPane.showMessageDialog(null, "Error saving to file");
        }
        return null;
        
    }
    
}
