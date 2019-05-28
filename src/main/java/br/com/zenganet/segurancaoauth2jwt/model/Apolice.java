package br.com.zenganet.segurancaoauth2jwt.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Apolice {

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "cliente_fk")
	private Cliente cliente;

	@Id
	@Column(name = "codigo_apolice")
	private long codigoApolice;
	private long proposta;
	private BigDecimal premio;

	public long getCodigoApolice() {
		return codigoApolice;
	}

	public void setCodigoApolice(long codigoApolice) {
		this.codigoApolice = codigoApolice;
	}

	public long getProposta() {
		return proposta;
	}

	public void setProposta(long proposta) {
		this.proposta = proposta;
	}

	public BigDecimal getPremio() {
		return premio;
	}

	public void setPremio(BigDecimal premio) {
		this.premio = premio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigoApolice ^ (codigoApolice >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apolice other = (Apolice) obj;
		if (codigoApolice != other.codigoApolice)
			return false;
		return true;
	}

}
