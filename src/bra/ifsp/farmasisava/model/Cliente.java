package bra.ifsp.farmasisava.model;

import java.util.Calendar;
import java.util.Date;

public class Cliente {
	private int idCliente;
	private String nome, telefone, cpf, endereco, cidade, uf, bairro, CEP;
	private Date dataNascimento;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public boolean validarIdade(java.util.Date data) throws Exception {

	     Calendar dataNascimento = Calendar.getInstance();  
	     dataNascimento.setTime(data); 
	     Calendar dataAtual = Calendar.getInstance();  

	     int idade = dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR); 

	     if ((idade < 65) || (idade > 120)) {
	         Exception erro = new Exception();
	         throw erro;
	     }
        else 
        {       
         return true;
        }
	 }
	
}
