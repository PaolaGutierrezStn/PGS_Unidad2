package dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.StoreProcess;


public class StoreProcessDOM {
	private String pathFile = "E:\\4C-GSI1342\\Aplicaciones 2 - Tacho\\workspace\\PGGS_Unidad2\\src\\data\\storesprocess.xml";								
	public void add(StoreProcess data) {
		try {
			
				Document document = DOMHelper.getDocument(pathFile);
				Element storesprocess = document.getDocumentElement();
				
				//CREATE  TAG
				
				Element storeprocess = document.createElement("storeprocess");
				
				//CREAR pid TAGG
				
				Element pid = document.createElement("pid");
				pid.appendChild(document.createTextNode(data.getPid()));
				storeprocess.appendChild(pid);
				
				// create state tag
				
				Element state = document.createElement("state");
				state.appendChild(document.createTextNode(data.getState()));
				storeprocess.appendChild(state);
				
					// create type tag
				
				Element type = document.createElement("type");
				type.appendChild(document.createTextNode(data.getType()));
				storeprocess.appendChild(type);
				
				//create version tag
				
				Element version = document.createElement("version");
				version.appendChild(document.createTextNode(String.valueOf(data.getVersion())));
				storeprocess.appendChild(version);
				
				//create du tag 
				
				Element du = document.createElement("du");
				du.appendChild(document.createTextNode(data.getDu()));
				storeprocess.appendChild(du);
				
				storesprocess.appendChild(storeprocess);
				
				// Write to file
				DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e){
			
				System.out.println(e.getMessage());
			
		}
	}
	
	public void delete (String pid ) {
		
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("storeprocess");
			for (int i =0; i< nodelist.getLength(); i++) {
				
				Element storeprocess = (Element)nodelist.item(i);
				if (storeprocess.getElementsByTagName("pid").item(0).getTextContent().equals(pid)) {
					storeprocess.getParentNode().removeChild(storeprocess);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update (StoreProcess data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("storeprocess");
			for (int i =0; i< nodelist.getLength(); i++) {
				Element storeprocess = (Element)nodelist.item(i);
				if (storeprocess.getElementsByTagName("pid").item(0).getTextContent().equals(data.getPid())) {
					storeprocess.getElementsByTagName("state").item(0).setTextContent(data.getState());	
					storeprocess.getElementsByTagName("type").item(0).setTextContent(data.getType());
					storeprocess.getElementsByTagName("version").item(0).setTextContent(String.valueOf(data.getVersion()));
					storeprocess.getElementsByTagName("du").item(0).setTextContent(data.getDu());
					
					
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public StoreProcess findById(String pid) {
		StoreProcess storeprocess = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("storeprocess");
			for(int i=0; i<nodelist.getLength(); i++) {
				Element s = (Element)nodelist.item(i);
				if(s.getElementsByTagName("pid").item(0).getTextContent().equals(pid)) {
					storeprocess = new StoreProcess();
					storeprocess.setPid(pid);
					storeprocess.setState(s.getElementsByTagName("state").item(0).getTextContent());
					storeprocess.setType(s.getElementsByTagName("type").item(0).getTextContent());	
					storeprocess.setVersion(Integer.parseInt(s.getElementsByTagName("version").item(0).getTextContent()));
					storeprocess.setDu(s.getElementsByTagName("du").item(0).getTextContent());
				}
				
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return storeprocess;
	}
	
	public  List<StoreProcess> getStoresProcess(){
		
		List<StoreProcess> storesprocess = new ArrayList<StoreProcess>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("storeprocess");
		for (int i =0; i<nodelist.getLength(); i++) {
			
			Element s = (Element)nodelist.item(i);
			StoreProcess storeprocess = new StoreProcess();
			storeprocess.setPid(s.getElementsByTagName("pid").item(0).getTextContent());
			storeprocess.setState(s.getElementsByTagName("state").item(0).getTextContent());
			storeprocess.setType(s.getElementsByTagName("type").item(0).getTextContent());
			storeprocess.setVersion(Integer.parseInt(s.getElementsByTagName("version").item(0).getTextContent()));			
			storeprocess.setDu(s.getElementsByTagName("du").item(0).getTextContent());
			
			storesprocess.add(storeprocess);
			
		}
		return storesprocess;
	}
}



