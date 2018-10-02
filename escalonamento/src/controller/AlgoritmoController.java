package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.AlgoritmoDao;
import model.Algoritmo;
import model.Pessoa;

/**
 * Servlet implementation class AlgoritmoController
 */
@WebServlet("/algoritmo")
public class AlgoritmoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlgoritmoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		setAccessControlHeaders(response);
		// TODO Auto-generated method stub

				String id = request.getParameter("id");
				
				Algoritmo algoritmo = new Algoritmo();

				algoritmo.setId(Integer.parseInt(id));
				
				AlgoritmoDao ad = new AlgoritmoDao();
				algoritmo = ad.carregar(algoritmo);

				JSONObject obj = new JSONObject();
				obj.put("id", algoritmo.getId());		
				obj.put("nome", algoritmo.getNome());
				obj.put("img_r", algoritmo.getImg_r());
				obj.put("velocidade", algoritmo.getVelocidade());
				obj.put("img_l", algoritmo.getImg_l());
				obj.put("img_background", algoritmo.getImg_background());
					
				JSONObject obj2 = new JSONObject();
				obj2.put("id", algoritmo.getCpu().getId());
				obj2.put("status", algoritmo.getCpu().getStatus());
				obj2.put("status_i", algoritmo.getCpu().getStatus_i());
				obj2.put("status_p", algoritmo.getCpu().getStatus_p());
				obj2.put("status_f", algoritmo.getCpu().getStatus_f());
				obj2.put("img", algoritmo.getCpu().getImg());
				obj2.put("width", algoritmo.getCpu().getWidth());
				obj2.put("height", algoritmo.getCpu().getHeight());
				
				JSONArray jsonArrayItems = new JSONArray();
						
				for(int i=0; i < algoritmo.getPessoa().size(); i++) {
					JSONObject obj3 = new JSONObject();
					Pessoa p = new Pessoa();
					p = algoritmo.getPessoa().get(i);
					obj3.put("id", p.getId());
					obj3.put("nome", p.getNome());
					obj3.put("img", p.getImg());
					obj3.put("ui_index", p.getUiIndex());
					jsonArrayItems.put(obj3);
		        }
							
				obj.put("pessoa", jsonArrayItems);
				obj.put("cpu", obj2);
				response.getWriter().print(obj);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	private void setAccessControlHeaders(HttpServletResponse resp) {
	      resp.setHeader("Access-Control-Allow-Origin", "*");
	      resp.setHeader("Access-Control-Allow-Methods", "GET");
	  }

}
