pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PokePoke"

include(":app")
include(":common")
include(":network")

include(":datasource:api")
include(":datasource:impl")

setOf("domain", "data", "presentation").forEach { layer ->
    include(":feature:home:$layer")
    project(":feature:home:$layer").projectDir = File("/feature/home/$layer")
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
