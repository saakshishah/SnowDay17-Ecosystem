int ledpin = 13;
int buttonpin = 8;
boolean on = false;
int buttonstate = 0;
boolean debounce = false;
int timelen =0;

void setup() {
  // put your setup code here, to run once:
  pinMode(ledpin, OUTPUT);
  pinMode(buttonpin, INPUT);
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  buttonstate=digitalRead(buttonpin);
  delay(1);
  if (buttonstate == 1 && debounce == false){
    debounce = true;
    if (on == true){
      on = false;
    }
    else{
      on = true;
    }
  }
  else if (buttonstate == 0){
    debounce =false;
  }
  
  if (on == true){
    digitalWrite(ledpin, HIGH);
  }
  else {
    digitalWrite(ledpin, LOW);
  }
}


