using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdoNetDisconnectedMode
{
    class Program
    {
        static void Main(string[] args)
        {
            User u = new User();
            u.BindDataDisconnectedMode();
            Console.ReadLine();
        }
    }
    public class User
    {
        public void BindDataDisconnectedMode()
        {
            SqlConnection con = null;

            try
            {
                con = new SqlConnection("Data Source=.;Initial Catalog=user_schema; Integrated Security = true;");
                SqlDataAdapter da = new SqlDataAdapter("select * from Users", con);
                DataSet ds = new DataSet();
                da.Fill(ds);

                if(ds != null && ds.Tables.Count !=0 && ds.Tables[0].Rows.Count > 0)
                {
                    for(int i=0; i < ds.Tables[0].Rows.Count; i++)
                    {
                        string id = ds.Tables[0].Rows[i]["Id"].ToString();
                        string name = ds.Tables[0].Rows[i]["Name"].ToString();
                        string address = ds.Tables[0].Rows[i]["Address"].ToString();
                        string contact = ds.Tables[0].Rows[i]["Contact"].ToString();

                        Console.WriteLine(id+" "+name+" "+address+" "+contact);
                    }
                }
              
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}