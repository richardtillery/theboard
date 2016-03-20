# The Board

This project contains:

<b>the-board-ui</b> - project containing all UI components for The Board (these components are stored in Amazon's S3 AWS service)
This is an Eclipse 'Static Web Project.'  
  
<b>the-board-services</b> - project containing web services for The Board (these components are deployed to an Amazon EC2 cluster)
This is an Eclipse 'Dynamic Web Project,' and uses Spring Boot as both framework and app server (Spring Boot includes an embedded Tomcat instance).  To run via Maven, execute the spring-boot:run goal.

The Board: <a href="http://tillery.s3-website-us-west-2.amazonaws.com">tillery.s3-website-us-west-2.amazonaws.com</a>

# Getting Started:
Fork this project!  
git clone https://github.com/richardtillery/theboard.git  
Import <b>the-board-ui</b> into Eclipse (Mars)  
Add some cool AngularJS code!  
