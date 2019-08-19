package motoresdebusqueda.dogpile;

import motoresdebusqueda.dogpile.steps.UsuarioDogPile;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CuandoBuscoResultadosConTexto {
    @Managed
    WebDriver driver;

    @Steps
    UsuarioDogPile andres;
    @Test
    public void resultaadoDeWikipediaContineTextoCorrecto(){
        andres.ingresaADogPile();
        andres.buscaPorPalabraClave("rock nacional");
        andres.deberiaVerResultadoDeTituloiaConTextoCorrecto("Rock de Argentina",
                "El rock and roll surgió como género musical en los Estados Unidos en los años 50");
    }
}
