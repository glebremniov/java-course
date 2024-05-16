rootProject.name = "course"
include("lesson2")
include("lesson4")
include("lesson5")
include("lesson6")
include("lesson7")
include("lesson7:api")
include("lesson7:demo")
include("lesson7:service")
findProject(":lesson7:api")?.name = "api"
findProject(":lesson7:demo")?.name = "demo"
findProject(":lesson7:service")?.name = "service"
include("lesson8")
