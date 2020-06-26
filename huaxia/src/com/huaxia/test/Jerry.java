package com.huaxia.test;

class WriteTextFile
{
    static void Main()
    {

        string[] lines = { "2", "4", "6" };
        System.IO.File.WriteAllLines(@"C:\Users\Default\Administrator\Test.txt", lines);
                }
            }
}
