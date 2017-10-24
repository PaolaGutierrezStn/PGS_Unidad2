package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dom.StoreProcessDOM;
import model.StoreProcess;



/**
 * Servlet implementation class StoreProcessController
 */
@WebServlet("/StoreProcessController")
public class StoreProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreProcess storeprocess;
	private List<StoreProcess> storesprocess;
	private StoreProcessDOM storeprocessDOM;
	private List<String> ids = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreProcessController() {
        super();
        storeprocess = new StoreProcess();
        storesprocess = new ArrayList<StoreProcess>();
        storeprocessDOM = new StoreProcessDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if (request.getParameter("btn_save")!= null) {
    				
    				storeprocess.setState(request.getParameter("state"));
    				storeprocess.setType(request.getParameter("type"));
    				storeprocess.setDu(request.getParameter("du"));
    				
    				try {
    					
    					storeprocess.setVersion(Integer.parseInt(request.getParameter("version")));
    				}catch(NumberFormatException e) {
    					storeprocess.setVersion(25);
    					
    					
    				}    				
    	            
    				
    				if(storeprocess.getPid()=="") {
    					int id = 1;
    					String newId= "sto"+String.format("%05d", 1);
    					storeprocess.setPid(newId);;
    					
    					if (storesprocess.size()>0) {
    						ids.clear();
    						for (StoreProcess p: storesprocess) {
    							ids.add(p.getPid());
    						}
    						for (int i=0; i<= ids.size(); i++){
    							newId= "sto"+ String.format("%05d", i+1);
    							
    							if (! ids.contains(newId)) {
    								storeprocess.setPid(newId);
    							break;
    							}
    						}
    					}
    					storeprocessDOM.add(storeprocess);
    				}else {
    					storeprocessDOM.update(storeprocess);
    				}
    				storesprocess = storeprocessDOM.getStoresProcess();
    				request.setAttribute("storesprocess", storesprocess);
    				request.getRequestDispatcher("storesprocess_list.jsp").forward(request, response);
    				
    			}else if (request.getParameter("btn_new")!=null) {
    				storeprocess = new StoreProcess();
    				request.getRequestDispatcher("storesprocess_form.jsp").forward(request, response);
    			
    			}else if(request.getParameter("btn_edit")!=null) {	
    				try {
    					String pid = request.getParameter("pid");
    					storeprocess = storeprocessDOM.findById(pid);
    					
    				}catch (Exception e) {
    					
    					storeprocess = new StoreProcess();
    				}
    				request.setAttribute("storeprocess", storeprocess);
    				
    				request.getRequestDispatcher("storesprocess_form.jsp").forward(request, response);
    				
    			}else if(request.getParameter("btn_delete")!=null) {
    			
    				
    				try {
    				String pid = request.getParameter("pid");
    				storeprocessDOM.delete(pid);
    				storesprocess = storeprocessDOM.getStoresProcess();
    				
    				}catch(Exception e) {
    					e.printStackTrace();
    					
    					
    				}
    				request.setAttribute("storesprocess", storesprocess);
    				request.getRequestDispatcher("storesprocess_list.jsp").forward(request, response);
    			}else {
    				storesprocess = storeprocessDOM.getStoresProcess();
    				request.setAttribute("storesprocess", storesprocess);
    				request.getRequestDispatcher("storesprocess_list.jsp").forward(request, response);
    			}
    		}

    		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
