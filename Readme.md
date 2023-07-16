# WeatherDetailAuto

## How to install:

Pull from Git project and go to destination folder ./WeatherDetailAuto

run: mvn clean test

## How to Run

On Terminal in Mac or Windows go to following folder

./WeatherDetailAuto

Run commands: mvn clean verify

## Objective: 

View next seven days of temperature if more than predicted temperature.

## Design
BDD Design
* Cucumber file specification
* StepDef to link Cucumber file 
* Page Objects to link Step Def
* Drier file to make API calls
* Utils file for common functions for Page Objects

### Step 1. 
OpenWeatherTemp.feature
  @VerifyTempByLatLong
 @VerifyTemDetByPostCode
 
      
### Step 2. 
    Define Step Def functions as per pages. main purpose is Assertions is done here
  *   OpenWeatherTempStepDef

  
### Step 3. 
    OpenWeatherTempAction where logic is defined
* OpenWeatherTempAction
Below two functions that construct call for above two scenario calls:
* buildGetRequest
* getResponse
* validateNextSevnDaysTemp


### Step 4.
Main Logic:
* Utils
* global.properties defines baseWeatherUrl=https://api.weatherbit.io/v2.0/current
## Result
Result is saved in below file

/target/reports-html.html

### Step 5.
Cucumber report is generated in:

\target\cucumber-html-reports
List of temperature more than predicted temperature is printed on screen


 
 