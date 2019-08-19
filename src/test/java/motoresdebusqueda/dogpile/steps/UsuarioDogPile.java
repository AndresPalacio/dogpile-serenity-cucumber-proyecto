package motoresdebusqueda.dogpile.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import motoresdebusqueda.dogpile.pageobject.DogPilePaginaResultado;
import motoresdebusqueda.dogpile.pageobject.DogpilePaginaPrincipal;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class UsuarioDogPile extends ScenarioActor {

    @Steps(shared = true)
    DogpilePaginaPrincipal paginaPrincipal;
    @Steps(shared = true)
    DogPilePaginaResultado paginaResultado;

    @Step("que el usuario entra en dogpile")
    public void ingresaADogPile() {
        this.paginaPrincipal.setDefaultBaseUrl("https://www.dogpile.com/");
        paginaPrincipal.open();
    }
    // significa que ese sector va recibir una variable y en orden va recibir
    // el paso termina en $  se coloco porque si estoy usando un metodo el me lee los elementos que contengan el texto
    // asi que si otro tiene el mismo texto pero no termina en algun lugar lo llamara
    // ejemplo el realiza una busqueda de : rock nacional si no finaliza y existe otro llamado
    // el realiza una busqueda de :  rocknalcional por nombre <- me llamara ese tambien po no colocar el $
    // lo mismo pasa con el comienza
    @Step("el realiza una busqueda de: {0}")
    public void buscaPorPalabraClave(String rock_nacional) {
        paginaPrincipal.ingresarPalabraClave(rock_nacional);
        paginaPrincipal.realizarBusqueda();

    }
    @Step("El usuario deberia poder ver resultados que contengan la palabra : {0}")
    public void deberiaVerResultadosConPalabra(String rock) {
        List<String> resultados = paginaResultado.obtenerResultados();
        resultados.replaceAll(String::toLowerCase);
        // convertir todos los elementos a miniscula
        resultados.stream().forEach(el -> System.out.println(el));
        assertThat(resultados, Matchers.everyItem(containsString(rock)));
    }

    //@Step("#actor debera ver el texto esperado: {1} en el resultado del titulo : {0}")
    @Step("El usuario deberia ver un texto: relevante con el titulo: {0} y el texto :  {1}")
    public void deberiaVerResultadoDeTituloiaConTextoCorrecto(String tituloResultado, String textoResultado) {
        String texto = paginaResultado.obtenerTextoDeTituloResultado(tituloResultado);
        List<String> hola;
        System.out.println(texto);
        System.out.println(textoResultado);
        assertThat(texto,containsString(textoResultado));

    }
}
