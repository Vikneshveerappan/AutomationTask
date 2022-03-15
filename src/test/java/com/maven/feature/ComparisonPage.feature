@CompBtnImdbWiki
Feature: Comparison automation for IMDB and WIKI

Scenario: Launch the browser
Given user prefers to launch chrome browser
And URL is launched in the chrome browser

@TC_1
Scenario: User gets data from IMDB webpage
And User navigate to 'https://www.imdb.com/title/tt9389998/' page
And User get release date from imdb page
And User get country of origin from imdb page


@TC_2
Scenario: User gets data from wiki page
And User navigate to 'https://en.wikipedia.org/wiki/Pushpa:_The_Rise' page
And User get release date from wiki page
And User get country of origin from wiki page

@TC_3
Scenario: User compare both data
And User compare both imdb and wiki data for release date and country of origin
