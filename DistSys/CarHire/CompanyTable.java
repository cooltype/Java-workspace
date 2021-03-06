import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Source;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerConfigurationException;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.TransformerFactoryConfigurationError;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
//import javax.xml.parsers.*;

public class CompanyTable {
	
	// This class loads Records of Car hire branches into a data stuct
	private static final String BRANCH_SOURCE = "C:\\Users\\lfrob\\workspace\\DistSys\\bin\\BranchFile.xml";
	private static Map<Integer, String> CompanyTable;
	
	CompanyTable()
	{		
		NodeList Branches;
		Node BranchNode;
		Element Branch;
		String BranchName;
		Integer BranchID;
		CompanyTable = new HashMap<Integer,String>();
		try {
			// load in the xml file and parse
		  DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();	           
		  Document doc = docBuilder.parse(BRANCH_SOURCE);
		  
			//Element root = doc.getDocumentElement();
		  // then pick the bones out of the xml and feed into the hashmap
			Branches = doc.getElementsByTagName("Branch");
			for (int i = 0; i < Branches.getLength(); i++) {
				BranchNode = Branches.item(i);
				Branch = (Element)BranchNode;
				BranchID = Integer.parseInt(Branch.getAttribute("ID"));
				BranchName = Branch.getTextContent();
				CompanyTable.put((Integer)BranchID, BranchName);				
			}
			
			
			//CompanyTable.put(0, "161.73.147.225:5120");
			//CompanyTable.put((Integer)1, "161.73.147.225:5121");
			
			
			
			
			
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	public String IsValid(int ID)
	{		
		String RetVal = CompanyTable.get((Integer)ID);		
		return RetVal;
	}
	
	public int IsValid(String IP)
	{
		int RetVal = (-1);
		for (Entry<Integer, String> entry : CompanyTable.entrySet()) {
	        if (IP.equals(entry.getValue())) {
	        	RetVal = (int)entry.getKey();
	        }
	    }		
		return RetVal;
	}
	
	public Boolean Add(int ID, String IP)
	{
		boolean RetVal = false;
		// first check they're not already in there
		System.out.println("input values" + ID + " & " + IP);
		String CheckID = IsValid((ID));
		System.out.println("Check if ID already exsits: " + CheckID);
		if (CheckID == null)
		{
			int CheckIP = IsValid(IP);
			System.out.println("Check if IP already exsits: " + CheckIP);
			if (CheckIP == (-1))
			{ // its not in there already, put it in
				System.out.println("in Add Section");
				CompanyTable.put((Integer) ID, IP);
				RetVal = true;				
			}// its in there, return error - boolean already set					
		}		
		return RetVal;	
	}

}
