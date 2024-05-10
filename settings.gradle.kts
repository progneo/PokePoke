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

include(":domain")
include(":data")
include(":presentation")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
