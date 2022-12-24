#Gherkin
Feature: Shopiland tests
  #Позитивный сценарий:после выполнение поиска нажатие на логотип возвращает на главную страницу
  Scenario: Return to main page
    Given url 'https://shopiland.ru/'
    Then  click button 'Наушники беспроводные'
    Then  click 'logo' button
    And assert that we back for 'main page'
  #Позитивный сценарий:При происке первым всегда идет товар с большим колвом отзывов (рейтиг)
  Scenario: Rating
    Given url 'https://shopiland.ru/'
    Then  click button 'Наушники беспроводные'
    Then look on 'ratingFirstPicture'
    Then look2 on 'ratingSecondPicture'
    And assert that 'ratingFirstPicture' more then 'ratingSecondPicture'

