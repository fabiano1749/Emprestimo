package com.emprestimoapi.auditoria;

import java.time.LocalDateTime;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuditListener implements RevisionListener{

	@Override
	public void newRevision(Object revisionEntity) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		AuditEntity revEntity = (AuditEntity) revisionEntity;
		revEntity.setUsuario(username);
		revEntity.setDataReg(LocalDateTime.now());
	}

}
