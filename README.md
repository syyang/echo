# Echo Server

This is a template project for starting up a simple echo server using
finagle and thrift.

## Instructions

1. Download sbt. See https://github.com/harrah/xsbt/wiki/Getting-Started-Setup.

2. Download intellji and install sbt and scala plugins.

3. Run ./sbt to sync down all dependencies.

4. Run ./sbt gen-idea to create idea project file. See
http://stackoverflow.com/questions/4250318/how-to-create-sbt-project-with-intellij-idea.

5. Run ./sbt scrooge-gen to generate finagle client and server wrapper class
for the echo thrift service.  

6. Open the project in intelliji, and configure java sdk so that we can run the app
within eclipse. For details see:
http://stackoverflow.com/questions/4773784/module-sdk-for-scala-in-intellij-idea

Also, check sbt-launch.jar path.

7. To clean, run ./sbt clean.

