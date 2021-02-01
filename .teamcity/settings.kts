import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.2"

project {

    vcsRoot(Demo)

    buildType(Build)
}

object Build : BuildType({
    name = "Build"
    description = "Build the project"
})

object Demo : GitVcsRoot({
    name = "Demo"
    url = "https://github.com/sreejutr/Demo.git"
    pushUrl = "https://github.com/sreejutr/Demo.git"
    branch = "master"
    authMethod = password {
        userName = "sreejutr@gmail.com"
        password = "credentialsJSON:92d84340-4569-49d4-806b-9eb2e27e5fda"
    }
})
