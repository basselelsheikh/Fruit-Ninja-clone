/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlhandling;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author TheANARXIST
 */
public class XMLHandler {

    private static XMLHandler instance = null;
    private final File xmlFile;
    private final Marshaller marshaller;
    private final JAXBContext context;
    private final Unmarshaller Unmarshaller;
    private Players players;

    

    public static XMLHandler getInstance() throws JAXBException {
        if (instance == null) {
            instance = new XMLHandler();
        }
        return instance;
    }

    public XMLHandler() throws JAXBException {
        context = JAXBContext.newInstance(Players.class);
        marshaller = context.createMarshaller();
        Unmarshaller = context.createUnmarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        xmlFile = new File("players.xml");
    }
    
    public void marshall(Players players) throws JAXBException {
        marshaller.marshal(players, xmlFile);
    }
    public Players unmarshall() throws JAXBException {
        players = (Players)Unmarshaller.unmarshal(xmlFile);
        return players;
    }
}
