package motoresdebusqueda.dogpile.StepsDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import motoresdebusqueda.dogpile.pageobject.DogPilePaginaResultado;
import motoresdebusqueda.dogpile.pageobject.DogpilePaginaPrincipal;
import motoresdebusqueda.dogpile.steps.UsuarioDogPile;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class UsuarioStepDefinion {
    @Steps(shared = true)
    UsuarioDogPile usuarioDogPile;

    @Given("^que el usuario entra en dogpile$")
    public void ingresaADogPile() {
        usuarioDogPile.isCalled("andres");
        this.usuarioDogPile.ingresaADogPile();
    }
    // significa que ese sector va recibir una variable y en orden va recibir
    // el paso termina en $  se coloco porque si estoy usando un metodo el me lee los elementos que contengan el texto
    // asi que si otro tiene el mismo texto pero no termina en algun lugar lo llamara
    // ejemplo el realiza una busqueda de : rock nacional si no finaliza y existe otro llamado
    // el realiza una busqueda de :  rocknalcional por nombre <- me llamara ese tambien po no colocar el $
    // lo mismo pasa con el comienza
    @When("^el realiza una busqueda de: (.*)$")
    public void buscaPorPalabraClave(String rock_nacional) {
        usuarioDogPile.isCalled("andres");
        this.usuarioDogPile.buscaPorPalabraClave(rock_nacional);

    }
    @Then("^El usuario deberia poder ver resultados que contengan la palabra : (.*)$")
    public void deberiaVerResultadosConPalabra(String rock) {
        usuarioDogPile.isCalled("andres");
        this.usuarioDogPile.deberiaVerResultadosConPalabra(rock);
    }

    //@Step("#actor debera ver el texto esperado: {1} en el resultado del titulo : {0}")
    @Then("El usuario deberia ver un texto: relevante con el titulo: (.*) y el texto :  (.*)")
    public void deberiaVerResultadoDeTituloiaConTextoCorrecto(String tituloResultado, String textoResultado) {
        usuarioDogPile.isCalled("andres");
        this.usuarioDogPile.deberiaVerResultadoDeTituloiaConTextoCorrecto(tituloResultado,textoResultado);
    }
}
