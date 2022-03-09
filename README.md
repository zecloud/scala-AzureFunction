# scala-AzureFunction
Scala Azure Function sample with sbt 
Custom DevContainer with custom Docker File  with all necessary tools included  
to build it : sbt azfunCreateZipFile  
to run it : cd target/DynamicSvgFunc && func start  
to publish it on Azure :  
run "az login" to connect to your azure account  
create the needed resources :  
az group create --name AzureFunctionsScala --location <REGION>  
az storage account create --name <STORAGE_NAME> -g AzureFunctionsScala --sku Standard_LRS  
az functionapp create --consumption-plan-location westeurope --runtime java --functions-version 3 --name <APP_NAME> -g  AzureFunctionsScala --os-type linux --storage-account <STORAGE_NAME>  
Finally Publish it with :  
func azure functionapp publish <APP_NAME>  
