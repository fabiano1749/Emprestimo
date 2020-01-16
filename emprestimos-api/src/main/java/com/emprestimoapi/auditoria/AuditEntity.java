package com.emprestimoapi.auditoria;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Entity
@Table(name = "auditoria")
@RevisionEntity(AuditListener.class)
public class AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@RevisionNumber
	private Integer id;
	
	@RevisionTimestamp
	private long timestamp;
	
	private LocalDateTime dataReg;
	
	private String usuario;
	
	public AuditEntity() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public LocalDateTime getDataReg() {
		return dataReg;
	}

	public void setDataReg(LocalDateTime dataReg) {
		this.dataReg = dataReg;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@Transient
	public Date getRevisionDate() {
		return new Date( timestamp );
	}
	
	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( !(o instanceof AuditEntity) ) {
			return false;
		}

		final AuditEntity that = (AuditEntity) o;
		return id == that.id
				&& timestamp == that.timestamp;
	}

	@Override
	public int hashCode() {
		int result;
		result = id;
		result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "DefaultRevisionEntity(id = " + id
				+ ", revisionDate = " + DateFormat.getDateTimeInstance().format( getRevisionDate() ) + ")";
	}
}
