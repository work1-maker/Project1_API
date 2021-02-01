import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

response1 = WS.sendRequest(findTestObject('CountryInfoService/ListCountries'))

String xml1 = response1.getResponseBodyContent()

def dataVal = new XmlSlurper().parseText(xml1)

def CountryCode = dataVal.ListOfCountryNamesByNameResponse.ListOfCountryNamesByNameResult.tCountryCodeAndName[0].sISOCode.text( // Saved in Variable -> CountryCode
    )

// Now we have to make this Variable's value to global variable i.e. CountryCode will be saved in Globval varibale (ISO) for reference in Get Capital as Global Variable for refering it in the Test GetCapital
GlobalVariable.ISO = CountryCode

WS.sendRequest(findTestObject('CountryInfoService/Get Capital'))

