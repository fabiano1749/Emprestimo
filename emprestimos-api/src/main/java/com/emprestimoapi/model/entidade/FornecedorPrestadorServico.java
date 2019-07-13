package com.emprestimoapi.model.entidade;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("fornecedor")
public class FornecedorPrestadorServico extends Entidade{
	
}
