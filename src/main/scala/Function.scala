import com.microsoft.azure.functions._
import com.microsoft.azure.functions.annotation._
import com.microsoft.azure.functions.signalr._
import com.microsoft.azure.functions.signalr.annotation._

import java.util._


class Function {

  /**
    * This function listens at endpoint "/api/ScalaFunction". Two ways to invoke it using "curl" command in bash:
    * 1. curl -d "HTTP Body" {your host}/api/ScalaFunction
    * 2. curl {your host}/api/ScalaFunction?name=HTTP%20Query
    */
  @FunctionName("negotiate")
  def negotiate(
                 @HttpTrigger(
                   name = "req",
                   methods = Array(HttpMethod.POST),
                   authLevel = AuthorizationLevel.ANONYMOUS
                 )
                 request: HttpRequestMessage[Optional[String]],
                 @SignalRConnectionInfoInput(
                   name = "connectionInfo",
                   hubName = "svg"
                 )
                 connectionInfo: SignalRConnectionInfo,
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

  @FunctionName("sendSVG")
  def sendSVG(
               @HttpTrigger(
                 name = "req",
                 methods = Array(HttpMethod.POST),
                 authLevel = AuthorizationLevel.ANONYMOUS
               )
               request: HttpRequestMessage[String],
               @SignalROutput(
                 name = "signalrmsg",
                 hubName = "svg"
               )
               signalrmsg: OutputBinding[SignalRMessage],
               context: ExecutionContext): HttpResponseMessage = {
    context.getLogger.info("Java HTTP trigger processed a request.")
    val svgContent = request.getBody
    println(svgContent)
    val message =
      new SignalRMessage(
        "newSVG",
        svgContent
        //"""<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" contentScriptType="application/ecmascript" contentStyleType="text/css" height="321px" preserveAspectRatio="none" style="width:712px;height:321px;" version="1.1" viewBox="0 0 712 321" width="712px" zoomAndPan="magnify"><defs><filter height="300%" id="f9sqtgd" width="300%" x="-1" y="-1"><feGaussianBlur result="blurOut" stdDeviation="2.0"/><feColorMatrix in="blurOut" result="blurOut2" type="matrix" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 .4 0"/><feOffset dx="4.0" dy="4.0" in="blurOut2" result="blurOut3"/><feBlend in="SourceGraphic" in2="blurOut3" mode="normal"/></filter></defs><g><!--cluster PK4--><polygon fill="#FFFFFF" filter="url(#f9sqtgd)" points="451,24,538,24,545,46.2969,705,46.2969,705,314,451,314,451,24" style="stroke: #000000; stroke-width: 2.0;"/><line style="stroke: #000000; stroke-width: 2.0;" x1="451" x2="545" y1="46.2969" y2="46.2969"/><text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacingAndGlyphs" textLength="81" x="455" y="38.9951">package 1</text><!--cluster PK9--><polygon fill="#FFFFFF" filter="url(#f9sqtgd)" points="533,67,635,67,642,89.2969,681,89.2969,681,290,533,290,533,67" style="stroke: #000000; stroke-width: 2.0;"/><line style="stroke: #000000; stroke-width: 2.0;" x1="533" x2="642" y1="89.2969" y2="89.2969"/><text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacingAndGlyphs" textLength="96" x="537" y="81.9951">package 1.1</text><!--entity AC8--><ellipse cx="492" cy="112" fill="#FEFECE" filter="url(#f9sqtgd)" rx="8" ry="8" style="stroke: #A80036; stroke-width: 2.0;"/><path d="M492,120 L492,147 M479,128 L505,128 M492,147 L479,162 M492,147 L505,162 " fill="#FEFECE" filter="url(#f9sqtgd)" style="stroke: #A80036; stroke-width: 2.0;"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacingAndGlyphs" textLength="49" x="467.5" y="181.9951">Actor 2</text><!--entity AC10--><ellipse cx="607" cy="112" fill="#FEFECE" filter="url(#f9sqtgd)" rx="8" ry="8" style="stroke: #A80036; stroke-width: 2.0;"/><path d="M607,120 L607,147 M594,128 L620,128 M607,147 L594,162 M607,147 L620,162 " fill="#FEFECE" filter="url(#f9sqtgd)" style="stroke: #A80036; stroke-width: 2.0;"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacingAndGlyphs" textLength="49" x="582.5" y="181.9951">Actor 1</text><ellipse cx="606.9472" cy="259.5236" fill="#FEFECE" filter="url(#f9sqtgd)" rx="57.4472" ry="14.5236" style="stroke: #A80036; stroke-width: 1.5;"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacingAndGlyphs" textLength="77" x="568.4472" y="264.1721">Use case 1</text><!--entity PK5--><polygon fill="#FFFFFF" filter="url(#f9sqtgd)" points="6,115.5,39,115.5,46,137.7969,108,137.7969,108,171.0938,6,171.0938,6,115.5" style="stroke: #000000; stroke-width: 1.5;"/><line style="stroke: #000000; stroke-width: 1.5;" x1="6" x2="46" y1="137.7969" y2="137.7969"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacingAndGlyphs" textLength="27" x="10" y="131.4951">PK5</text><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacingAndGlyphs" textLength="72" x="16" y="157.792">package 2</text><!--entity AC1--><ellipse cx="168" cy="112" fill="#FEFECE" filter="url(#f9sqtgd)" rx="8" ry="8" style="stroke: #A80036; stroke-width: 2.0;"/><path d="M168,120 L168,147 M155,128 L181,128 M168,147 L155,162 M168,147 L181,162 " fill="#FEFECE" filter="url(#f9sqtgd)" style="stroke: #A80036; stroke-width: 2.0;"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacingAndGlyphs" textLength="49" x="143.5" y="181.9951">Actor 1</text><!--entity AC2--><ellipse cx="252" cy="112" fill="#FEFECE" filter="url(#f9sqtgd)" rx="8" ry="8" style="stroke: #A80036; stroke-width: 2.0;"/><path d="M252,120 L252,147 M239,128 L265,128 M252,147 L239,162 M252,147 L265,162 " fill="#FEFECE" filter="url(#f9sqtgd)" style="stroke: #A80036; stroke-width: 2.0;"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacingAndGlyphs" textLength="49" x="227.5" y="181.9951">Actor 2</text><!--entity AC3--><ellipse cx="360" cy="112" fill="#FEFECE" filter="url(#f9sqtgd)" rx="8" ry="8" style="stroke: #A80036; stroke-width: 2.0;"/><path d="M360,120 L360,147 M347,128 L373,128 M360,147 L347,162 M360,147 L373,162 " fill="#FEFECE" filter="url(#f9sqtgd)" style="stroke: #A80036; stroke-width: 2.0;"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacingAndGlyphs" textLength="49" x="335.5" y="181.9951">Actor 3</text><ellipse cx="164.9472" cy="259.5236" fill="#FEFECE" filter="url(#f9sqtgd)" rx="57.4472" ry="14.5236" style="stroke: #A80036; stroke-width: 1.5;"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacingAndGlyphs" textLength="77" x="126.4472" y="264.1721">Use case 1</text><ellipse cx="314.9472" cy="259.5236" fill="#FEFECE" filter="url(#f9sqtgd)" rx="57.4472" ry="14.5236" style="stroke: #A80036; stroke-width: 1.5;"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacingAndGlyphs" textLength="77" x="276.4472" y="264.1721">Use case 2</text><path d="M607,185.051 C607,203.5788 607,224.5479 607,239.4996 " fill="none" style="stroke: #A80036; stroke-width: 1.0;"/><polygon fill="#A80036" points="607,244.7202,611,235.7202,607,239.7202,603,235.7202,607,244.7202" style="stroke: #A80036; stroke-width: 1.0;"/><path d="M274.5665,185.051 C284.8695,204.0217 296.5626,225.5517 304.7144,240.5613 " fill="none" style="stroke: #A80036; stroke-width: 1.0;"/><polygon fill="#A80036" points="307.1251,245.0001,306.3449,235.1822,304.7388,240.6063,299.3148,239.0002,307.1251,245.0001" style="stroke: #A80036; stroke-width: 1.0;"/><path d="M227.302,176.4307 C211.6487,197.3018 191.9731,223.5359 178.9686,240.8752 " fill="none" style="stroke: #A80036; stroke-width: 1.0;"/><polygon fill="#A80036" points="175.8126,245.0832,184.4126,240.2832,178.8126,241.0832,178.0126,235.4832,175.8126,245.0832" style="stroke: #A80036; stroke-width: 1.0;"/></g></svg>""""
      );
    signalrmsg.setValue(message);
    request
      .createResponseBuilder(HttpStatus.OK)
      .body()
      .build()
  }
}