/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.DemoProject.DemoProject.core.models;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

@Model(adaptables = { SlingHttpServletRequest.class, SlingHttpServletResponse.class })

public class LoginModel {

	LoginModel obj = new LoginModel();
	String nameForHome;

	@Self
	SlingHttpServletRequest request;
	SlingHttpServletResponse response;

	@PostConstruct
	protected void init() throws ServletException, IOException {
		System.out.println("ENTRATA METODO: init");
		// from form
		String name = request.getParameter("name").trim().toLowerCase();
		String mail = request.getParameter("mail").trim().toLowerCase();
		String password = request.getParameter("password").trim().toLowerCase();

		if (name.equals("pippo") && mail.equals("eurobet") && password.equals("123")) {
			System.out
					.println("validation success! values nome: " + name + " mail: " + mail + " password: " + password);

			obj.setNameForHome(name);
			request.getRequestDispatcher("home.html").forward(request, response);

		} else {
			System.out.println("validation error!");

			request.getRequestDispatcher("errorPage.html").forward(request, response);
		}

	}

	// getter & setter

	public String getNameForHome() {
		return nameForHome;
	}

	public void setNameForHome(String nameForHome) {
		this.nameForHome = nameForHome;
	}

}