Feature:Busqueda en dogpile
  esta feature se trata de hacer una busqueda o multiples busquedas
  en dogpile y revisar los resultados de esa busqueda

  Scenario: Buscar resultados relevantes
    Given que el usuario entra en dogpile
    When el realiza una busqueda de: rock nacional
    Then El usuario deberia poder ver resultados que contengan la palabra : rock

    Scenario: verificar que los resutlados con texto relevante al titulo
      Given que el usuario entra en dogpile
      When el realiza una busqueda de: rock nacional
      Then El usuario deberia ver un texto: relevante con el titulo: Rock de Argentina y el texto :  El rock and roll surgió como género musical en los Estados Unidos en los años 50
