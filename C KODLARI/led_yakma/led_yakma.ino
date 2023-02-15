#define PIN 4


void setup() {
  Serial.begin(9600);
  pinMode(PIN,OUTPUT);

}

void loop() {
  digitalWrite(PIN,HIGH);
  delay(1000);
  digitalWrite(PIN,LOW);
  delay(1000);
}
