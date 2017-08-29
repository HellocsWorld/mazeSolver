/*
 * File: strinCounter.cpp
 * Author: Raul serrano
 * compiler: NetBeans
 * Created on February 13, 2017, 1:10 PM
 */


//libraries
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

//struct functions
struct TokenFreq
{
  string value;
  int freq;
  
};

//function call
//void selectionSort( vector<TokenFreq> & tokFreqVector );


//main program
int main()
{
   ifstream inFile;
   string txt;
   string linestr;

   cout<< "enter the name of the file"<<endl;
   getline(cin, txt);

   inFile.open("SteveJobsSpeech2005.txt");

   if (inFile.fail()){
      cout<< "Fail to open the file SteveJobsSpeech2005.txt.\n";
      exit(-1);

   }

   while (!inFile.eof()){
      getline(inFile, linestr);
     // vector<TokenFreq> getTokenFreq( linestr);
      cout<<linestr<<"\n";

   }
    
    inFile.close();
   // char * strtok ( linestr, " " );

}





/***
void selectionSort(vector<TokenFreq> & tokFreqVector) {
      int n;
      int i, j, minIndex, tmp;    
      for (i = 0; i < n - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < n; j++)
                  if (arr[j] < arr[minIndex])
                        minIndex = j;
            if (minIndex != i) {
                  tmp = arr[i];
                  arr[i] = arr[minIndex];
                  arr[minIndex] = tmp;
            }
      }
}
***/





