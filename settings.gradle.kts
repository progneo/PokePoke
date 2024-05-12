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

include(":network")

setOf("core", "presentation").forEach { layer ->
    include(":common-$layer")
    project(":common-$layer").projectDir = File("/common/$layer")
}

setOf("api", "impl").forEach { layer ->
    include(":datasource-$layer")
    project(":datasource-$layer").projectDir = File("/datasource/$layer")
}

setOf("domain", "data", "presentation").forEach { layer ->
    include(":home-$layer")
    project(":home-$layer").projectDir = File("/feature/home/$layer")
}
setOf("domain", "data", "presentation").forEach { layer ->
    include(":detail-$layer")
    project(":detail-$layer").projectDir = File("/feature/detail/$layer")
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
