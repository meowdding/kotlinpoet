/*
 * Copyright (C) 2021 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
plugins {
  kotlin("jvm")
}

tasks.jar {
  manifest {
    attributes("Automatic-Module-Name" to "com.squareup.kotlinpoet.ksp")
  }
}

dependencies {
  api(projects.kotlinpoet)
  compileOnly(libs.ksp.api)
  testImplementation(libs.kotlin.junit)
  testImplementation(libs.truth)
}

pluginManager.withPlugin("maven-publish") {
  configure<PublishingExtension> {
    publications {
      create<MavenPublication>("maven") {
        artifactId = "ksp"
        group = "me.owdding.kotlinpoet"
        from(components["kotlin"])

        pom {
          name.set("kotlinpoet-ksp")
          url.set("https://github.com/meowdding/kotlinpoet")

          scm {
            connection.set("git:https://github.com/meowdding/kotlinpoet.git")
            developerConnection.set("git:https://github.com/meowdding/kotlinpoet.git")
            url.set("https://github.com/meowdding/kotlinpoet")
          }
        }
      }
    }
    repositories {
      maven {
        setUrl("https://maven.teamresourceful.com/repository/thatgravyboat/")
        credentials {
          username = System.getenv("MAVEN_USER") ?: providers.gradleProperty("maven_username").orNull
          password = System.getenv("MAVEN_PASS") ?: providers.gradleProperty("maven_password").orNull
        }
      }
    }
  }
}
