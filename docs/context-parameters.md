Context Parameters
==================

KotlinPoet supports Kotlin's context parameters feature, which allows you to add context parameters to functions and properties. Context parameters are added using the `contextParameter()` method:

```kotlin
val greet = FunSpec.builder("greet")
  .contextParameter("user", String::class)
  .addStatement("println(\"Hello, ${'$'}user!\")")
  .build()
```

The code above generates:

```kotlin
context(user: kotlin.String)
public fun greet() {
  println("Hello, $user!")
}
```

You can add multiple context parameters:

```kotlin
val loggerType = ClassName("java.util.logging", "Logger")
val configType = ClassName("com.example", "Config")

val logger = ContextParameter("logger", loggerType)
val config = ContextParameter("config", configType)

val processData = FunSpec.builder("processData")
  .contextParameter(logger)
  .contextParameter(config)
  .addStatement("%N.info(\"Processing with config: ${'$'}%N\")", logger, config)
  .build()
```

This generates:

```kotlin
context(logger: com.example.Logger, config: com.example.Config)
public fun processData() {
  logger.info("Processing with config: $config")
}
```

**Note:** context receivers and context parameters cannot be used together.
