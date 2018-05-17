' sends an email


Set objMessage = CreateObject("CDO.Message") 
objMessage.Subject = "Email Test" 
objMessage.From = "karansuraj@gmail.com" 
objMessage.To = "karansuraj@gmail.com@gm.com" 
objMessage.TextBody = "This is a Test" 


objMessage.Configuration.Fields.Item _
    ("http://schemas.microsoft.com/cdo/configuration/sendusing") = 2
objMessage.Configuration.Fields.Item _
    ("http://schemas.microsoft.com/cdo/configuration/smtpserver") = _
        "forwarder.gm.com" 
objMessage.Configuration.Fields.Item _
    ("http://schemas.microsoft.com/cdo/configuration/smtpserverport") = 25
objMessage.Configuration.Fields.Update
objMessage.Send