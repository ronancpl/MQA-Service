# MQA-Service
 A road planning tool for cruising quests in MapleStory

## Head developer: Ronan C. P. Lana

This is the Service-side REST application for MapleQuestAdvisor, which sends the User-side CSV userdata files through REST interface.

This Web application reads into the server's database (URL & DB credentials are the same provided in the server's config file) to build the CSV files required to run an instance of MapleQuestAdvisor.
Henceforth, it enables the end-user informations such as:
* Character info (id, name, meso, map, etc);
* Character's inventory & quests;
* Server rates.

---
### Download items

As this is a Web Application, in order to run it is needed to configure a Web Application Server, such as Tomcat, Glassfish or Wildfly. For expediency, let's use Wildfly.

Wildfly: https://drive.google.com/drive/folders/1de7OBY6rSvQb0QNccvIbV3tgcw_jpUF9

Extract the contents of the compressed file in a place of your preference.

---
### Installation steps

Follow [HeavenMS](https://github.com/ronancpl/HeavenMS#preparing-the-ambient) installation steps.

* Open NetBeans, with Administrator privileges;
* Select category "Java Web";
* Browse "Tools" -> "Plugins" -> "Available Plugins";
* Install plugin "Java EE Base".

For MQA-Service, open NetBeans. It is needed to create an application server container for this Web Service.

* Browse "Tools" -> "Servers";
* Use Wildfly by selecting its location folder. The new container should have been created.
* Click "New project...". Opt for creating one "with existent code".

Inside the project you might encounter some code errors, you have yet to set the core JARs of the project.

From the project hierarchy, right-click the project and select "Properties" -> "Libraries" -> "Add JAR/Folder".

Locate the folder "cores" inside the root directory of the server files and manually configure those cores on NetBeans.

---
### Usage

To run, from the Project hierarchy tree, right-click the project and select "Debug".

A console window should inform about the situation of the service.
