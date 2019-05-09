package Test;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

import br.com.vacina.Chicungunha;
import br.com.vacina.Gripe;
import injector.Pessoa;

public class MainProgram {

	public static void main(String[] args) {
		MutablePicoContainer pico = new DefaultPicoContainer();
		pico.addComponent(Gripe.class);
		pico.addComponent(Chicungunha.class);

		Pessoa pessoa = new Pessoa(pico.getComponent(Gripe.class),2);
		
		pessoa.injecao();
	}

}
