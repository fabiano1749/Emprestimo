package com.emprestimoapi.model.operacao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@Entity
@DiscriminatorValue("retirada")
public class TipoRetirada extends MotivoOperacao{

	
}
