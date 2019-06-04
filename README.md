/**************Setting Broadcast receiver and sending BroadCase Receiver.************/

1. So Broadcast receivers are the peice of code that will execute when it registers to some event like when power is connected the
   android system will send broadcast to those applications those are registered with this event.

2. When an app gets killed receivers are ment to be killed by system to reclaim memory. So if you wan to perform some more time to execte 
   then go whith "goSync()" and assgn a task to it so it can execte.
   
3. When you try to reregister the receiver and kills the apps the register may not work under Android surcumstances. so if you want to run
   a background process to be there user foreground process at point of time.
  
4. And coming to Sending broadcast receivers please be sure about what king of registers you are sending so that memory leakage will be less
   and it will be more secure.
   
5. Use "LocalBroadCastManager.sendBroadcast()" to send registers with in app. so that no other app can even listen to it and responds


6. Use OrderedBroaCast for sending broadcaste in order. at any point of time only one receiver can execute. and android system will decide 
   which one to execute based on priority.
   
   
   
   
   
   /*******Resource*********/
   
   link : https://developer.android.com/guide/components/broadcasts
