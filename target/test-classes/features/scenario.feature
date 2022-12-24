#Gherkin
Feature: Find weather
  #Позитивный сценарий: выбираем город саратов и получем погоду для саратова
  Scenario: chose city
    Given url of weather 'https://yandex.ru/pogoda/'
    Then  chose city 'Волжский район, Саратов'
    Then  Click on 'Волжский район, Саратов'
    And assert that chosen city is 'Волжский район, Саратов'
  #Негатинвый сценарий: выбираем несушествующий город, получаем соответствуещее уведомление
  Scenario: chose absent city
    Given url of weather 'https://yandex.ru/pogoda/'
    Then  chose city 'Fogea'
    And assert that user got message 'По вашему запросу ничего не нашлось'

