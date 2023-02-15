#include <ESP8266WiFi.h>
const char *ssid =  "uygulama";     
const char *pass =  "keremuygulama"; 


int lpg;
void send_event(const char *event);
const char *host = "maker.ifttt.com";
const char *privateKey = "dL3QoiNChcQDy_UXfCOq240x7rT8Ct8FcPsRL99gFfL";  //İFTTT KEYİMİZ
WiFiClient client;
void setup() 
{
       Serial.begin(115200); 
       delay(10);

       Serial.println("Connecting to ");
       Serial.println(ssid);
       WiFi.begin(ssid, pass); 
       while (WiFi.status() != WL_CONNECTED) 
     {
            delay(550);
            Serial.print(".");
     }
      Serial.println("");
      Serial.println("WiFi connected");
 }
void loop() 
{


     send_event("LPG_event");                 
    
}
void send_event(const char *event)
{
  Serial.print("Connecting to ");
  Serial.println(host);  

  WiFiClient client;
  const int httpPort = 80;
  if (!client.connect(host, httpPort)) {
    Serial.println("Connection failed");
    return;
  }  

  String url = "/trigger/";
  url += event;
  url += "/with/key/";
  url += privateKey;  
  Serial.print("Requesting URL: ");
  Serial.println(url);  

  client.print(String("GET ") + url + " HTTP/1.1\r\n" +
               "Host: " + host + "\r\n" + 
               "Connection: close\r\n\r\n");
  while(client.connected())
  {
    if(client.available())
    {
      String line = client.readStringUntil('\r');
      Serial.print(line);
    } else {

      delay(50);
    };
  }
  Serial.println();
  Serial.println("closing connection");
  client.stop();
}
