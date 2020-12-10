using System;
using System.Collections.Generic;

namespace TemperatureChecker
{
    class TemperatureRecord
    {
        public double tempInFahrenheit;

        public int timeInDays;

        public Dictionary<double, int> tempRecord;

        public TemperatureRecord()
        {
            this.tempInFahrenheit = 97;
            this.timeInDays = 0;
            tempRecord = new Dictionary<double, int>();
        }

        public delegate void TemperatureNotifications(string notification);

        private TemperatureNotifications recordNotifs;

        public void RegisterForNotifications(
            TemperatureNotifications methodToCall
        )
        {
            recordNotifs = methodToCall;
        }

        private void TemperatureRise()
        {
            this.tempInFahrenheit += 1.1;
        }

        private void TemperatureFall()
        {
            this.tempInFahrenheit -= 0.6;
        }

        public void TempRecordGeneration()
        {
            for (int timeInDays = 1; timeInDays <= 5; timeInDays++)
            {
                TemperatureRise();
                recordNotifs("Day : " +timeInDays +" Temperature: " +tempInFahrenheit);
                tempRecord.Add (tempInFahrenheit, timeInDays);
            }

            for (int timeInDays = 6; timeInDays <= 10; timeInDays++)
            {
                TemperatureFall();
                recordNotifs("Day : " +timeInDays +" Temperature: " +tempInFahrenheit);
                tempRecord.Add (tempInFahrenheit, timeInDays);
            }
        }
    }

    class TestTemperatureChecker
    {
        static void Main(string[] args)
        {
            TemperatureRecord record = new TemperatureRecord();
            record
                .RegisterForNotifications(new TemperatureRecord.TemperatureNotifications(RecordGenerationEvent));
            record.TempRecordGeneration();

            double sum=0;
            double maxTemp=97;
            int maxTempDay=0;
            double minTemp=110;
            int minTempDay=0;

            foreach(KeyValuePair<double,int> kvp in record.tempRecord){
                if(maxTemp < kvp.Key){
                    maxTemp = kvp.Key;
                    maxTempDay = kvp.Value;
                }

                if(minTemp > kvp.Key){
                    minTemp = kvp.Key;
                    minTempDay = kvp.Value;
                }

                sum += kvp.Key;
            }

            double avg = sum/record.tempRecord.Count;

            Console.WriteLine("\nMax Temperature Recorded on Day : "+maxTempDay);
            Console.WriteLine("Min Temperature Recorded on Day : "+minTempDay);
            Console.WriteLine("Average Temperature Recorded : "+avg);
        }

        public static void RecordGenerationEvent(string msg)
        {
            Console.WriteLine("=> {0}", msg);
        }
    }
}
