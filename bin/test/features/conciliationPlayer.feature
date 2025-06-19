@Reportes
Feature: Ir a conciliación de jugadores


  Background: Usuario autenticado
    Given ingreso a la pagina de login
    When ingreso con el usuario de entorno y la contraseña de entorno
    Then deberia acceder exitosamente



  Scenario: Visualizar reporte de conciliación de jugadores
    Given navego a la seccion Reportes
    When selecciono la opcion Conciliación de Jugadores
    Then deberia visualizar el reporte de conciliación de jugadores "Reporte Conciliación de Jugadores"
