GoogleFormUploader
==================

This project aims to make a re-usable library that simplifies uploading data into google docs Spreadsheets via the "Forms" mechanism

To use this library you need to find your form-id, and your entry id's from the 'Live Form' page source code. Once you have those ids you can upload data to a form like this:

    GoogleFormUploader uploader = new GoogleFormUploader("1AYvV0gFgB1hBuoRKnMsXy1LyF8-Ce8VAshAtho6Z08s");
    uploader.addEntry("1680144410", "Hello Word");
    uploader.addEntry("1558298396", "From android app");
    uploader.upload();
    
but fill in your own form-id and entry ids.