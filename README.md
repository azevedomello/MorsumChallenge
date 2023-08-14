# Morsum Challenge

Hi there, please find here the required Steps to reproduce the test cases and report. 
I’m using the Allure Report to give us more visibility and traceability.

Pre-requisites:
-  Project should be downloaded from shared link of GitHub;
-  Need to have Maven installed and configured;
-  Install Allure Report.

---------------

<h3>Allure Report</h3>
1.  Allure is available from the Scoop CLI installer.
To Install Allure, download and install Scoop and then execute in the Powershell: scoop install allure. 

2.  After executing the test cases, Allure Report will provide one directory inside the Project (root) with the .json files that will support the dashboard report to be displayed.

3.  After running the tests, Open the CLI / terminal inside the project and execute the following command:
        - mvn test
        - allure generate target\allure-results -o target\allure-report
        - allure open target\allure-report


If correctly installed, Allure Report dashboard will be displayed and one URL to access the report as well.
The test automation dependencies are inside the file pom.xml (JDK 20 / TestNG used to run the test cases).

---------------

<h3>    Please, find attached the Project Structure and Some Allure Report Screenshots. </h3>


<h4><center>Allure Report Dashboard: 
<br> </br>
<div align="left">
<img src="https://github.com/azevedomello/bank/blob/e0f8e4288aa3a3545a0590f05d6f7adf5f8e2971/1.jpeg" width="700px"/>
</div> 

<h4><center>Allure Report Dashboard: 
<br> </br>
<div align="left">
<img src="https://github.com/azevedomello/bank/blob/e0f8e4288aa3a3545a0590f05d6f7adf5f8e2971/2.jpeg" width="700px"/>
</div>  

<h4><center>Allure Report Dashboard: 
<br> </br>
<div align="left">
<img src="https://github.com/azevedomello/bank/blob/e0f8e4288aa3a3545a0590f05d6f7adf5f8e2971/3.jpeg" width="700px"/>
</div>  
