package org.DemoProject.DemoProject.core.models;

import java.io.IOException;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;



@Model(adaptables = { SlingHttpServletRequest.class, SlingHttpServletResponse.class })
public class SelectModel {


	     HashMap<Integer,String> itemForSelect;
		
		@Self
		SlingHttpServletRequest request;
		@Inject
		SlingHttpServletResponse response;

		@PostConstruct
		protected void init() throws ServletException, IOException {
			System.out.println("ENTRATA METODO: init");
			
			HashMap<Integer,String> knowList=new HashMap<Integer,String>();
			knowList.put(1, "amico o conoscente");
			knowList.put(2, "link su un altro sito");
			knowList.put(3, "ricerca su un motore di ricerca");
			knowList.put(4, "Social");
			setItemForSelect(knowList);
			
			
		/*	
			<sly data-sly-list.item="${model.itemForSelect.keySet}">
			${model.itemForSelect[item]}
			*/
			
/*          </sly>
			String name = request.getParameter("name").trim().toLowerCase();
			String mail = request.getParameter("mail").trim().toLowerCase();
			String password = request.getParameter("password").trim().toLowerCase();

			if (name.equals("ivan") && mail.equals("ivan.trabucco@yahoo.it") && password.equals("123")) {
				System.out.println("validation success! values nome: " + name + " mail: " + mail + " password: " + password);

				setNameForHome(name);
				
			} else {
				System.out.println("validation error!");

				response.sendRedirect("/content/demoproject/en/errorLogin.html"); 
		}
*/
		}

		public HashMap<Integer, String> getItemForSelect() {
			return itemForSelect;
		}

		public void setItemForSelect(HashMap<Integer, String> itemForSelect) {
			this.itemForSelect = itemForSelect;
		}

		// getter & setter

		

	
}
