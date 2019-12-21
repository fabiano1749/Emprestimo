package com.emprestimoapi.model.operacao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("entrada")
public class TipoEntrada extends MotivoOperacao{

}
