
name := "DynamicSvgFunc"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies += "com.microsoft.azure.functions" % "azure-functions-java-library" % "1.4.2"
libraryDependencies += "com.microsoft.azure.functions" % "azure-functions-java-library-signalr" % "1.0.0"

azfunZipName := "DynamicSvgFunc.zip"
azfunJarName := "ScalaFunction.jar"
//AzureFunctionsKeys.azfunCopyLocalSettingsJson :=

//assemblyOutputPath in assembly := baseDirectory.value / "DynamicSvgFunc" / "ScalaFunction.jar"