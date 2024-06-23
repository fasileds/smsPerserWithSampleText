SMSData
his code defines a data class SMSData with properties 
representing various attributes of an SMS transaction, such as date, 
bank name, transaction type, amount, and balance. This class is designed to hold and 
manage data related to SMS transactions in the SMS parsing application.

SMSParser
his SmsParser object contains a parseSMS function that parses SMS text messages from the Commercial Bank of Ethiopia and
extracts relevant information to construct an SMSData object representing the parsed data.


SMSReceiver
this SMSReceiver class listens for incoming SMS messages and extracts the message body. 
It then passes the message body to 
the parseSMS function to extract relevant information from the SMS content.

MainActivity

This MainActivity class is the core of the app's UI. 
It checks SMS permission, displays parsed SMS data, and updates the UI. 
It also handles permission requests. 
The displaySampleSMSData() method parses a sample SMS using SmsParser, updates UI elements with parsed data, and generates a sample chart. If SMS permission is granted, it triggers displaySampleSMSData(). 
If denied, it displays a toast message. 
The UI displays parsed data like date, bank name, etc.,
and a line chart visualizes balance over time. The onRequestPermissionsResult() method handles permission responses. 
Overall, it ensures smooth UI interaction while managing SMS permissions and displaying parsed SMS data.



overall view of the smsPareser app

This Android app parses SMS messages, extracting specific banking transaction details such as date, bank name, time, transaction type, amount, and balance. Here's how it works:

SMS Reception: The app registers a BroadcastReceiver to listen for incoming SMS messages.

Permission Handling: Upon app launch, it checks if it has permission to read SMS messages. If not, it requests permission from the user.

SMS Parsing: When an SMS is received, the BroadcastReceiver extracts the message body and passes it to the parseSMS function.
   This function uses regular expressions to extract the required information from the SMS text and returns a data object (SMSData) containing the parsed details.

UI Update: The MainActivity updates the UI with the parsed data, displaying details such as the transaction date, bank name, transaction type, amount, and balance in TextViews. 
  Additionally, it generates a line chart using the parsed balance data over time, providing a visual representation of the user's account balance fluctuations.

Sample Data Display: If permission is granted, the app displays a sample SMS message's parsed data on the UI, giving the user a preview of how the app functions.

Overall, this app provides a user-friendly interface for viewing and analyzing banking transaction information received via SMS messages from a specific bank. 
It ensures seamless integration between SMS parsing, data display, and permission handling to deliver a smooth user experience.
