Simple Analytics Web App Using Java RESTful Web Service 

This program is a basic implementation of a sales based analytics web application which uses a RESTful web service as the controller. 
This program combines JSON, HTML, MySQL DB, and JAVA Free charts in order to display information to the user about sales numbers for products and employees over a tree year period. 
The program uses URLs to determine what method to call. These are predetermined and embedded in the user’s section list. 
Upon selecting an option in the list the corresponding method in the controller class will be executed.

The program is comprised of eight classes whose name and responsibilities are listed below.

SalesApp: This class is the controller which implements the RESTful web service methods.

UserInterface: This class contains specific methods to produce HTML pages which are used as the interface for the user. These methods are called from SalesApp.

ExtractData: This class is responsible for compiling the data from the database into a meaningful set of data. This class returns the data as a multi-map.

Graph: This class utilizes the Java Free Chart library and the map returned from ExtractData to generate graphs of the data presented.

Analysis: this class takes the map returned from ExtractData and finds the min, max, and avg values of the data contained.

Employee, Sales, Product : These class are entity classes and are presentative of the tables in the DataBase.
