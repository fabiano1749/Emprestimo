package com.emprestimoapi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.emprestimoapi.model.entidade.ClienteTest;
import com.emprestimoapi.model.operacao.EmprestimoTest;

@RunWith(Suite.class)
@SuiteClasses({ClienteTest.class, EmprestimoTest.class})
public class PrimeiraSuite {

}
