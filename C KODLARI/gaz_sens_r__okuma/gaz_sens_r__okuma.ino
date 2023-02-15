int esikDegeri = 450; //Gaz eşik değerini belirliyoruz.    

int deger; //Sensörden okunan değer

void setup() {
  Serial.begin(9600);
}

void loop() {
  
  Serial.println("analog okuyacağım");
  deger = analogRead(A0); //Sensörden analog değer okuyoruz.
  Serial.println("analog okudum");
  Serial.println(deger);
  if (deger > esikDegeri) { //Sensörden okunan değer eşik değerinden büyükse çalışır.
    Serial.println("BAŞARILI");
  } 
}
