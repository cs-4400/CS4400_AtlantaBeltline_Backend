# CS4400_AtlantaBeltline_Backend

To set up backend make sure you're connected to your local database first and the correct
credentials are inputed as well as make sure it's running else it will start yelling at you.

To set up database:
    1. Go into src/main/java/resources/ and find application.properties file.
    2. You can either follow the instructions there to set up the default profile I set up there or just change
        the username and password credentials to match the ones you use to access mysql workbench
    3. To test right click the sql script titled 'atl_beltline_database.sql' and run it. If you didn't frick up this 
        should run and you should be all set.
        
Once this is all done to start the database just click the run button on top right corner. Intellij should automatically 
figure out your configuration and all you need to do is just press it and your backend should be running. Now you can hit 
the endpoints to your heart's content.