package model;

public class Pessoa {
	
	private int id;
	private String nome;
	private int width;
	private int height;
	private String img;
	private int uiIndex;
	private int passo;
	
	private Algoritmo algoritmo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Algoritmo getAlgoritmo() {
		return algoritmo;
	}
	public void setAlgoritmo(Algoritmo algoritmo) {
		this.algoritmo = algoritmo;
	}
	public int getUiIndex() {
		return uiIndex;
	}
	public void setUiIndex(int uiIndex) {
		this.uiIndex = uiIndex;
	}
	public int getPasso() {
		return passo;
	}
	public void setPasso(int passo) {
		this.passo = passo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
