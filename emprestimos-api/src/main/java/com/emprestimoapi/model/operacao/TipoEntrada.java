package com.emprestimoapi.model.operacao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.envers.Audited;


@Entity
@DiscriminatorValue("entrada")
@Audited
public class TipoEntrada extends MotivoOperacao{

}
