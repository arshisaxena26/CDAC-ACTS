using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;

namespace AdoNetConnectedMode
{
    class Program
    {
        static void Main(string[] args)
        {
            User u = new User();
            u.BindDataConnectedMode();
            Console.ReadLine();
        }

    }

    public class User
    {
        public void BindDataConnectedMode()
        {
            SqlConnection con = null;
            SqlCommand command = null;
            try
            {
                con = new SqlConnection("Data Source=.;Initial Catalog=user_schema; Integrated Security = true;");
                command = new SqlCommand("select * from Users", con);
                con.Open();
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Console.WriteLine(reader["Id"] + " " + reader["Name"] + " " + reader["Address"] + " " + reader["Contact"]);
                }
            }
            catch (Exception e)
            {
		 Console.WriteLine(e.Message);
            }
            finally
            {
                con.Close();
                command.Dispose();
            }
        }
    }
}
