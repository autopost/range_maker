This is a simple Web application based on Spring Boot project that contains 2 endpoints:
- http://127.0.0.1:8080/health     GET <br>
# return 200 on response
- http://127.0.0.1:8080/validate   POST <br>
# diapasonMin : int <br>
# diapasonMax : int <br>
# range <br>
. Specified as a string for diapasonMin and diapasonMax <br>
. Can starts from any value from diapason (including lowest and highest) <br>
. Can lists any numbers from diapason using “,” separator <br>
. Can use “-” symbol for subrange. Example “2-5” means all 2,3,4,5 values <br>
from the diapason. Open end for subrange means “till the end of <br>
diapason” <br>
. Allows combination of values and subrange. Example “0, 2-5” <br>

How to run
- Import project as Maven and run TestTaskApplication class. 
- Or import project, mvn clean install, deploy artefact to your local Tomcat.

Open URL in the browser
http://127.0.0.1:8080/index.html
