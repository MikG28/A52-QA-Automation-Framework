public class test {
}
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >

<suite name="TestNG">
<suite name="TestNG" parallel="methods" thread-count="2">
<parameter name="baseUrl" value="https://qa.koel.app/"/>
    <test name="Example Test" preserve-order="false">
        <classes>


id 'java'
        }

ext {
    suite = ""
}

group 'org.example'
version '1.0-SNAPSHOT'

@@ -17,7 +21,8 @@ dependencies {

    test {
        useTestNG() {
            suites "src/test/resources/TestNG.xml"
            systemProperty "suite", System.getProperty("suite", suite)
            suites "src/test/resources/${suite}.xml"
            systemProperty "browser", System.getProperty("browser")
        }
    }

    