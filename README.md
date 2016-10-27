# jseeddata
Seed data generator for database - Written in java

Uses Spring boot.

Currently supports MySQL and Oracle.

You have got to create a small JSON file with metadata of the tables to populate. This is a minimalist file.

Post that, the program will create randomized data for the mentioned tables taking care of the relationships and datatypes. 

In future, I plan to provide a UI wherein the metadata will be filled in as a form by the user of this application.
