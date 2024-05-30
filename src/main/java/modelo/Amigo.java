package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

public class Amigo{
    //Atributos
    private int idAmigo;
    private String telefone;
    private String nomeAmigo;
    private AmigoDAO dao;
    

    public Amigo(){
        this(0,"","");
    }
    
    public Amigo(int idAmigo, String nome, String telefone) {
        this.idAmigo = idAmigo;
        this.nomeAmigo = nome;
        this.telefone = telefone;
        this.dao = new AmigoDAO();
    }
    
    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getNomeAmigo() {
        return nomeAmigo;
    }

    public void setNomeAmigo(String nomeAmigo) {
        this.nomeAmigo = nomeAmigo;
    }
    
    @Override
    public String toString() {
        return super.toString() + "nomeAmigo=" + nomeAmigo + ", telefone=" + telefone;
    }
    
    //Pegando os métodos de AmigoDAO
    public ArrayList<Amigo> getMinhaListaAmigo() {
        return dao.getMinhaListaAmigo();
    }
    
    public Amigo carregaAmigo(int idAmigo) {
        return dao.carregaAmigo(idAmigo);
    }
    
    public boolean insertAmigoBD(String nomeAmigo, String telefone) {
        int idAmigo = this.maiorIDAmigo() + 1;
        Amigo objeto = new Amigo(idAmigo, nomeAmigo, telefone);
        dao.insertAmigoBD(objeto);
        return true;
    }
    
    public int maiorIDAmigo() {
        return dao.maiorIDAmigo();
    }
    
    public boolean deleteAmigoBD(int idAmigo) {
        dao.deleteAmigoBD(idAmigo);
        return true;
    }
    
    public boolean updateAmigoBD(int idAmigo, String nomeAmigo, String telefone) {
        Amigo objeto = new Amigo(idAmigo, nomeAmigo, telefone);
        dao.updateAmigoBD(objeto);
        return true;
    }
}
