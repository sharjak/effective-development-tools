rootProject.name = "effective-development-tools"
include("app-main")
include("adapter")
include("adapter:web")
include("app-domain")
include("adapter:jdbc")
findProject(":adapter:jdbc")?.name = "jdbc"
include("liquibase")
