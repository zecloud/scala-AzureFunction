import java.util._

import com.microsoft.azure.functions.annotation._

import com.microsoft.azure.functions._

import scala.collection.JavaConverters._
import com.microsoft.azure.functions.signalr.annotation._
import com.microsoft.azure.functions.signalr._


class Function {

  /**
    * This function listens at endpoint "/api/ScalaFunction". Two ways to invoke it using "curl" command in bash:
    * 1. curl -d "HTTP Body" {your host}/api/ScalaFunction
    * 2. curl {your host}/api/ScalaFunction?name=HTTP%20Query
    */
  @FunctionName("negotiate")
  def run(
           @HttpTrigger(
             name = "req",
             methods = Array(HttpMethod.POST),
             authLevel = AuthorizationLevel.ANONYMOUS) request: HttpRequestMessage[
             Optional[String]],
           @SignalRConnectionInfoInput(
            name = "connectionInfo",
            hubName = "svg") connectionInfo:SignalRConnectionInfo,
           context: ExecutionContext): HttpResponseMessage = {
    context.getLogger.info("Java HTTP trigger processed a request.")
    // Parse query parameter
    //val query: String = request.getQueryParameters.get("name")
    //val name: String = request.getBody.orElse(query)
    //if (name == null) {
    //  request
    //    .createResponseBuilder(HttpStatus.BAD_REQUEST)
    //    .body("Please pass a name on the query string or in the request body")
    //    .build()
    //} else {
      request
        .createResponseBuilder(HttpStatus.OK)
        .body(connectionInfo)
        .build()
    //}
  }

}