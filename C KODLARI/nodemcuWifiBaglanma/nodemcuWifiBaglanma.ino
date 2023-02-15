#include <ESP8266WiFi.h>
 
const char* ssid = "uygulama";
const char* password = "keremuygulama";
 
int ledPin = 13; 
WiFiServer server(80);
 
void setup() {
Serial.begin(115200);
delay(10);
 
pinMode(ledPin, OUTPUT);
digitalWrite(ledPin, LOW); 
 

Serial.println();
Serial.println();
Serial.print("Connecting to ");
Serial.println(ssid);
 
WiFi.begin(ssid, password);
 
while (WiFi.status() != WL_CONNECTED) {
delay(500);
Serial.print(".");
}
Serial.println("");
Serial.println("WiFi connected");
 

server.begin();
Serial.println("Server started");
 

Serial.print("Use this URL to connect: ");
Serial.print("http://");
Serial.print(WiFi.localIP());
Serial.println("/");
 
}
 
void loop() {

WiFiClient client = server.available();
if (!client)
{
return;
}
 

Serial.println("new client");
while(!client.available()){
delay(1);
}
 

String request = client.readStringUntil('\r');
Serial.println(request);
client.flush();
 
int value = LOW;
if (request.indexOf("/LED-ACIK") != -1) {
digitalWrite(ledPin, HIGH);
value = HIGH;
}
if (request.indexOf("/LED-KAPALI") != -1) {
digitalWrite(ledPin, LOW);
value = LOW;
}
 

 
client.println("HTTP/1.1 200 OK");
client.println("Content-Type: text/html");
client.println("");
client.println("<!DOCTYPE HTML>");
client.println("<html>");
 
client.print("Led suanda: ");
 
if(value == HIGH) {
client.print("ACIK");
} else {
client.print("KAPALI");
}
client.println("");
client.println("<a href=\"/LED-ACIK\"\"><button>ledi yak </button></a>");
client.println("<a href=\"/LED-KAPALI\"\"><button>ledi sondur </button></a>");
client.println("</html>");
 
delay(1);
Serial.println("Client disonnected");
Serial.println("");
 
} 
