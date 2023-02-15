const int buzzer = 9; 
#define Buton 8
int kapatildi;


void setup(){
 
  pinMode(buzzer, OUTPUT); 
  pinMode(Buton, INPUT);

}

void loop(){

  if(digitalRead(Buton) == 0 && kapatildi == 0 ){
 
  tone(buzzer, 1000); 
  delay(1000);        
  noTone(buzzer);     
  delay(1000);        
  }

  else if(digitalRead(Buton) == 1){
      
       kapatildi = 1;
   }
}
