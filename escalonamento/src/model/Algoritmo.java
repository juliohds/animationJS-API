package model;

import java.util.ArrayList;

public class Algoritmo {
	
	private int id;
	private String nome;
	private Cpu cpu;
	private String img_r;
	private String img_l;
	private String img_background;
	private int velocidade;
	
	private ArrayList<Pessoa> pessoa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cpu getCpu() {
		return cpu;
	}
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	public ArrayList<Pessoa> getPessoa() {
		return pessoa;
	}
	public void setPessoa(ArrayList<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
	public String getImg_background() {
		return img_background;
	}
	public void setImg_background(String img_background) {
		this.img_background = img_background;
	}
	public String getImg_l() {
		return img_l;
	}
	public void setImg_l(String img_l) {
		this.img_l = img_l;
	}
	public String getImg_r() {
		return img_r;
	}
	public void setImg_r(String img_r) {
		this.img_r = img_r;
	}
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
	
}
