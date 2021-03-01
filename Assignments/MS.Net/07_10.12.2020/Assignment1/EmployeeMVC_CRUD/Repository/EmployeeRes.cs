using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Configuration;
using EmployeeMVC_CRUD.Models;
using System.Data;
using MySql.Data.MySqlClient;

namespace EmployeeMVC_CRUD.Repository
{
    public class EmployeeRes : IEmployee
    {
        private readonly string CS = ConfigurationManager.ConnectionStrings["EmployeeContext"].ConnectionString;

        public IList<Employee> GetEmployees() {

            List<Employee> empList = new List<Employee>();

            using (MySqlConnection con = new MySqlConnection(CS)) {

                MySqlCommand command = new MySqlCommand("select * from employee", con);
                command.CommandType = CommandType.Text;

                con.Open();

                MySqlDataReader reader = command.ExecuteReader();

                while (reader.Read()) {

                    Employee emp = new Employee()
                    {
                        Id = Convert.ToInt32(reader["id"]),
                        Name = reader["name"].ToString(),
                        Age = Convert.ToInt32(reader["age"]),
                        Salary = Convert.ToInt32(reader["salary"])
                    };

                    empList.Add(emp);
                }
            }

            return empList;
        }

        public Employee GetEmployeeById(int id) {

            Employee emp = new Employee();

            using (MySqlConnection con = new MySqlConnection(CS)) {

                MySqlCommand command = new MySqlCommand("select * from employee where id="+id, con);
                command.CommandType = CommandType.Text;

                con.Open();

                MySqlDataReader reader = command.ExecuteReader();

                while (reader.Read()) {

                    emp.Id = Convert.ToInt32(reader["id"]);
                    emp.Name = reader["name"].ToString();
                    emp.Age = Convert.ToInt32(reader["age"]);
                    emp.Salary = Convert.ToInt32(reader["salary"]);
                }
            }

            return emp;
        }

        public void InsertEmployee(Employee Employee) {

            using(MySqlConnection con = new MySqlConnection(CS))
            {
                MySqlCommand command = new MySqlCommand("insert into employee values(default,@name,@age,@salary)", con);
                command.CommandType = CommandType.Text;

                con.Open();

                command.Parameters.AddWithValue("@name",Employee.Name);
                command.Parameters.AddWithValue("@age", Employee.Age);
                command.Parameters.AddWithValue("@salary", Employee.Salary);

                command.ExecuteNonQuery();

            }
        }

        public void UpdateEmployee(Employee Employee)
        {
            using(MySqlConnection con = new MySqlConnection(CS))
            {
                MySqlCommand command = new MySqlCommand("update employee set name=@name,age=@age,salary=@salary where id=@id", con);
                command.CommandType = CommandType.Text;

                con.Open();

                command.Parameters.AddWithValue("@id",Employee.Id);
                command.Parameters.AddWithValue("@name", Employee.Name);
                command.Parameters.AddWithValue("@age", Employee.Age);
                command.Parameters.AddWithValue("@salary", Employee.Salary);

                command.ExecuteNonQuery();
            }

        }

        public void DeleteEmployee(Employee Employee)
        {
            using (MySqlConnection con = new MySqlConnection(CS))
            {
                var cmd = new MySqlCommand("delete from employee where id=@id", con);
                cmd.CommandType = CommandType.Text;

                con.Open();

                cmd.Parameters.AddWithValue("@Id", Employee.Id);
                cmd.ExecuteNonQuery();
            }
        }
    }
}