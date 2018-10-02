package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.CpuDao;
import model.Cpu;

/**
 * Servlet implementation class CpuController
 */
@WebServlet("/cpu")
public class CpuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CpuController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String id = request.getParameter("id");
		
		Cpu cpu = new Cpu();
		cpu.setId(Integer.parseInt(id));
		
		CpuDao cd = new CpuDao();
		cpu = cd.carregar(cpu);
		
		JSONObject obj = new JSONObject();
		obj.put("status", cpu.getStatus());
		obj.put("id", cpu.getId());
		obj.put("img", cpu.getImg());
		obj.put("width", cpu.getWidth());
		obj.put("height", cpu.getHeight());
		response.getWriter().print(obj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String width = request.getParameter("width");
		String height = request.getParameter("height");		
		String status = request.getParameter("status");
		String img = request.getParameter("img");
		
		Cpu cpu = new Cpu();
		cpu.setHeight(Integer.parseInt(height));
		cpu.setWidth(Integer.parseInt(width));
		cpu.setImg(img);
		cpu.setStatus(status);
		
		CpuDao cd = new CpuDao();
		cd.inserir(cpu);
		
		JSONObject obj = new JSONObject();
		obj.put("status", status);
		obj.put("img", img);
		obj.put("width", width);
		obj.put("height", height);
		response.getWriter().print(obj);
		
	}

}
