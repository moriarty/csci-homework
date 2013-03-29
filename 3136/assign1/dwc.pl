#!/usr/bin/perl
# CSCI 3136:  Assignment 1, Question 4
# Distinct Word Counter, dwc.pl
# Programmer: Alex Moriarty
# CSID: moriarty	B00317947
# Date: January 23, 2011

while (<>) 
{
   # Read each Line
   chop;
   # Convert to lower
   tr/A-Z/a-z/;
   # Truncate punctuation
   tr/.,:;!?"(){}//d;
   # Count word occurences
   foreach $word (split) {
      $count{$word}++;    
   }        
}        
# Count just the words which occured
# this is the distinct word count.
$distinct = keys(%count);
# Display the distinct word count.
print "$distinct\n";
