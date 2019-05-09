package Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

import br.com.vacina.Gripe;
import injector.Pessoa;

public class MyAppTest {
	MutablePicoContainer pico;
	Pessoa pessoa;

	@Before
	public void instanciarPico() throws Exception {
		pico = new DefaultPicoContainer();
	}

	@Before
	public void instanciarPessoa() throws Exception {
		pessoa = new Pessoa();
	}

	@After
	public void tearDown() throws Exception {
		pico = null;
	}

	@Test
	public void testInserirVacinaGripeMenoresIdade() {
		pico.addComponent(Gripe.class);
		pessoa = new Pessoa(pico.getComponent(Gripe.class), 2);
		assertEquals(null, pessoa.getVacina());

	}

	@Test
	public void testInserirVacinaGripeMaiores() {
		pico.addComponent(Gripe.class);
		pessoa = new Pessoa(pico.getComponent(Gripe.class), 22);
		assertEquals(pessoa.getVacina(), pessoa.getVacina());

	}

}
