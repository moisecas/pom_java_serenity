Feature: BrowserStack Demo

  #Scenario Outline: BStack Sample Test - Add product to cart
  # Given I am on the website www.bstackdemo.com
  # When I go to a <section> using buttons of marks
  # Examples:
  #     | section | 
  #     | Apple   | 
  #     | Samsung | 
  #     | Google  |

  Scenario: Flujo básico de inicio de sesión
    Given el usuario navega a la página principal de BrowserStack Demo
    When el usuario se dirige a la pagina de inicio de sesión
    Then se valida que se haga login #Se valida que se hizo login verificando que el nombre de usuario aparece correctamente 