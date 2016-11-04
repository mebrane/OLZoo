package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import model.Pais;
import model.Persona;
import serv.PaisServ;
import serv.PersonaServ;
import weblogic.utils.classfile.Op;
@ManagedBean
@SessionScoped
public class PersonaBean {
	private int pers_id;
	private String pers_nomb;
	private String pers_apel;
	private String pers_dire;
	private Pais pais;
	private Character pers_esta;
	
	private PaisServ oPaisServ = new PaisServ();
	private PersonaServ oPersonaServ = new PersonaServ();
	

	private List<Pais> listaPais;
	private List<Persona> listaPersona;
	
	private int listaPersonaTamano;
	
	private boolean sw_edit;
	
	private int fila_seleccionada;

	public void llenarCombos() throws Exception{
		listaPais = oPaisServ.listar();
	}
	
	public boolean accion_insertar() throws Exception{
		sw_edit=false;
		llenarCombos();
		return sw_edit;
	}
	
	public boolean accion_editar() throws Exception{
		sw_edit=true;
		llenarCombos();
		return sw_edit;
	}
	
	
	public void insertar() throws Exception{
		Persona oPersona=new Persona();
		oPersona.setPers_nomb(pers_nomb);
		oPersona.setPers_apel(pers_apel);
		oPersona.setPers_dire(pers_dire);
		oPersona.setPais(pais);
		oPersona.setPers_esta('A');
		Thread.sleep(4500);
		oPersonaServ.insertar(oPersona);
		limpiar();
	}
	
	public void limpiar(){
		setPers_id(0);
		setPers_nomb(null);
		setPers_apel(null);
		setPers_dire(null);
		setPais(new Pais());
		setPers_esta(null);
	}

	public void seleccionar(ActionEvent e) throws Exception
	{
		String fila=e.getComponent().getAttributes().get("atributo_id").toString();
		System.out.println(fila);
		fila_seleccionada=Integer.parseInt(fila);
	}
	public void modo_editar(ActionEvent e) throws Exception{
		seleccionar(e);
		accion_editar();
		Persona p1 = new Persona();
		p1.setPers_id(fila_seleccionada);
		Persona p2= oPersonaServ.obtener(p1);
		setPers_id(p2.getPers_id());
		setPers_nomb(p2.getPers_nomb());
		setPers_apel(p2.getPers_apel());
		setPers_dire(p2.getPers_dire());
		setPais(p2.getPais());
		setPers_esta(p2.getPers_esta());
		
		
	}
	
	public void actualizar() throws Exception{
		Persona p1=new Persona();
		p1.setPers_id(pers_id);
		p1.setPers_nomb(pers_nomb);
		p1.setPers_apel(pers_apel);
		p1.setPers_dire(pers_dire);
		p1.setPers_esta(pers_esta);
		p1.setPais(pais);
		Thread.sleep(4500);
		oPersonaServ.actualizar(p1);
		buscar();
		limpiar();
	}
	
	public void buscar()throws Exception{
		Persona p1 = new Persona();
		p1.setPers_nomb(pers_nomb);
		listaPersona= oPersonaServ.buscar(p1);
		listaPersonaTamano=listaPersona.size();

	}
	public void eliminar() throws Exception{
		Persona p1 = new Persona();
		p1.setPers_id(fila_seleccionada);
		oPersonaServ.eliminar(p1);
		buscar();
		limpiar();
	}
	public int getPers_id() {
		return pers_id;
	}

	public void setPers_id(int pers_id) {
		this.pers_id = pers_id;
	}

	public String getPers_nomb() {
		return pers_nomb;
	}

	public void setPers_nomb(String pers_nomb) {
		this.pers_nomb = pers_nomb;
	}

	public String getPers_apel() {
		return pers_apel;
	}

	public void setPers_apel(String pers_apel) {
		this.pers_apel = pers_apel;
	}

	public String getPers_dire() {
		return pers_dire;
	}

	public void setPers_dire(String pers_dire) {
		this.pers_dire = pers_dire;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public PaisServ getoPaisServ() {
		return oPaisServ;
	}

	public void setoPaisServ(PaisServ oPaisServ) {
		this.oPaisServ = oPaisServ;
	}

	public PersonaServ getoPersonaServ() {
		return oPersonaServ;
	}

	public void setoPersonaServ(PersonaServ oPersonaServ) {
		this.oPersonaServ = oPersonaServ;
	}

	public List<Pais> getListaPais() {
		return listaPais;
	}

	public void setListaPais(List<Pais> listaPais) {
		this.listaPais = listaPais;
	}

	public List<Persona> getListaPersona() {
		return listaPersona;
	}

	public void setListaPersona(List<Persona> listaPersona) {
		this.listaPersona = listaPersona;
	}

	public int getListaPersonaTamano() {
		return listaPersonaTamano;
	}

	public void setListaPersonaTamano(int listaPersonaTamano) {
		this.listaPersonaTamano = listaPersonaTamano;
	}

	public boolean isSw_edit() {
		return sw_edit;
	}

	public void setSw_edit(boolean sw_edit) {
		this.sw_edit = sw_edit;
	}

	public int getFila_seleccionada() {
		return fila_seleccionada;
	}

	public void setFila_seleccionada(int fila_seleccionada) {
		this.fila_seleccionada = fila_seleccionada;
	}
	
	
	public Character getPers_esta() {
		return pers_esta;
	}

	public void setPers_esta(Character pers_esta) {
		this.pers_esta = pers_esta;
	}

	@PostConstruct
	public void init() {
		pais = new Pais();
	}
	
	
}
